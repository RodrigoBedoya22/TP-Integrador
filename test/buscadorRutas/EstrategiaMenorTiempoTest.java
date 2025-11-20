package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;

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
	void test001_LaEstrategiaDeMenorTiempoOrdenaLosViajesDeMenorAMayorSegunEltiempoDeRecorrido() {
		//Se crean los DOCS de viaje con su duracion, en este caso Stubs
	    BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(100);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(200);
	    
	    //se agregan a una lista de viajes
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub1);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub2);
	    
		assertEquals(estrategiaMenorTiempo.filtrar(listaDeViajes), listaDeViajesOrdenados);
	}
	
	@Test
	void test002_LaEstrategiaDeMenorTiempoDevuelveUnaListaVaciaSiNoHayViajes() {
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    
	    assertTrue(estrategiaMenorTiempo.filtrar(listaDeViajes).isEmpty() );
	}

}
