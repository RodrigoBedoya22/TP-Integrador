package nuevo_enfoque_viajes;

public class CopiaWorking implements CopiaEstadoBuque {

	@Override
	public void evaluarCambioDeEstado(CopiaBuque buque) {
		
		buque.setEstado(new CopiaDeparting());
	}
	

}
