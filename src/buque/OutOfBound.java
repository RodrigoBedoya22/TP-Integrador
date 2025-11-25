package buque;

import empresa_naviera.BuqueViaje;
import terminal_portuaria.TerminalPortuaria;

public class OutOfBound implements EstadoBuque {

	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		if(buque.distanciaHaciaDestinoActual() < 50.0) {
			buque.setEstado(new InBound());
			this.notificarImportaciones(buque.getViaje().getTramoActual().getTerminalDestino(), buque.getViaje());
		}
	}
	
	private void notificarImportaciones(TerminalPortuaria terminal, BuqueViaje viaje) {
		terminal.notificarImportaciones(viaje);
	}
}
