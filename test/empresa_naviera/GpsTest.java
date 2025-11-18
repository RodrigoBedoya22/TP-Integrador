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
		buque = new Buque("Titanic");
		gps1 = buque.getGPS();
	}

	@Test
	void test001_UnGPSConoceLaCoordenadaQueTiene() {
		
		assertEquals(buque.getGPS().getCoordenadaGPS().getX(), 0.0);
		assertEquals(buque.getGPS().getCoordenadaGPS().getY(), 0.0);
	}
	
	@Test
	void test002_UnGPSCambiaSuCoordenadaAnteriorPorLaCoordenadaActual() {
		
	    Coordenada nuevaCoordenada = new Coordenada(15.9, 47.7);

	    gps1.setCoordenadaGPS(nuevaCoordenada);

	    assertEquals(gps1.getCoordenadaGPS().getX(), 15.9);
	    assertEquals(gps1.getCoordenadaGPS().getY(), 47.7);
	}

}
