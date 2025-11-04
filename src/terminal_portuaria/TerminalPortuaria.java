package terminal_portuaria;

import java.util.ArrayList;

import empresa_naviera.EmpresaNaviera;

public class TerminalPortuaria {

	private String nombre;
	private ArrayList<EmpresaNaviera> navieras;
	
	public TerminalPortuaria(String nombre, ArrayList<EmpresaNaviera> navieras) {
		this.nombre = nombre;
		this.navieras = navieras;
		
	}

	public String getNombre() {
		
		return nombre;
	}

	public ArrayList<EmpresaNaviera> navieras() {
		
		return navieras;
	}
	
}
