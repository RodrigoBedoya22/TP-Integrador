package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.*;
import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import terminal_portuaria.*;

class BuqueTest {
	
	Buque buque;
	Contenedor contenedorDry;
	Contenedor contenedorReefer;
	Contenedor contenedorTanque;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Coordenada coordenadaDeBuque = new Coordenada(1.0,2.0);
		buque= new Buque("Titanic", coordenadaDeBuque);
		contenedorDry = mock(Dry.class);
		contenedorReefer = mock(Reefer.class);
		contenedorTanque = mock(Tanque.class);
	}

	@Test
	void test001_UnBuqueConoceSuNombre() {
		
		assertEquals(buque.getNombre(), "Titanic");
	}
	
	@Test
	void test002_UnBuqueConoceSuCoordenada() {
		
		assertEquals(buque.getCoordenada().getX(), 1.0);
		assertEquals(buque.getCoordenada().getY(), 2.0);
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
	void test007_CuandoSeLeDiceAUnBuqueQueCambieDeEstado_DelegaElCambioASuEstadoActual() {
		//seteo el estado como un mock
		OutOfBound estadoOutBound = mock(OutOfBound.class);
		buque.setEstado(estadoOutBound);
		
		buque.pasarAEstadoInBound();
		
        verify(buque.getEstado()).pasarAEstadoInBound(buque);
	}
}
