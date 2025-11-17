package nuevo_enfoque_viajes;

public class CopiaInBound implements CopiaEstadoBuque {
	
	@Override
	public void evaluarCambioDeEstado(CopiaBuque buque) {
		if (buque.distanciaHaciaDestinoActual()>= 50.0) {
			buque.setEstado(new CopiaOutOfBound());
		}
		else if (buque.distanciaHaciaDestinoActual() == 0.0) {
			buque.setEstado(new CopiaArrived());
		}
		
	}

}
