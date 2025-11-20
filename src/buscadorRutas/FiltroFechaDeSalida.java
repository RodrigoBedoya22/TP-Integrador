package buscadorRutas;

import java.time.LocalDate;

import empresa_naviera.BuqueViaje;


public class FiltroFechaDeSalida implements FiltroRuta{
	

	private LocalDate fechaDeSalida;
	private String nombreDeLaTerminal;

	public FiltroFechaDeSalida(LocalDate fecha, String nombre) {
		this.fechaDeSalida = fecha;
		this.nombreDeLaTerminal = nombre;
	}

	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		if (viaje.getFechaDeLlegadaA(nombreDeLaTerminal).isBefore(fechaDeSalida) || 
				viaje.getFechaDeLlegadaA(nombreDeLaTerminal).equals(fechaDeSalida)) {
		       return true;
		}else {
			return false;
		}

	}


}
