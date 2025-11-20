package buscadorRutas;

import java.time.LocalDate;

import empresa_naviera.BuqueViaje;

public class FiltroFechaDeLlegada implements FiltroRuta{

	private LocalDate fechaDeLlegada;
	private String nombreDestino;

	public FiltroFechaDeLlegada(LocalDate fecha, String nombre) {
		this.fechaDeLlegada = fecha;
		this.nombreDestino = nombre;
	}
	
	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		if (viaje.getFechaDeLlegadaA(nombreDestino).isBefore(fechaDeLlegada) || 
				viaje.getFechaDeLlegadaA(nombreDestino).equals(fechaDeLlegada)) {
		       return true;
		}else {
			return false;
		}

	}
}



