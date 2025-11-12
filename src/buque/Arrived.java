package buque;

public class Arrived implements EstadoBuque {
	
	@Override
	public void pasarAEstadoOutOfBound(Buque buque) {	
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Arrived al estado OutOfBound");
			
		}

	@Override
	public void pasarAEstadoInBound(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Arrived al estado InBound");
		
	}

	@Override
	public void pasarAEstadoArrived(Buque buque) {
		
		throw new IllegalArgumentException("El buque ya se encuentra en el estado arrived");
		
	}

	@Override
	public void pasarAEstadoWorking(Buque buque) {
		
		buque.setEstado(new Working());
		
	}

	@Override
	public void pasarAEstadoDeparting(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Arrived al estado Departing");
		
	}

}
