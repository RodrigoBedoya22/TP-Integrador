package orden;

import java.util.ArrayList;

import bl.*;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public abstract class Orden {
	
	Cliente cliente;
	Bl carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	BuqueViaje viaje;
	
	public Orden(Cliente cliente, Bl carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, BuqueViaje viaje) {
		this.cliente = cliente;
		this.carga = carga;
		this.camion = camion;
		this.chofer = chofer;
		this.servicios = servicios;
		this.viaje = viaje;
	}

	public BuqueViaje getViaje() {
		return viaje;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Bl getCarga() {
		return this.carga;
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
		return this.servicios;
	} 
	
	// public double calcularCostoTotalDeServicios() {
		
	// }
	

}
