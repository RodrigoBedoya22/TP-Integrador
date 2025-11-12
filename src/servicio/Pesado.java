package servicio;

import contenedor.Contenedor;

public class Pesado implements Servicio {
	
	private double precioFijo;
	
	public Pesado(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	public double calcularCosto(Contenedor contenedor) {
		
		return this.getPrecioFijo();
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
