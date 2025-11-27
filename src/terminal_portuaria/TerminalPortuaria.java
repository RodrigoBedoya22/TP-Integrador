package terminal_portuaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import buque.Buque;
import cliente.Cliente;
import contenedor.Contenedor;
import coordenada.Coordenada;
import empresa_naviera.*;
import empresa_transportista.*;
import orden.*;
import reportes.*;
import servicio.*;

public class TerminalPortuaria  implements Reportable{

	private String nombre;
	private Coordenada coordenada;
	private ArrayList<EmpresaNaviera> navieras;
	private ArrayList<EmpresaTransportista> empresasTransportistas;
	private Map<Camion, LocalDate> camionesRegistrados;
	private ArrayList<Orden> ordenesRegistradas;
	private Map<Contenedor, LocalDate> contenedoresRegistrados;
	private ArrayList<Cliente> shippersRegistrados;
	private ArrayList<Cliente> consigneesRegistrados;
	
	/**
	 * Constructor de una termina portuaria
	 * @param nombre - El nombre de la terminal
	 * @param coordenada - La coordenada de la terminal
	 * NOTA: Una terminal portuaria se isntancia con sus listas vacias.
	 */
	public TerminalPortuaria(String nombre, Coordenada coordenada) {
		this.nombre = nombre;
		this.coordenada = coordenada;
		this.navieras = new ArrayList<EmpresaNaviera>();
		this.empresasTransportistas = new ArrayList<EmpresaTransportista>();
		this.camionesRegistrados = new HashMap<>();
		this.ordenesRegistradas = new ArrayList<Orden>();
		this.contenedoresRegistrados = new HashMap<>();
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
	 * Retorna los camiones registrados en la terminal y su fecha.
	 * @return Map<Camion, LocalDate> un diccionario que contiene al camion y su fecha de ingreso
	 */
	public Map<Camion, LocalDate> getCamiones() {
			
			return this.camionesRegistrados;
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
	 * Registra un camion dado en una fecha dada dentro de la terminal.
	 * @param camion - El camion a registrar en la lista de camiones
	 * @param fecha - La fecha de ingreso del camion.
	 */
	public void registrarCamion(Camion camion, LocalDate fecha) {
		
		if(this.getCamiones().containsKey(camion)){
			throw new IllegalArgumentException("El camion ya se encuentra registrado en la lista de camiones en la terminal");
		}
		else {
			this.camionesRegistrados.put(camion, fecha);
		}
		
	}
	
	/**
	 * Al retirarse un camion, se elimina de los camiones registrados de la terminal.
	 * @param camion - El camion a eliminar
	 */
	public void eliminarCamion(Camion camion) {
		
		this.camionesRegistrados.remove(camion);
		
	}
	
	/**
	 * Registra una orden en la lista de ordenes de la terminal
	 * @param orden - La orden a registrar
	 */
	public void registrarOrden(Orden orden) {
		
		this.ordenesRegistradas.add(orden);
		
	}
	
	/**
	 * Registra un contenedor en la terminal en una fecha dada.
	 * @param contenedor - El contenedor a registrar
	 * @param localdate - La fecha en la que se registrará el contenedor
	 */
	public void registrarContenedor(Contenedor contenedor, LocalDate fecha) {
		
		this.contenedoresRegistrados.put(contenedor, fecha);
		
	}
	
	/**
	 * Retorna la lista de contenedores en campo de la terminal (aquellos que esperan a ser retirados o exportados) y la fecha en la que llegaron.
	 * @return - La lista de contenedores en campo de la terminal y su fecha de llegada.
	 */
	public Map<Contenedor, LocalDate> getContenedores() {
		
		return this.contenedoresRegistrados;
	}
	
	/**
	 * Retorna las ordenes registradas en la terminal
	 * @return ArrayList<Orden> - las ordenes registradas en la terminal
	 */
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
	
    /**
     * Elimina al contenedor dado de los contenedores registrados en la terminal
     * @param contenedor
     */
	public void eliminarContenedor(Contenedor contenedor) {
		
		this.contenedoresRegistrados.remove(contenedor);
		
	}
	
	/**
	 * Pone a trabajar en carga y descarga a un buque
	 * @param buque
	 */
	public void ponerEnWorking(Buque buque) {
		buque.evaluarEstado();
		this.operarOrdenes(buque);
	}
	
	/**
	 * Pone en estado depart a un buque
	 * @param buque
	 */
	public void PonerEnDeparting(Buque buque) {
		buque.evaluarEstado();
	}

	/**
	 * Retorna la fecha de registro de un contenedor dado en la terminal.
	 * @param contenedor - El contenedor del cual se consultará su fecha de registro en la terminal.
	 * @return LocalDate - la fecha de registro del contenedor dado.
	 */
	public LocalDate fechaDeRegistroDeContenedor(Contenedor contenedor) {
		
		return this.getContenedores().get(contenedor);
	}

	/**
	 * Retorna la fecha de registro de un camion dado en la terminal.
	 * @param Camion - El camion del cual se consultará su fecha de registro en la terminal.
	 * @return LocalDate - la fecha de registro del camion dado.
	 */
	public LocalDate fechaDeRegistroDeCamion(Camion camion) {
		
		return this.getCamiones().get(camion);
	}
	
	/**
	 * Notifica a todos los consignees interesados en el viaje dado que sus importaciones estan llegando a terminal.
	 * @param viaje - El viaje del cual se notificaran a los consignees interesados
	 */
	public void notificarImportaciones(BuqueViaje viaje) {
		//viaje tiene terminal destino y su nombre y orden tiene el nombre de la terminal destino
		//recorremos la lista de ordenes y buscamos aquellas que tengan como nombre de terminal destino el destino actual del viaje
		//
		
		for (Orden orden: this.getOrdenes()) {
			//si el nombre del destino coincide
			if(orden.getNombreTerminalDestino() == viaje.getTramoActual().getTerminalDestino().getNombre()) {
				this.notificarImportacionA(orden);
			}
		}
	}

	/**
	 * Notifica a un cliente concreto que su importacion esta llegando
	 * @param cliente - El cliente a notificar
	 */
	public void notificarImportacionA(Orden orden) {
		
		System.out.println(
				"Para: " + orden.getCliente().getEmail() + System.lineSeparator() + 
				"Asunto: ¡Su importación está llegando!" + System.lineSeparator() + 
				"Le notificamos que su importación está llegando a la terminal " + this.getNombre()+ System.lineSeparator() + 
				"Saludos"
		);
	}

	/**
	 * Notifica a todos los Shippers interesados en el viaje dado que sus exportaciones han salido de la terminal.
	 * @param viaje - El viaje del cual se notificaran a los shippers exportadores
	 */
	public void notificarExportaciones(BuqueViaje viaje) {
		
		for (Orden orden: viaje.getBuque().getOrdenes() ) {
			//si el nombre del origen coincide
			if(orden.getNombreTerminalOrigen().equals(this.getNombre())) {
				this.notificarExportacionA(orden);
			}
		}
	}
	
	/**
	 * Notifica a un cliente concreto que su exportación ha salido de la terminal.
	 * @param cliente - El cliente a notificar
	 */
	public void notificarExportacionA(Orden orden) {
		//listado de precios de cada servicio
		String facturacion = "Facturación de servicios: ";
		for (Servicio servicio: orden.getServicios()) {
			facturacion += 
					System.lineSeparator() + servicio.getNombre() + "= $" + servicio.calcularCosto(orden);
			;
		}
		//mensaje
		System.out.println(
				"Para: " + orden.getCliente().getEmail() + System.lineSeparator() + 
				"Asunto: ¡Su exportación está en camino!" + System.lineSeparator() + 
				"Le notificamos que su exportacion ha salido de la terminal hacia su destino " + System.lineSeparator() + 
				facturacion + System.lineSeparator() +
				"Costo total a pagar = $" + orden.calcularCostoTotalDeServicios() + System.lineSeparator() + 
				"Saludos"
		);
	}
	/**
	 * Indica al visitante dado que puede acceder a su información.
	 * @param visitor - El visitante al cual se le informará el acceso a los datos de la terminal.
	*/
	@Override
	public void aceptar(ReporteVisitor reporte) {
		reporte.visitarTerminal(this);
    }
	
	public void operarOrdenes(Buque buque) {

	    ArrayList<Orden> ordenesDeBuque = new ArrayList<>(
	        buque.getViaje().getTramoActual().getTerminalDestino().getOrdenes()
	    );

	    ArrayList<Orden> ordenesEnTerminal = new ArrayList<>(this.getOrdenes());

	    ArrayList<Orden> ordenesImportadas = new ArrayList<>();
	    ArrayList<Orden> ordenesExportadas = new ArrayList<>();

	    //IMPORTACIONES
	    for (Orden orden : ordenesDeBuque) {
	        if (orden.getNombreTerminalDestino().equals(this.getNombre())) {

	            buque.sacarOrden(orden);
	            this.registrarOrden(orden);
	            ordenesImportadas.add(orden);
	        }
	    }

	    //EXPORTACIONES
	    for (Orden orden : ordenesEnTerminal) {
	        if (orden.getNombreTerminalOrigen().equals(this.getNombre()) &&
	            orden.getViaje() == buque.getViaje()) {
	            buque.agregarOrden(orden);
	            this.eliminarOrden(orden);

	            ordenesExportadas.add(orden);
	        }
	    }

	    this.aceptar(new ReporteMuelle());
	}
	

	/**
	 * Elimina una orden de la lista de ordenes registradas
	 * @param orden
	 */
	private void eliminarOrden(Orden orden) {
		this.ordenesRegistradas.remove(orden);
		
	}

}
