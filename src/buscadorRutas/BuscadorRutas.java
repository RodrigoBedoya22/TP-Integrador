package buscadorRutas;

import java.util.ArrayList;

import empresa_naviera.BuqueViaje;
import terminal_portuaria.TerminalPortuaria;

public class BuscadorRutas {
	
	private Estrategia estrategia;
	private TerminalPortuaria terminal;
	
	public BuscadorRutas(TerminalPortuaria terminal) {
		
		this.terminal = terminal;
		this.estrategia = new EstrategiaMenorTiempo();
	}

	public TerminalPortuaria getTerminal() {
		return terminal;
	}

	public Estrategia getEstrategia() {
		
		return this.estrategia;
	}

	public void setEstrategia(Estrategia nuevaEstrategia) {
		
		this.estrategia= nuevaEstrategia;
	}

	/**
	 * Busca aquellos viajes de la lista de viajes de la terminal que cumplan con el filtro dado y los retorna de forma ordenada
	 * segun la estrategia actual del buscador
	 * @param filtroDado
	 * @return
	 */
	public ArrayList<BuqueViaje> buscar(FiltroRuta filtroDado) {
		//toma todos los viajes de la terminal y filtra aquellos que contienen a la misma
		ArrayList<BuqueViaje> todosLosViajes = new ArrayList<BuqueViaje>(this.getTerminal().getNavieras().stream()
		        .flatMap(naviera -> naviera.getViajes().stream())
		        .filter(viaje -> viaje.contieneTramoConDestino(this.getTerminal().getNombre()))
		        .toList());
		
		//todos los viajes que cumplen con los filtros
		ArrayList<BuqueViaje> viajesFiltrados = new ArrayList<BuqueViaje>();
		for(BuqueViaje viaje : todosLosViajes) {
			
			if(filtroDado.cumple(viaje)) {
				
				viajesFiltrados.add(viaje);
				
			}
			
		}
		//se ordenan los viajes segun la estrategia actual
		ArrayList<BuqueViaje> viajesAdecuados = this.estrategia.filtrar(viajesFiltrados);
		return viajesAdecuados;
		
	}

}
