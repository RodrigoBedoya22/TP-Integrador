package buscadorRutas;

import java.time.LocalDate;

import empresa_naviera.BuqueViaje;


public class FiltroFechaDeSalida implements FiltroRuta{
	

	private LocalDate fechaDeSalida;
	private String nombreDeLaTerminal;

	/**
	 * Constructor del filtro fecha de salida
	 * @param fecha - La fecha a evaluar si el viaje saldra de terminal dada, o si sale antes de dicha fecha.
	 * @param nombre - El nombre de la terminal dentro de un viaje de cual se evaluara si su fecha de salida es igual o menor a la fecha dada.
	 */
	public FiltroFechaDeSalida(LocalDate fecha, String nombre) {
		this.fechaDeSalida = fecha;
		this.nombreDeLaTerminal = nombre;
	}

	/**
	 * Indica si la fecha de salida de un viaje desde una terminal con nombre dado sale en la fecha dada, o antes.
	 */
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
