package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.BuqueViaje;

class EstrategiaMenorTransbordoTest {
		
	Estrategia estrategiaMenorTransbordo;
		
	@BeforeEach
	void setUp() throws Exception {
		estrategiaMenorTransbordo = new EstrategiaMenorTransbordo();
	}
	
	@Test
	void test001_LaEstrategiaDeMenorTiempoSabeCualEsElBuqueViajeQueTardaMenosEnLlegarASuDestino() {
		//Se crean los DOCS de viaje con su duracion, en este caso Stubs
	    BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.cantidadDeTramos()).thenReturn(8);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.cantidadDeTramos()).thenReturn(4);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.cantidadDeTramos()).thenReturn(12);
	    
	    //se agregan a una lista de viajes
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
		assertEquals(estrategiaMenorTransbordo.filtrar(listaDeViajes),viajeStub2);
	}
	
	@Test
	void test002_LaEstrategiaDeMenorTransbordoDevuelveNullSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
		assertEquals(estrategiaMenorTransbordo.filtrar(listaDeViajes),null);
	}

}
