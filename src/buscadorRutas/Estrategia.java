package buscadorRutas;

import java.util.ArrayList;

import empresa_naviera.BuqueViaje;

public interface Estrategia {
	
	public BuqueViaje filtrar(ArrayList<BuqueViaje> viajes);

}
