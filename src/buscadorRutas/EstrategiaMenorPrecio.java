package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorPrecio implements Estrategia {
	
	/**
	 * Realiza un filtro para devolver la lista de viajes dada, ordenada de menor a mayor, segun el precio de cada viajes. En caso de no existir 
	 * devuelve una lista vacia.
	 */
	@Override
	public ArrayList<BuqueViaje> filtrar(ArrayList<BuqueViaje> viajes) {
		
		ArrayList<BuqueViaje> ordenados = new ArrayList<BuqueViaje>(viajes.stream()
		        .sorted(Comparator.comparingDouble(BuqueViaje::getPrecio))
		        .toList());
		return ordenados;
		
	}

}
