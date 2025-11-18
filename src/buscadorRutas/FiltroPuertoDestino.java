package buscadorRutas;

import java.util.Date;

import empresa_naviera.BuqueViaje;
import terminal_portuaria.TerminalPortuaria;

public class FiltroPuertoDestino implements FiltroRuta {

	private String nombreDelDestino;
	
	public FiltroPuertoDestino(String nombreDelDestino) {
		this.nombreDelDestino = nombreDelDestino;

	}

	public Boolean cumple(BuqueViaje viaje) {
		
		return viaje.contieneTramoConDestino(nombreDelDestino);
	}
}
