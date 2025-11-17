package nuevo_enfoque_viajes;

import coordenada.Coordenada;

public class CopiaGPS {
	
	Coordenada coordenadaGPS;
	CopiaBuque buqueObservador;
	
	public CopiaGPS(Coordenada coordenadaGPS, CopiaBuque buqueObservador) {
		this.coordenadaGPS = coordenadaGPS;
		this.buqueObservador = buqueObservador;
	}

	public Coordenada getCoordenadaGPS() {
		return coordenadaGPS;
	}

	public void setCoordenadaGPS(Coordenada coordenadaGPS) {
		this.coordenadaGPS = coordenadaGPS;
		notificar();
	}
	
	public void notificar() {
		this.buqueObservador.actualizarCoordenada();
	}

}
