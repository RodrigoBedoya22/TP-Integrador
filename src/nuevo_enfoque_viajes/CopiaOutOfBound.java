package nuevo_enfoque_viajes;

public class CopiaOutOfBound implements CopiaEstadoBuque {

	@Override
	public void evaluarCambioDeEstado(CopiaBuque buque) {
		
		if(buque.distanciaHaciaDestinoActual() < 50.0) {
			buque.setEstado(new CopiaInBound());
		}
	}
	
	

}
