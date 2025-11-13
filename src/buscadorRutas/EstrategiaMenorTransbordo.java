package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorTransbordo implements Estrategia {

	/**
	 * Se realiza un filtrado para obtener aquel viaje dentro de la lista de viajes dada con menor cantidad de tramos. En caso de no
	 * existir, retorna null.
	 */
	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		BuqueViaje menorCantidadDeTramos = viajes.stream().min(Comparator.comparing(BuqueViaje::cantidadDeTramos)).orElse(null);
		return menorCantidadDeTramos;
	}

}
