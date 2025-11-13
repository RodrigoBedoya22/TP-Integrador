package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorTiempo implements Estrategia {
	
	/**
	 * Se realiza un filtrado por una lista de buques dada para buscar aquel viaje con menor duración.
	 */
	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		
		BuqueViaje menorDuracion = viajes.stream().min(Comparator.comparing(BuqueViaje::getDuracion)).orElse(null);
		return menorDuracion;
		
	}

}
