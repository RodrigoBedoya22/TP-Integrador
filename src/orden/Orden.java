package orden;

import java.util.ArrayList;

import carga.*;
import cliente.Cliente;
import empresa_transportista.*;
import servicio.Servicio;

public abstract class Orden {
	
	Cliente cliente;
	Carga carga;
	Camion camion;
	Chofer chofer;
	ArrayList<Servicio> servicios;
	
	public Orden(Cliente cliente, Carga carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios) {
		this.cliente = cliente;
		this.carga = carga;
		this.camion = camion;
		this.chofer = chofer;
		this.servicios = servicios;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Carga getCarga() {
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
	
	public abstract boolean esOrdenDeExportacion();
	public abstract boolean esOrdenDeImportacion();

	
	

}
