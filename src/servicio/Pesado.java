package servicio;

import orden.Orden;

public class Pesado implements Servicio {
	
	private double precioFijo;
	
	public Pesado(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}

	/**
	 * Calcula el valor de pesado para una orden. El precio siempre es el precio fijo definido por el servicio.
	 */
	@Override
	public double calcularCosto(Orden orden) {
		return this.getPrecioFijo();
	}
	
	

}
