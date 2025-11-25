package servicio;

import orden.Orden;

public class Lavado extends Servicio {
	
	public Lavado(String nombre, double precioFijo) {
		
		super(nombre, precioFijo);		
	}
	
	/**
	 * Calcula el costo del servicio para un contenedor basandose en sus medidas.
	 * Si los metros cubicos del contenedor son menos de 70, cobra el precio base, en caso contrario se cobra el doble del precio base.
	 */
	public double calcularCosto(Orden orden) {
		
		if(orden.getContenedor().metrosCubicos() < 70.00) {
			
			return this.getPrecioFijo();
			
		} else {
			
			return this.getPrecioFijo() * 2;
			
		}
		
	}
	

}
