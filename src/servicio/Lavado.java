package servicio;

import contenedor.Contenedor;

public class Lavado implements Servicio {
	
	private double precioFijo;
	
	public Lavado(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	/**
	 * Calcula el costo del servicio para un contenedor basandose en sus medidas.
	 */
	public double calcularCosto(Contenedor contenedor) {
		
		if(contenedor.metrosCubicos() < 70.00) {
			
			return precioFijo;
			
		} else {
			
			return precioFijo * 2;
			
		}
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
