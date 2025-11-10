package orden;

import java.util.ArrayList;

import carga.Carga;
import carga.CargaBL;
import cliente.Cliente;
import contenedor.Contenedor;
import empresa_naviera.BuqueViaje;
import empresa_transportista.Camion;
import empresa_transportista.Chofer;
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
		return cliente;
	}

	public Carga getCarga() {
		return carga;
	}

	public Camion getCamion() {
		return camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	} 
	
	// public double calcularCostoTotalDeServicios() {
		
	// }
	
	public abstract boolean esOrdenDeExportacion();
	public abstract boolean esOrdenDeImportacion();

	
	

}
