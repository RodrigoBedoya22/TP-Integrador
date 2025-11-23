package orden;

import java.util.ArrayList;

import cliente.Cliente;
import contenedor.Contenedor;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenExportacion extends Orden {

	public OrdenExportacion(Cliente cliente, Contenedor contenedor, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, BuqueViaje viaje, 
			                String nombreTerminalOrigen, String nombreTerminalDestino) {
		super(cliente, contenedor, camion, chofer, servicios, viaje, nombreTerminalOrigen, nombreTerminalDestino);
		
	}
 
}
