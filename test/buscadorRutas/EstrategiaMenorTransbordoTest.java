package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;

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
	void test001_LaEstrategiaDeMenorTransbordoOrdenaLosViajesDeMenorAMayorSegunSuCantidadDeTramos() {
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
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub3);
	    
	    assertEquals(estrategiaMenorTransbordo.filtrar(listaDeViajes), listaDeViajesOrdenados);
	}
	
	@Test
	void test002_LaEstrategiaDeMenorTransbordoDevuelveNullSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
	    assertTrue(estrategiaMenorTransbordo.filtrar(listaDeViajes).isEmpty() );
	}

}
