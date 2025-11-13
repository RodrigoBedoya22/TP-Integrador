package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;

class EstrategiaMenorTiempoTest {
	
	Estrategia estrategiaMenorTiempo;
	
	@BeforeEach
	void setUp() throws Exception {
		estrategiaMenorTiempo = new EstrategiaMenorTiempo();
	}

	@Test
	void test001_LaEstrategiaDeMenorTiempoSabeCualEsElBuqueViajeQueTardaMenosEnLlegarASuDestino() {
		//Se crean los DOCS de viaje con su duracion, en este caso Stubs
	    BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(100.0);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(200.0);
	    
	    //se agregan a una lista de viajes
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    
		assertEquals(estrategiaMenorTiempo.filtrar(listaDeViajes),viajeStub1);
		
	}
	@Test
	void test002_LaEstrategiaDeMenorTiempoDevuelveNullSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
		assertEquals(estrategiaMenorTiempo.filtrar(listaDeViajes),null);
	}

}
