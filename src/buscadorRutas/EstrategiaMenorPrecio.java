package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorPrecio implements Estrategia {
	
	/**
	 * Realiza un filtro para buscar el viaje con menor precio dentro de una lista de viajes dada. En caso de no existir devuelve null.
	 */
	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		
		BuqueViaje menorPrecio = viajes.stream().min(Comparator.comparing(BuqueViaje::getPrecio)).orElse(null);
		return menorPrecio;
		
	}

}
