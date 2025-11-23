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

	@Override
	public double calcularCosto(Orden orden) {
		return this.getPrecioFijo();
	}
	
	

}
