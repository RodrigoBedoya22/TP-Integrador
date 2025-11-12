package buque;

public interface EstadoBuque {

	public void pasarAEstadoOutOfBound(Buque buque);
	public void pasarAEstadoInBound(Buque buque);
	public void pasarAEstadoArrived(Buque buque);
	public void pasarAEstadoWorking(Buque buque);
	public void pasarAEstadoDeparting(Buque buque);
	
}
