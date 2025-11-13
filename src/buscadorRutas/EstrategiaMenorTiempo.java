package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorTiempo implements Estrategia {
	
	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		
		BuqueViaje menorDuracion = viajes.stream().min(Comparator.comparing(BuqueViaje::getDuracion)).orElse(null);
		return menorDuracion;
		
	}

}
