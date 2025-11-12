package cliente;

import java.util.ArrayList;

import carga.CargaBL;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import orden.*;
import servicio.Servicio;
import terminal_portuaria.TerminalPortuaria;

public class Cliente {
	
	String nombre;
	int dni;
	String email;
	
	public Cliente(String nombre, int dni, String email) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDni() {
		return dni;
	}
	
	/**
	 * Crea una orden de exportacion y le dice a la terminal dada que la registre.
	 * @param viaje - El viaje que tendra la orden
	 * @param carga - La carga que se querrá exportar
	 * @param camion - El camion que llevará la carga
	 * @param chofer - El chofer del camion dado
	 * @param serviciosRecibidos - Los servicios contratados por el cliente.
	 * @param terminal - La terminal en la que se quiere registrar dicha orden de exportacion.
	 */
	public void crearOrdenExportacion(BuqueViaje viaje, CargaBL carga, Camion camion, Chofer chofer,
			ArrayList<Servicio> serviciosRecibidos, TerminalPortuaria terminal) {
		
		OrdenExportacion orden = new OrdenExportacion(this, carga, camion, chofer, serviciosRecibidos, viaje);
		terminal.registrarOrden(orden);
		
	}

}
