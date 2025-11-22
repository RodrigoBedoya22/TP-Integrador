package orden;

import java.time.LocalDate;
import java.util.ArrayList;

import bl.Bl;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLimite;

	public OrdenImportacion(Cliente cliente, Bl carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, 
			                LocalDate fechaLimite, BuqueViaje viaje, String nombreTerminalOrigen, String nombreTerminalDestino) {
		super(cliente, carga, camion, chofer, servicios, viaje, nombreTerminalOrigen, nombreTerminalDestino);
		this.fechaLimite = fechaLimite;
		
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}
	
	
}
