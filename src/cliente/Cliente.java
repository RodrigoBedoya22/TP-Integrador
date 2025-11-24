package cliente;

import java.time.LocalDate;
import java.util.ArrayList;

import contenedor.Contenedor;
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
	 * @param contenedor- El contenedor con la carga que se exportará
	 * @param camion - El camion que llevará la carga
	 * @param chofer - El chofer del camion dado
	 * @param serviciosRecibidos - Los servicios contratados por el cliente.
	 * @param terminal - La terminal en la que se quiere registrar la orden de exportacion.
	 */
	public void crearOrdenExportacion(BuqueViaje viaje, Contenedor contenedor, Camion camion, Chofer chofer,
			ArrayList<Servicio> serviciosRecibidos, TerminalPortuaria terminal, String nombreDeTerminalDestino) {
		
		OrdenExportacion orden = new OrdenExportacion(this, contenedor, camion, chofer, serviciosRecibidos, viaje, terminal.getNombre(), nombreDeTerminalDestino);
		terminal.registrarOrden(orden);
		
	}
	
	/**
	 * Crea una orden de importacion y le dice a la terminal dada que la registre.
	 * @param viaje - El viaje en el que vendrá la carga
	 * @param contenedor- El contenedor con la carga que se importará
	 * @param camion - El camion que retirará la carga
	 * @param chofer - El chofer del camion dado
	 * @param serviciosRecibidos - Los servicios contratados por el cliente.
	 * @param terminal - La terminal en la que se quiere registrar la orden de exportacion.
	 */
	public void crearOrdenImportacion(BuqueViaje viaje, Contenedor contenedor, Camion camion, Chofer chofer,
			ArrayList<Servicio> serviciosRecibidos, TerminalPortuaria terminal, String nombreDeTerminalOrigen) {
		
		OrdenImportacion orden = new OrdenImportacion(this, contenedor, camion, chofer, serviciosRecibidos, viaje, nombreDeTerminalOrigen, terminal.getNombre());
		terminal.registrarOrden(orden);
	}


}
