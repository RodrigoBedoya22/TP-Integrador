package nuevo_enfoque_viajes;

public class CopiaDeparting implements CopiaEstadoBuque {

	@Override
	public void evaluarCambioDeEstado(CopiaBuque buque) {
		if (buque.distanciaHaciaDestinoActual()> 50.0) {
			buque.setEstado(new CopiaOutOfBound());
			buque.getViaje().pasarASiguienteTramo();
		}
		
	}

	
}
