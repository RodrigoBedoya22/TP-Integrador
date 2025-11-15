package orden;

import java.util.ArrayList;

import bl.Bl;
import cliente.Cliente;
import empresa_naviera.BuqueViaje;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenExportacion extends Orden{

	private BuqueViaje viaje;

	public OrdenExportacion(Cliente cliente, Bl carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, BuqueViaje viaje) {
		super(cliente, carga, camion, chofer, servicios);
		this.viaje = viaje;
		
	}

	public BuqueViaje getViaje() {
		return viaje;
	}
 
}
