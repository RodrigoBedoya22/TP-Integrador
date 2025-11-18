package buque;

public class Working implements EstadoBuque {
	
	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		buque.setEstado(new Departing());
	}

}
