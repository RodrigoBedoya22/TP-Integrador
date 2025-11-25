package buque;

import empresa_naviera.BuqueViaje;
import terminal_portuaria.TerminalPortuaria;

public class Departing implements EstadoBuque {

	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		// debe ser mayor a 1km
		if (buque.distanciaHaciaDestinoActual()> 50.0) {
			
			buque.setEstado(new OutOfBound());
			buque.getViaje().pasarASiguienteTramo();
			this.notificarExportaciones(buque.getViaje().getTramoActual().getTerminalOrigen(), buque.getViaje());
		}
		
	}
	
	private void notificarExportaciones(TerminalPortuaria terminal, BuqueViaje viaje) {
		terminal.notificarExportaciones(viaje);
	}
	
}
