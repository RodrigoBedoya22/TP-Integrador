package terminal_portuaria;

import java.util.ArrayList;

import empresa_naviera.EmpresaNaviera;

public class TerminalPortuaria {

	private String nombre;
	private ArrayList<EmpresaNaviera> navieras;
	
	public TerminalPortuaria(String nombre) {
		this.nombre = nombre;
		this.navieras = new ArrayList<EmpresaNaviera>();
		
	}

	public String getNombre() {
		
		return this.nombre;
	}

	public ArrayList<EmpresaNaviera> getNavieras() {
		
		return this.navieras;
	}

	public void agregarNaviera(EmpresaNaviera naviera) {
		
		this.navieras.add(naviera);
		
	}
	
}
