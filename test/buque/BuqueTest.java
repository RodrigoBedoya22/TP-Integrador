package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.*;
import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import empresa_naviera.CircuitoMaritimo;
import empresa_naviera.Tramo;
import terminal_portuaria.*;

class BuqueTest {
	
	Buque buque;
	Contenedor contenedorDry;
	Contenedor contenedorReefer;
	Contenedor contenedorTanque;
	TerminalPortuaria terminalA, terminalB, terminalC, terminalD;
	Tramo tramoAB, tramoBC, tramoCA, tramoDB;
	BuqueViaje viaje;
	
	@BeforeEach
	void setUp() throws Exception {
		buque= new Buque("Titanic");
		contenedorDry = mock(Dry.class);
		contenedorReefer = mock(Reefer.class);
		contenedorTanque = mock(Tanque.class);
	    
		terminalA = new TerminalPortuaria("Terminal A", new Coordenada(10, 222));
		terminalB = new TerminalPortuaria("Terminal B", new Coordenada(102, 5));
		terminalC = new TerminalPortuaria("Terminal C", new Coordenada(0, 33));
		terminalD = new TerminalPortuaria("Terminal D", new Coordenada(56, 73));
		
		
		tramoAB = new Tramo(terminalA, terminalB, 10000.0);
		tramoBC = new Tramo(terminalB, terminalC, 10000.0);
		tramoCA = new Tramo(terminalC, terminalA, 10000.0);
		tramoDB = new Tramo(terminalD, terminalB, 10000.0);
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		viaje = new BuqueViaje(buque, circuito, LocalDate.of(2025, 12, 1) );
		buque.setViaje(viaje);
	}

	@Test
	void test001_UnBuqueConoceSuNombre() {
		
		assertEquals(buque.getNombre(), "Titanic");
	}
	
	@Test
	void test002_UnBuqueConoceSuCoordenada() {
		
		assertEquals(buque.getCoordenada().getX(), 0.0);
		assertEquals(buque.getCoordenada().getY(), 0.0);
	}
	
	@Test
	void test003_UnBuqueConoceLosContenedoresQueTiene() {
        
		buque.agregarContenedor(contenedorDry);
		buque.agregarContenedor(contenedorReefer);
		buque.agregarContenedor(contenedorTanque);
		
        assertEquals(3, buque.getContenedores().size());
        
        assertTrue(buque.getContenedores().contains(contenedorDry));
        assertTrue(buque.getContenedores().contains(contenedorReefer));
        assertTrue(buque.getContenedores().contains(contenedorTanque));
	}
	
	@Test
	void test004_CuandoUnBuqueSacaUnContenedor_SuListaDeContenedoresDisminuye() {
		buque.agregarContenedor(contenedorDry);
		buque.agregarContenedor(contenedorReefer);
		buque.agregarContenedor(contenedorTanque);
		buque.sacarContenedor(contenedorDry);
		
        assertEquals(2, buque.getContenedores().size());
        
        assertFalse(buque.getContenedores().contains(contenedorDry));
        assertTrue(buque.getContenedores().contains(contenedorReefer));
        assertTrue(buque.getContenedores().contains(contenedorTanque));
	}
	
	@Test
	void test005_CuandoUnBuqueEsCreado_PoseeElEstadoOutBoundPorDefault() {
		
        assertInstanceOf(OutOfBound.class, buque.getEstado());
	}
	
	@Test
	void test006_UnBuqueConoceSuEstado() {
		
        assertInstanceOf(OutOfBound.class, buque.getEstado());
	}

