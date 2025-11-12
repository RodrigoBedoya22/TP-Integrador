package buque;

public class OutOfBound implements EstadoBuque {

	@Override
	public void pasarAEstadoOutOfBound(Buque buque) {	
		
		throw new IllegalArgumentException("El buque ya se encuentra en estado OutBound");
			
		}

	@Override
	public void pasarAEstadoInBound(Buque buque) {
		
		buque.setEstado(new InBound());
		
	}

	@Override
	public void pasarAEstadoArrived(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado OutBound al estado Arrived");
		
	}

	@Override
	public void pasarAEstadoWorking(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado OutBound al estado Working");
		
	}

	@Override
	public void pasarAEstadoDeparting(Buque buque) {
		
		throw new IllegalArgumentException("Un buque no puede pasar del estado OutBound al estado Departing");
		
	}
	
	

}
