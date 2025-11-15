package empresa_naviera;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import coordenada.Coordenada;

class GpsTest {
	
	GPS gps1;
	Buque buque;
	Coordenada coordenada;

	@BeforeEach
	void setUp() throws Exception {
		
		Coordenada coordenadaGps = new Coordenada(4.5, 5.7);
		Coordenada coordenadaDeBuque = new Coordenada(1.0,2.0);
		buque = new Buque("Titanic", coordenadaDeBuque);
		gps1 = new GPS(coordenadaGps, buque);
	}

	@Test
	void test001_UnGPSConoceLaCoordenadaQueTiene() {
		
		Coordenada coordenadaGps = gps1.coordenadaGPS;
		assertEquals(gps1.getCoordenadaGPS(), coordenadaGps);
	}
	
	@Test
	void test002_UnGPSCambiaSuCoordenadaAnteriorPorLaCoordenadaActual() {
		
		Coordenada coordenadaAnterior = gps1.getCoordenadaGPS();
	    Coordenada nuevaCoordenada = new Coordenada(15.9, 47.7);

	    gps1.setCoordenadaGPS(nuevaCoordenada);

	    assertEquals(nuevaCoordenada, gps1.getCoordenadaGPS());
	    assertNotEquals(coordenadaAnterior, gps1.getCoordenadaGPS());
	}

}
