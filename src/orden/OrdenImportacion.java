package orden;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import bl.Bl;
import cliente.Cliente;
import empresa_transportista.*;
import servicio.Servicio;

public class OrdenImportacion extends Orden{
	
	private LocalDate fechaLimite;

	public OrdenImportacion(Cliente cliente, Bl carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, LocalDate fechaLimite) {
		super(cliente, carga, camion, chofer, servicios);
		this.fechaLimite = fechaLimite;
		
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}
	
	@Override
	public boolean esOrdenDeExportacion() { 
		return false;
	} 

	@Override
	public boolean esOrdenDeImportacion() {
		
		return true;
	}
	
}
