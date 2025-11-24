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

	/**
	 * Retorna la coordenada actual del gps
	 * @return Coordenada - La coordenada actual del GPS
	 */
	public Coordenada getCoordenadaGPS() {
		return coordenadaGPS;
	}
	
	/**
	 * Reemplaza la coordenada actual por una nueva coordenada. Si el gps tiene un buque observador, notifica su cambio de coordenada al mismo.
	 * @param coordenadaGPS - La coordenada por la que se reemplazará su anterior coordenada.
	 */
	public void setCoordenadaGPS(Coordenada coordenadaGPS) {
		this.coordenadaGPS = coordenadaGPS;
		if (this.buqueObservador != null && buqueObservador.getViaje() != null) {
			notificar();
	    }
		
	}
	
	/**
	 * Notifica a su buque observador el cambio de coordenada del gps.
	 */
	public void notificar() {
		this.buqueObservador.actualizarCoordenada();
	}

}
