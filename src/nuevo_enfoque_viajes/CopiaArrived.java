package nuevo_enfoque_viajes;

public class CopiaArrived implements CopiaEstadoBuque {

	/**
	 * Pasa de estado Arrived a working
	 */
	@Override
	public void evaluarCambioDeEstado(CopiaBuque buque) {
		
		buque.setEstado(new CopiaWorking());	
	}

}
