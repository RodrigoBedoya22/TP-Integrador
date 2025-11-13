package buscadorRutas;

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
	
	

}
