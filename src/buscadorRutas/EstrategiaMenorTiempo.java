package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorTiempo implements Estrategia {
	
	/**
	 * Realiza un filtro para devolver la lista de viajes dada, ordenada de menor a mayor, segun el tiempo de cada viaje. En caso de no existir 
	 * devuelve una lista vacia.
	 */
	@Override
	public ArrayList<BuqueViaje> filtrar(ArrayList<BuqueViaje> viajes) {
		
		ArrayList<BuqueViaje> ordenados = new ArrayList<BuqueViaje>(viajes.stream()
		        .sorted(Comparator.comparingDouble(BuqueViaje::getDuracion))
		        .toList());
		return ordenados;
		
	}
	
}
