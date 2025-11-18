package buque;


public class OutOfBound implements EstadoBuque {

	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		if(buque.distanciaHaciaDestinoActual() < 50.0) {
			buque.setEstado(new InBound());
		}
	}
	
}
