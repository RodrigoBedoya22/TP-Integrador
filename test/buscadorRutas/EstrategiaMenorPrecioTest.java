package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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
	void test001_LaEstrategiaDeMenorPrecioSabeCualEsElBuqueViajeMásBarato() {
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
	    
		assertEquals(estrategiaMenorPrecio.filtrar(listaDeViajes), viajeStub2);	
	}
	@Test
	void test002_LaEstrategiaDeMenorPrecioDevuelveNullSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
		assertEquals(estrategiaMenorPrecio.filtrar(listaDeViajes),null);
	}

}
