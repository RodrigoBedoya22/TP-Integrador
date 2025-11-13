package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorPrecio implements Estrategia {
	
	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		
		BuqueViaje menorPrecio = viajes.stream().min(Comparator.comparing(BuqueViaje::getPrecio)).orElse(null);
		return menorPrecio;
		
	}

}
