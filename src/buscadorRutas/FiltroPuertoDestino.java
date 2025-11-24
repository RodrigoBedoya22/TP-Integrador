package buscadorRutas;

import empresa_naviera.BuqueViaje;

public class FiltroPuertoDestino implements FiltroRuta {

	private String nombreDelDestino;
	
	public FiltroPuertoDestino(String nombreDelDestino) {
		this.nombreDelDestino = nombreDelDestino;

	}
	
	/**
	 * Indica si el viaje dado contiene al destino indicado
	 */
	public Boolean cumple(BuqueViaje viaje) {
		
		return viaje.contieneTramoConDestino(nombreDelDestino);
	}
}
