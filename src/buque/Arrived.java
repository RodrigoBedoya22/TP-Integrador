package buque;

import reportes.ReporteBuque;

public class Arrived implements EstadoBuque {
	
	/**
	 * Pasa de estado Arrived a working
	 */
	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		buque.setEstado(new Working());	
		buque.aceptar(new ReporteBuque());
	}

	

}
