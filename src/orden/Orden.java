package orden;

import java.util.ArrayList;

import bl.*;
import cliente.Cliente;
import contenedor.Contenedor;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public abstract class Orden {
	
	Cliente cliente;
	Contenedor contenedor;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> serviciosRecibidos;
	BuqueViaje viaje;
	String nombreTerminalOrigen;
	String nombreTerminalDestino;
	
	public Orden(Cliente cliente,Contenedor contenedor, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, 
			     BuqueViaje viaje, String nombreTerminalOrigen, String nombreTerminalDestino) {
		this.cliente = cliente;
		this.contenedor = contenedor;
		this.camion = camion;
		this.chofer = chofer;
		this.serviciosRecibidos = servicios;
		this.viaje = viaje;
		this.nombreTerminalOrigen = nombreTerminalOrigen;
		this.nombreTerminalDestino = nombreTerminalDestino;
	}

	public BuqueViaje getViaje() {
		return viaje;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Contenedor getContenedor() {
		return this.contenedor;
	}
	public Bl getCarga() {
		return this.contenedor.getCarga();
	}

	public Camion getCamion() {
		return this.camion;
	}

	public Chofer getChofer() {
		return this.chofer;
	}
	
	/**
	 * Retorna los servicios contratados por el shipper para su exportacion
	 * @return - La lista de servicios contratados
	 */
	public ArrayList<Servicio> getServicios() {
		return this.serviciosRecibidos;
	} 
	
	/**
	 * Retorna el nombre de la terminal origen desde la cual la carga sale.
	 * @return String - El nombre de la terminal origen
	 */
	public String getNombreTerminalOrigen() {
		return nombreTerminalOrigen;
	}

	/**
	 * Retorna el nombre de la terminal destino de la carga de la orden
	 * @return String - El nombre de la terminal destino
	 */
	public String getNombreTerminalDestino() {
		return nombreTerminalDestino;
	}
	
	/**
	 * Retorna la suma del costo de todos los servicios contratados para la orden.
	 * @return Double - El precio de sumar el costo de todos los servicios
	 */
	public double calcularCostoTotalDeServicios() {
		double precioACobrar = this.getServicios().stream()
												.mapToDouble(servicio -> servicio.calcularCosto(this))
												.sum();
		return precioACobrar;
	}
	

}
