package terminal_portuaria;

import java.util.ArrayList;

import empresa_naviera.EmpresaNaviera;
import empresa_transportista.EmpresaTransportista;

public class TerminalPortuaria {

	private String nombre;
	private Coordenada coordenada;
	private ArrayList<EmpresaNaviera> navieras;
	private ArrayList<EmpresaTransportista> empresasTransportistas;
	
	public TerminalPortuaria(String nombre, Coordenada coordenada) {
		this.nombre = nombre;
		this.coordenada = coordenada;
		this.navieras = new ArrayList<EmpresaNaviera>();
		this.empresasTransportistas = new ArrayList<EmpresaTransportista>();
	}
	
	/**
	 * Retorna el nombre de la terminal
	 * @return String nombre, el nombre de la terminal
	 */
	public String getNombre() {
		
		return this.nombre;
	}
	
	/**
	 * Retorna las navieras registradas en la terminal
	 * @return ArrayList<EmpresaNaviera> la lista de navieras registradas en la terminal
	 */
	public ArrayList<EmpresaNaviera> getNavieras() {
		
		return this.navieras;
	}
	
	/**
	 * Retorna las empresas transportistas registradas en la terminal
	 * @return ArrayList<EmpresaTransportista> la lista de empresas transportistas registradas en la terminal
	 */
	public ArrayList<EmpresaTransportista> getEmpresasTransportistas() {
		
		return this.empresasTransportistas;
	}
	
	/**
	 * Agrega una empresa naviera a la terminal gestionada, si la empresa ya está registrada retorna una excepcion.
	 * @param naviera La naviera a agregar
	 */
	public void agregarNaviera(EmpresaNaviera naviera) {
		
		if(this.getNavieras().contains(naviera)) {
			throw new IllegalArgumentException("La empresa naviera ya se encuentra registrada en la terminal");
		}
		else {
			this.navieras.add(naviera);
		}
		
	}
	
	/**
	 * Agrega una empresa transportista a la terminal gestionada, si la empresa ya está registrada retorna una excepcion.
	 * @param empresaTransportista -  La empresa transportista a agregar
	 */
	public void agregarEmpresaTransportista(EmpresaTransportista empresaTransportista) {
		
		if(this.getEmpresasTransportistas().contains(empresaTransportista)) {
			throw new IllegalArgumentException("La empresa transportista ya se encuentra registrada en la terminal");
		}
		else {
			this.empresasTransportistas.add(empresaTransportista);
		}
		
	}

	public Coordenada getCoordenada() {
		
		return this.coordenada;
	}
	
}
