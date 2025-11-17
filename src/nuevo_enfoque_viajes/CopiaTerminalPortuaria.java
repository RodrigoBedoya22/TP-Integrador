package nuevo_enfoque_viajes;

import java.util.ArrayList;


import cliente.Cliente;
import contenedor.Contenedor;
import coordenada.Coordenada;
import empresa_naviera.EmpresaNaviera;
import empresa_transportista.*;
import orden.*;

public class CopiaTerminalPortuaria {

	private String nombre;
	private Coordenada coordenada;
	private ArrayList<EmpresaNaviera> navieras;
	private ArrayList<EmpresaTransportista> empresasTransportistas;
	private ArrayList<Camion> camiones;
	private ArrayList<Orden> ordenesRegistradas;
	private ArrayList<Contenedor> contenedoresRegistrados;
	private ArrayList<Cliente> shippersRegistrados;
	private ArrayList<Cliente> consigneesRegistrados;
	
	/**
	 * Constructor de una termina portuaria
	 * @param nombre - El nombre de la terminal
	 * @param coordenada - La coordenada de la terminal
	 * NOTA: Una terminal portuaria se isntancia con sus listas vacias.
	 */
	public CopiaTerminalPortuaria(String nombre, Coordenada coordenada) {
		this.nombre = nombre;
		this.coordenada = coordenada;
		this.navieras = new ArrayList<EmpresaNaviera>();
		this.empresasTransportistas = new ArrayList<EmpresaTransportista>();
		this.camiones = new ArrayList<Camion>();
		this.ordenesRegistradas = new ArrayList<Orden>();
		this.contenedoresRegistrados = new ArrayList<Contenedor>();
		this.shippersRegistrados = new ArrayList<Cliente>();
		this.consigneesRegistrados = new ArrayList<Cliente>();
	}
	
	/**
	 * Retorna el nombre de la terminal
	 * @return String nombre, el nombre de la terminal
	 */
	public String getNombre() {
		
		return this.nombre;
	}
	
	/**
	 * Retorna la coordenada de la terminal
	 * @return Coordenada coordenada, la coordenada de la terminal
	 */
    public Coordenada getCoordenada() {
		
		return this.coordenada;
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
	 * Retorna los camiones registrados en la terminal
	 * @return ArrayList<Camion> la lista de camiones registrados en la terminal
	 */
	public ArrayList<Camion> getCamiones() {
			
			return this.camiones;
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
	 * Elimina una empresa naviera de la lista de navieras de la terminal.
	 * @param naviera - La naviera a eliminar de la lista de navieras de la terminal.
	 */
	public void eliminarNaviera(EmpresaNaviera naviera) {
		
		this.navieras.remove(naviera);
		
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
	
	/**
	 * Elimina una empresa transportista de la lista de empresas transportistas de la terminal.
	 * @param transportista - La transportista a eliminar de la lista de transportistas de la terminal
	 */
	public void eliminarEmpresaTransportista(EmpresaTransportista transportista) {
		
		this.empresasTransportistas.remove(transportista);
		
	}

	/**
	 * Al llegar un camion, se registra en la terminal.
	 * @param camion - El camion a registrar en la lista de camiones
	 */
	public void registrarCamion(Camion camion) {
		
		if(this.getCamiones().contains(camion)){
			throw new IllegalArgumentException("El camion ya se encuentra registrado en la lista de camiones en la terminal");
		}
		else {
			this.camiones.add(camion);
		}
		
	}
	
	/**
	 * Al retirarse un camion, se elimina de la lista de camiones de la terminal.
	 * @param camion - El camion a eliminar
	 */
	public void eliminarCamion(Camion camion) {
		
		this.camiones.remove(camion);
		
	}
	
	/**
	 * Retorna la distancia hacia otra terminal, basandose en las coordenadas de las mismas.
	 * @param terminal - La terminal hacia la cual se calculará la distancia
	 * @return double - La distancia hacia la terminal dada.
	 * NOTA: Por convencion el numero retornado es en dias.
	 */
	public double distanciaHastaTerminal(CopiaTerminalPortuaria terminal) {
		double distancia = this.coordenada.distanciaHaciaCoordenada(terminal.getCoordenada());
		return distancia;
	}
	
	/**
	 * Registra una orden en la lista de ordenes de la terminal
	 * @param orden - La orden a registrar
	 */
	public void registrarOrden(Orden orden) {
		
		this.ordenesRegistradas.add(orden);
		
	}
	
	/**
	 * Registra un contenedor en la terminal
	 * @param contenedor - El contenedor a registrar
	 */
	public void registrarContenedor(Contenedor contenedor) {
		
		this.contenedoresRegistrados.add(contenedor);
		
	}
	
	/**
	 * Retorna la lista de contenedores en campo de la terminal (aquellos que esperan a ser retirados o exportados)
	 * @return - La lista de contenedores en campo de la terminal.
	 */
	public ArrayList<Contenedor> getContenedores() {
		
		return this.contenedoresRegistrados;
	}
	
    public ArrayList<Orden> getOrdenes() {
		
		return this.ordenesRegistradas;
	}
    
    public void registrarShipper(Cliente shipper) {
		
    	this.shippersRegistrados.add(shipper);
		
	}
    
    public ArrayList<Cliente> getShippers() {
		
		return this.shippersRegistrados;
	}
    
    public ArrayList<Cliente> getConsignees() {
    	
		
    	return this.consigneesRegistrados;
	}
    
    public void registrarConsignee(Cliente consignee) {
		
		this.consigneesRegistrados.add(consignee);
		
	}
	

	public void eliminarContenedor(Contenedor contenedor) {
		
		this.contenedoresRegistrados.remove(contenedor);
		
	}
	
	/**
	 * Pone a trabajar en carga y descarga a un buque
	 * @param buque
	 */
	public void ponerEnWorking(CopiaBuque buque) {
		buque.evaluarEstado();
	}
	
	/**
	 * Pone en estado depart a un buque
	 * @param buque
	 */
	public void PonerEnDeparting(CopiaBuque buque) {
		buque.evaluarEstado();
	}
	


	

	


	
}
