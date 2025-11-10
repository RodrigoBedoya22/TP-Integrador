package orden;

import java.util.ArrayList;
import java.util.Date;

import carga.Carga;
import cliente.Cliente;
import empresa_transportista.Camion;
import empresa_transportista.Chofer;
import servicio.Servicio;

public class OrdenImportacion extends Orden{
	
	private Date fechaLimite;

	public OrdenImportacion(Cliente cliente, Carga carga, Camion camion, Chofer chofer, ArrayList<Servicio> servicios, Date fechaLimite) {
		super(cliente, carga, camion, chofer, servicios);
		this.fechaLimite = fechaLimite;
		
	}

	public Date getFechaLimite() {
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
