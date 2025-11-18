package buque;

public class InBound implements EstadoBuque {
	
	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		if (buque.distanciaHaciaDestinoActual()>= 50.0) {
			buque.setEstado(new OutOfBound());
		}
		else if (buque.distanciaHaciaDestinoActual() == 0.0) {
			buque.setEstado(new Arrived());
		}
		
	}
}