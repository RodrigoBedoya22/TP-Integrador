package buscadorRutas;

import java.util.ArrayList;
import java.util.List;

import empresa_naviera.BuqueViaje;

public interface Estrategia {
	
	public ArrayList<BuqueViaje> filtrar(ArrayList<BuqueViaje> viajes);

}
