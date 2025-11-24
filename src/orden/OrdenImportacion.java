package orden;

import java.time.LocalDate;
import java.util.ArrayList;

import cliente.Cliente;
import contenedor.Contenedor;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLimite;

	public OrdenImportacion(Cliente cliente, Contenedor contenedor, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, 
			                BuqueViaje viaje, String nombreTerminalOrigen, String nombreTerminalDestino) {
		super(cliente, contenedor, camion, chofer, servicios, viaje, nombreTerminalOrigen, nombreTerminalDestino);
		this.fechaLimite = viaje.getFechaDeLlegadaA(nombreTerminalDestino).plusDays(1);
		
	}

	public LocalDate getFechaLimite() {
		return this.fechaLimite;
	}
	
	
}
