package buque;

public class Departing implements EstadoBuque {

	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		if (buque.distanciaHaciaDestinoActual()> 50.0) {
			buque.setEstado(new OutOfBound());
			buque.getViaje().pasarASiguienteTramo();
		}
		
	}
	
}
