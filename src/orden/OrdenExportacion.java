package orden;

import java.util.ArrayList;

import bl.Bl;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenExportacion extends Orden {

	public OrdenExportacion(Cliente cliente, Bl carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, BuqueViaje viaje, 
			                String nombreTerminalOrigen, String nombreTerminalDestino) {
		super(cliente, carga, camion, chofer, servicios, viaje, nombreTerminalOrigen, nombreTerminalDestino);
		
	}

	public BuqueViaje getViaje() {
		return viaje;
	}
 
}
