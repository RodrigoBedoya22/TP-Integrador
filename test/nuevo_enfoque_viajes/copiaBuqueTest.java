package nuevo_enfoque_viajes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import coordenada.*;

class copiaBuqueTest {

	CopiaTerminalPortuaria terminalA, terminalB, terminalC, terminalD;
	CopiaTramo tramoAB, tramoBC, tramoCA, tramoDB;
	CopiaBuque buque;
	CopiaBuqueViaje viaje;
	
	@BeforeEach
	void setUp() throws Exception {
		terminalA = new CopiaTerminalPortuaria("Terminal A", new Coordenada(10, 222));
		terminalB = new CopiaTerminalPortuaria("Terminal B", new Coordenada(102, 5));
		terminalC = new CopiaTerminalPortuaria("Terminal C", new Coordenada(0, 33));
		terminalD = new CopiaTerminalPortuaria("Terminal D", new Coordenada(56, 73));
		
		
		tramoAB = new CopiaTramo(terminalA, terminalB, 10000.0);
		tramoBC = new CopiaTramo(terminalB, terminalC, 10000.0);
		tramoCA = new CopiaTramo(terminalC, terminalA, 10000.0);
		tramoDB = new CopiaTramo(terminalD, terminalB, 10000.0);
		
		ArrayList<CopiaTramo> listaDeTramos= new ArrayList<CopiaTramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CopiaCircuitoMaritimo circuito = new CopiaCircuitoMaritimo(listaDeTramos);
		
		buque= new CopiaBuque("Copia Titanic");
		viaje = new CopiaBuqueViaje(buque, circuito, LocalDate.of(2025, 12, 1) );
		buque.setViaje(viaje);
		
	}

	@Test
	void test001_CuandoLaCoordenadaDeUnGPSCambia_LaCoordenadaDeSuBuqueCambia() {
		//empieza en 0,0
		assertEquals(buque.getCoordenada().getX(), 0.0);
		assertEquals(buque.getCoordenada().getY(), 0.0);
		
		//cambio la coordenada del gps
		Coordenada cor = new Coordenada(10, 122);
		buque.getGPS().setCoordenadaGPS(cor);
		
		//verifico el cambio
		assertEquals(buque.getCoordenada().getX(), 10.0);
		assertEquals(buque.getCoordenada().getY(), 122.0);
		
	}
	
	@Test
	void test002_UnBuqueConoceSuViaje() {
		assertEquals(buque.getViaje(), viaje);
	}
	
	@Test
	void test003_CuandoUnBuqueSeEncuentraA50KmOMasDeSuDestino_SeEncuentraEnEstadoOutbound() {
		
		// El destino es Coordenada (102,5)
		//seteo la distancia en 100 km
		Coordenada cor= new Coordenada(2, 5); 
		buque.getGPS().setCoordenadaGPS(cor);
		
		assertEquals(buque.distanciaHaciaDestinoActual(), 100.0);
		assertInstanceOf(CopiaOutOfBound.class, buque.getEstado());
		
	}
	
	@Test
	void test004_CuandoUnBuqueSeEncuentraAMenosDe50KmDeSuDestino_SeEncuentraEnEstadoInBound() {
		// El destino es Coordenada (102,5)
		//seteo la distancia en 49km
		Coordenada cor= new Coordenada(53, 5); 
		buque.getGPS().setCoordenadaGPS(cor);
				
		assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
		assertInstanceOf(CopiaInBound.class, buque.getEstado());
	}
	
	@Test
	void test005_SiElBuqueEstáEnEstadoInBoundYSeAleja_VuelveAEstadoOutbound() {
		// El destino es Coordenada (102,5)
		//seteo la distancia en 100 km
		Coordenada cor= new Coordenada(53, 5); 
		buque.getGPS().setCoordenadaGPS(cor);
				
		assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
		assertInstanceOf(CopiaInBound.class, buque.getEstado());
		
		//se setea en 100 denuevo
		Coordenada corNueva= new Coordenada(2,5);
		buque.getGPS().setCoordenadaGPS(corNueva);;
		
		//cambia de estado
		assertEquals(buque.distanciaHaciaDestinoActual(), 100.0);
		assertInstanceOf(CopiaOutOfBound.class, buque.getEstado());
	}
	
	@Test
	void test006_SiUnBuqueEstaEnEstadoInBoundYSuCoordenadaSeVuelveExactamenteLaMismaDeSuDestino_PasaAEstadoArrived() {
		// El destino es Coordenada (102,5)
		//seteo la distancia en 49km
		Coordenada cor= new Coordenada(53, 5); 
		buque.getGPS().setCoordenadaGPS(cor);
						
		assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
		assertInstanceOf(CopiaInBound.class, buque.getEstado());
				
		//se setea en la misma coordenada
		Coordenada corNueva= new Coordenada(102,5);
		buque.getGPS().setCoordenadaGPS(corNueva);
				
				//cambia de estado
		assertEquals(buque.distanciaHaciaDestinoActual(), 0.0);
		assertInstanceOf(CopiaArrived.class, buque.getEstado());
	}
	
	@Test
	void test007_SiUnBuqueEstaArrivedYLaTerminalLeDiceQueSePongaEnWorking_ElEstadoDeUnBuqueCambiaAWorking() {
		//se setea en la misma coordenada
		buque.setEstado(new CopiaInBound());
		Coordenada corNueva= new Coordenada(102,5);
		buque.getGPS().setCoordenadaGPS(corNueva);
		
		assertInstanceOf(CopiaArrived.class, buque.getEstado());
		
		//le manda el mensaje
		terminalB.ponerEnWorking(buque);
		assertEquals(buque.distanciaHaciaDestinoActual(), 0.0);
		assertInstanceOf(CopiaWorking.class, buque.getEstado());
	}
	
	@Test
	void test008_SiUnBuqueEstaWorkingYLaTerminalLeDiceQueSePongaEnDepart_ElEstadoDeUnBuqueCambiaADepart() {
		//se setea en la misma coordenada
		buque.setEstado(new CopiaWorking());
		assertInstanceOf(CopiaWorking.class, buque.getEstado());
		
		//le manda el mensaje
		terminalB.PonerEnDeparting(buque);
		assertInstanceOf(CopiaDeparting.class, buque.getEstado());
	}
	@Test
	void test009_SiUnBuqueEstaEnDepartingYSeAlejaEn50Km_ElEstadoDeUnBuqueCambiaOutBoundYElTramoDelViajeDelBuqueCambia() {
		//se setea en la misma coordenada
		buque.setEstado(new CopiaWorking());
		assertInstanceOf(CopiaWorking.class, buque.getEstado());
		terminalB.PonerEnDeparting(buque);
		assertInstanceOf(CopiaDeparting.class, buque.getEstado());
		
		//setear distancia hacia 51 KM
		Coordenada cor= new Coordenada(51,5);
		buque.getGPS().setCoordenadaGPS(cor);
		assertInstanceOf(CopiaOutOfBound.class, buque.getEstado());
	}

}
