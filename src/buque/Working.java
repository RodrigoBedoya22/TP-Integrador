package buque;

public class Working implements EstadoBuque {
	
	@Override
	public void pasarAEstadoOutOfBound(Buque buque) {	
		
		throw new IllegalStateException("Un buque no puede pasar del estado Working al estado OutOfBound");
			
		}

	@Override
	public void pasarAEstadoInBound(Buque buque) {
		
		throw new IllegalStateException("Un buque no puede pasar del estado Working al estado InBound");
		
	}

	@Override
	public void pasarAEstadoArrived(Buque buque) {
		
		throw new IllegalStateException("Un buque no puede pasar del estado Working al estado Arrived");
		
	}

	@Override
	public void pasarAEstadoWorking(Buque buque) {
		
		throw new IllegalStateException("El buque ya se encuentra en estado Working");
		
	}

	@Override
	public void pasarAEstadoDeparting(Buque buque) {
		
		buque.setEstado(new Departing());
		
	}

}