	@Test
	void test007_CuandoLaCoordenadaDeUnGPSCambia_LaCoordenadaDeSuBuqueCambia() {
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
	void test008_UnBuqueConoceSuViaje() {
		assertEquals(buque.getViaje(), viaje);
	}
		
	@Test
	void test009_CuandoUnBuqueSeEncuentraA50KmOMasDeSuDestino_SeEncuentraEnEstadoOutbound() {
			
	// El destino es Coordenada (102,5)
	//seteo la distancia en 100 km
	Coordenada cor= new Coordenada(2, 5); 
	buque.getGPS().setCoordenadaGPS(cor);
			
	assertEquals(buque.distanciaHaciaDestinoActual(), 100.0);
	assertInstanceOf(OutOfBound.class, buque.getEstado());
			
	}
		
	@Test
	void test010_CuandoUnBuqueSeEncuentraAMenosDe50KmDeSuDestino_SeEncuentraEnEstadoInBound() {
	// El destino es Coordenada (102,5)
	//seteo la distancia en 49km
	Coordenada cor= new Coordenada(53, 5); 
	buque.getGPS().setCoordenadaGPS(cor);
					
	assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
	assertInstanceOf(InBound.class, buque.getEstado());
	}
		
	@Test
	void test011_SiElBuqueEstáEnEstadoInBoundYSeAleja_VuelveAEstadoOutbound() {
	// El destino es Coordenada (102,5)
	//seteo la distancia en 100 km
	Coordenada cor= new Coordenada(53, 5); 
	buque.getGPS().setCoordenadaGPS(cor);
					
	assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
	assertInstanceOf(InBound.class, buque.getEstado());
			
	//se setea en 100 denuevo
	Coordenada corNueva= new Coordenada(2,5);
	buque.getGPS().setCoordenadaGPS(corNueva);;
			
	//cambia de estado
	assertEquals(buque.distanciaHaciaDestinoActual(), 100.0);
	assertInstanceOf(OutOfBound.class, buque.getEstado());
    }
		
	@Test
	void test012_SiUnBuqueEstaEnEstadoInBoundYSuCoordenadaSeVuelveExactamenteLaMismaDeSuDestino_PasaAEstadoArrived() {
	// El destino es Coordenada (102,5)
	//seteo la distancia en 49km
	Coordenada cor= new Coordenada(53, 5); 
	buque.getGPS().setCoordenadaGPS(cor);
						
	assertEquals(buque.distanciaHaciaDestinoActual(), 49.0);
	assertInstanceOf(InBound.class, buque.getEstado());
					
	//se setea en la misma coordenada
	Coordenada corNueva= new Coordenada(102,5);
	buque.getGPS().setCoordenadaGPS(corNueva);
					
	//cambia de estado
	assertEquals(buque.distanciaHaciaDestinoActual(), 0.0);
	assertInstanceOf(Arrived.class, buque.getEstado());
    }
		
	@Test
	void test013_SiUnBuqueEstaArrivedYLaTerminalLeDiceQueSePongaEnWorking_ElEstadoDeUnBuqueCambiaAWorking() {
	//se setea en la misma coordenada
	buque.setEstado(new InBound());
	Coordenada corNueva= new Coordenada(102,5);
	buque.getGPS().setCoordenadaGPS(corNueva);
			
	assertInstanceOf(Arrived.class, buque.getEstado());
			
	//le manda el mensaje
	terminalB.ponerEnWorking(buque);
	assertEquals(buque.distanciaHaciaDestinoActual(), 0.0);
	assertInstanceOf(Working.class, buque.getEstado());
	}
		
	@Test
	void test014_SiUnBuqueEstaWorkingYLaTerminalLeDiceQueSePongaEnDepart_ElEstadoDeUnBuqueCambiaADepart() {
	//se setea en la misma coordenada
	buque.setEstado(new Working());
	assertInstanceOf(Working.class, buque.getEstado());
			
	//le manda el mensaje
	terminalB.PonerEnDeparting(buque);
	assertInstanceOf(Departing.class, buque.getEstado());
	}
	
	@Test
	void test015_SiUnBuqueEstaEnDepartingYSeAlejaEn50Km_ElEstadoDeUnBuqueCambiaOutBoundYElTramoDelViajeDelBuqueCambia() {
	//se setea en la misma coordenada
	buque.setEstado(new Working());
			assertInstanceOf(Working.class, buque.getEstado());
			terminalB.PonerEnDeparting(buque);
			assertInstanceOf(Departing.class, buque.getEstado());
			
	//setear distancia hacia 51 KM
	Coordenada cor= new Coordenada(51,5);
	buque.getGPS().setCoordenadaGPS(cor);
	assertInstanceOf(OutOfBound.class, buque.getEstado());
	}
	
	
}
