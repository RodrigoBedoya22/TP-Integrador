package empresa_naviera;

import buque.Buque;
import coordenada.Coordenada;

public class GPS {
	
	Coordenada coordenadaGPS;
	Buque buqueObservador;
	
	public GPS(Coordenada coordenadaGPS, Buque buqueObservador) {
		this.coordenadaGPS = coordenadaGPS;
		this.buqueObservador = buqueObservador;
	}

	public Coordenada getCoordenadaGPS() {
		return coordenadaGPS;
	}

	public void setCoordenadaGPS(Coordenada coordenadaGPS) {
		this.coordenadaGPS = coordenadaGPS;
	}

}
