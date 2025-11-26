package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cliente.Cliente;
import contenedor.*;
import coordenada.Coordenada;
import empresa_naviera.*;
import empresa_transportista.*;
import orden.*;
import reportes.ReporteAduana;
import servicio.*;
import terminal_portuaria.*;

class BuqueTest {
	
	Buque buque;
	Contenedor contenedorDry, contenedorReefer, contenedorTanque;
	TerminalPortuaria terminalA, terminalB, terminalC, terminalD, terminalBSpy;
	Tramo tramoAB, tramoBC, tramoCA, tramoDB;
	BuqueViaje viaje;
	Camion camion;
	Chofer chofer;
	Cliente cliente;
	OrdenImportacion orden; 
	String nombreDeTerminalOrigen;
	String nombreDeTerminalDestino;
	ArrayList<Servicio> servicios;
	
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
		terminalBSpy= spy(terminalB);
		when(terminalBSpy.getNombre()).thenReturn("Terminal B");
		
		tramoAB = new Tramo(terminalA, terminalBSpy, 10000.0);
		tramoBC = new Tramo(terminalBSpy, terminalC, 10000.0);
		tramoCA = new Tramo(terminalC, terminalA, 10000.0);
		tramoDB = new Tramo(terminalD, terminalB, 10000.0);
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		viaje = new BuqueViaje(buque, circuito, LocalDate.of(2025, 12, 1) );
		buque.setViaje(viaje);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		servicios = new ArrayList<Servicio>();
		nombreDeTerminalOrigen = "Terminal A";
		nombreDeTerminalDestino = "Terminal B";
		
		orden = new OrdenImportacion(cliente, contenedorDry, camion, chofer, servicios, viaje, nombreDeTerminalOrigen, nombreDeTerminalDestino);

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
	void test003_UnBuqueConoceLasOrdenesQueTiene() {
        
		buque.agregarOrden(orden);
		
        assertEquals(1, buque.getOrdenes().size());

	}
	
	@Test
	void test004_CuandoUnBuqueSacaUnaOrden_SuListaDeOrdenesDisminuye() {
		buque.agregarOrden(orden);
		buque.sacarOrden(orden);
		
        assertEquals(0, buque.getOrdenes().size());
        
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
	
	@Test
	void test016_CuandoUnBuqueEntraEnFaseDeInBound_NotificaALaTerminalParaQueAviseALosClientesQueRealizanUnaImportacionConElViajeActual() {

		Cliente pepe= new Cliente("Pepe", 12345678, "pepe24@gmail.com");
		Camion camion= mock(Camion.class);
		Chofer chofer= mock(Chofer.class);
		ArrayList<Servicio> listaDeServicios= new ArrayList<Servicio>();
		OrdenImportacion orden= new OrdenImportacion(pepe, contenedorDry, camion, chofer,
				                          listaDeServicios, viaje, terminalA.getNombre(), terminalBSpy.getNombre());
		terminalBSpy.registrarOrden(orden);
		// El destino es terminalB con Coordenada (102,5)
		//seteo la distancia en 49km
		//entra en estado inbound
		Coordenada cor= new Coordenada(53, 5); 
		buque.getGPS().setCoordenadaGPS(cor);
		
		verify(terminalBSpy).notificarImportaciones(viaje);
		verify(terminalBSpy).notificarImportacionA(orden);	
	}
	
	@Test
	void test017_CuandoUnBuqueEntraEnFaseDeOutBound_NotificaALaTerminalParaQueAviseALosShippersQueSuCargaSalió() {

		Cliente pepe= new Cliente("Pepe", 12345678, "pepe24@gmail.com");
		Camion camion= mock(Camion.class);
		Chofer chofer= mock(Chofer.class);
		Servicio lavado = new Lavado("Lavado", 400);
		ArrayList<Servicio> listaDeServicios= new ArrayList<Servicio>();
		listaDeServicios.add(lavado);
		OrdenExportacion orden= new OrdenExportacion(pepe, contenedorDry, camion, chofer,
				                          listaDeServicios, viaje, terminalBSpy.getNombre(), terminalC.getNombre() );
		terminalBSpy.registrarOrden(orden);
		
		//se setea en arrived y cambia a departing al final
		buque.setEstado(new Arrived());
		buque.getGPS().setCoordenadaGPS(terminalBSpy.getCoordenada());
		terminalBSpy.ponerEnWorking(buque);
		terminalBSpy.PonerEnDeparting(buque);
				
		//setea el estado en out of bound
		buque.getGPS().setCoordenadaGPS(new Coordenada(51,5));
		
		//se verifica que al pasar de departing a outbound se envian las notificaciones
		verify(terminalBSpy).notificarExportaciones(viaje);
		verify(terminalBSpy).notificarExportacionA(orden);	
	}
	
	@Test
	void test018_CuandoUnBuqueSePasaAEstadoWorkingSeAgreganLasOrdenesAExportarASuListaDeOrdenes() {
		
		Cliente pepe= new Cliente("Pepe", 12345678, "pepe24@gmail.com");
		Camion camion= mock(Camion.class);
		Chofer chofer= mock(Chofer.class);
		Servicio lavado = new Lavado("Lavado", 400);
		ArrayList<Servicio> listaDeServicios= new ArrayList<Servicio>();
		listaDeServicios.add(lavado);
		Arrived arrived= new Arrived();
		OrdenExportacion orden= new OrdenExportacion(pepe, contenedorDry, camion, chofer,
				                          listaDeServicios, viaje, terminalB.getNombre(), terminalC.getNombre());
		
		
		terminalB.registrarOrden(orden);
		
		//se setea en arrived y cambia a working al final
		
		Arrived arrivedSpy = spy(arrived);
		buque.setEstado(arrivedSpy);
		buque.getGPS().setCoordenadaGPS(terminalB.getCoordenada());
		terminalB.ponerEnWorking(buque);
		
		assertEquals(1,buque.getOrdenes().size());
	}
	
	@Test
	void test019_CuandoUnBuqueSePasaAEstadoWorkingSeEliminenLasOrdenesAImportarASuListaDeOrdenes() {
		
		Cliente pepe= new Cliente("Pepe", 12345678, "pepe24@gmail.com");
		Camion camion= mock(Camion.class);
		Chofer chofer= mock(Chofer.class);
		Servicio lavado = new Lavado("Lavado", 400);
		ArrayList<Servicio> listaDeServicios= new ArrayList<Servicio>();
		listaDeServicios.add(lavado);
		Arrived arrived= new Arrived();
		OrdenExportacion orden= new OrdenExportacion(pepe, contenedorDry, camion, chofer,
				                          listaDeServicios, viaje, terminalA.getNombre(), terminalB.getNombre());
		
		
		terminalB.registrarOrden(orden);
		
		//se setea en arrived y cambia a working al final
		
		Arrived arrivedSpy = spy(arrived);
		buque.setEstado(arrivedSpy);
		buque.getGPS().setCoordenadaGPS(terminalB.getCoordenada());
		terminalB.ponerEnWorking(buque);
		
		assertEquals(0,buque.getOrdenes().size());
		
	}
	
	@Test
	void test020_SiUnBuquePermiteElAccesoDeUnReporte_ElReporteLoVisitaráParaObtenerSusDatos() {
		ReporteAduana reporte = new ReporteAduana();
		ReporteAduana reporteSpy= spy(reporte);
		
		buque.aceptar(reporteSpy);
		verify(reporteSpy).visitarBuque(buque);
	}
	
	
}
