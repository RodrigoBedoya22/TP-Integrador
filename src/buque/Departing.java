package buque;

public class Departing implements EstadoBuque {

	@Override
	public void pasarAEstadoOutOfBound(Buque buque) {	
		
		buque.setEstado(new OutOfBound());
			
		}

	@Override
	public void pasarAEstadoInBound(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Departing al estado InBound");
		
	}

	@Override
	public void pasarAEstadoArrived(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Departing al estado Arrived");
		
	}

	@Override
	public void pasarAEstadoWorking(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado Departing al estado Working");
		
	}

	@Override
	public void pasarAEstadoDeparting(Buque buque) {
		
		throw new IllegalArgumentException("El buque ya se encuentra en estado Departing");
		
	}
	
}
