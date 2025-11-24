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

	public ArrayList<BuqueViaje> buscar(FiltroRuta filtroDado) {
		
		ArrayList<BuqueViaje> todosLosViajes = new ArrayList<BuqueViaje>(this.getTerminal().getNavieras().stream()
		        .flatMap(naviera -> naviera.getViajes().stream())
		        .toList());
		
		ArrayList<BuqueViaje> viajesFiltrados = new ArrayList<BuqueViaje>();
		for(BuqueViaje viaje : todosLosViajes) {
			
			if(filtroDado.cumple(viaje)) {
				
				viajesFiltrados.add(viaje);
				
			}
			
		}
		
		ArrayList<BuqueViaje> viajesAdecuados = this.estrategia.filtrar(viajesFiltrados);
		return viajesAdecuados;
		
	}

}
