package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.*;

class EstrategiaMenorPrecioTest {

	Estrategia estrategiaMenorPrecio;
	
	@BeforeEach
	void setUp() throws Exception {
		
	estrategiaMenorPrecio = new EstrategiaMenorPrecio();
		
	}
	
	@Test
	void test001_LaEstrategiaDeMenorPrecioOrdenaLosViajesDeMenorAMayorSegunElPrecio() {
		//Se crean los DOCS de viaje con su duracion, en este caso Stubs
	    BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getPrecio()).thenReturn(200.0);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getPrecio()).thenReturn(100.0);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getPrecio()).thenReturn(300.0);
		
	    //se agregan a una lista de viajes
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub3);
	    
		assertEquals(estrategiaMenorPrecio.filtrar(listaDeViajes), listaDeViajesOrdenados);
	}
	
	@Test
	void test002_LaEstrategiaDeMenorPrecioDevuelveUnaListaVaciaSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
		assertTrue(estrategiaMenorPrecio.filtrar(listaDeViajes).isEmpty() );
	}

}
