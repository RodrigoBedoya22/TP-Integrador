package servicio;

import orden.Orden;

public class Pesado extends Servicio {
	
	public Pesado(String nombre, double precioFijo) {
		
		super(nombre, precioFijo);
	}
	
	/**
	 * Calcula el valor de pesado para una orden. El precio siempre es el precio fijo definido por el servicio.
	 */
	@Override
	public double calcularCosto(Orden orden) {
		return this.getPrecioFijo();
	}
	
	

}
