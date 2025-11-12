package buque;

public class InBound implements EstadoBuque {
	
	@Override
	public void pasarAEstadoOutOfBound(Buque buque) {	
		
		buque.setEstado(new OutOfBound());
			
	}

	@Override
	public void pasarAEstadoInBound(Buque buque) {
		
		throw new IllegalStateException("El buque ya se encuentra en el estado InBound");
		
	}

	@Override
	public void pasarAEstadoArrived(Buque buque) {
		
		buque.setEstado(new Arrived());
		
	}

	@Override
	public void pasarAEstadoWorking(Buque buque) {
		
		throw new IllegalStateException("Un buque no puede pasar del estado InBound al estado Working");
		
	}

	@Override
	public void pasarAEstadoDeparting(Buque buque) {
		
		throw new IllegalStateException("Un buque no puede pasar del estado InBound al estado Departing");
		
	}

}
