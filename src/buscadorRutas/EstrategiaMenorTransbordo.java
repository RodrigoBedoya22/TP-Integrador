package buscadorRutas;

import java.util.ArrayList;
import java.util.Comparator;

import empresa_naviera.BuqueViaje;

public class EstrategiaMenorTransbordo implements Estrategia {

	@Override
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes) {
		BuqueViaje menorCantidadDeTramos = viajes.stream().min(Comparator.comparing(BuqueViaje::cantidadDeTramos)).orElse(null);
		return menorCantidadDeTramos;
	}

}
