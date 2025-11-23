package servicio;

import contenedor.Contenedor;
import orden.Orden;

public class AlmacenamientoExcedente implements Servicio {
	
	// ver como calcular el costo
	
	private double precioFijo;
	
	public AlmacenamientoExcedente(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	/**
	 * Calcula el costo a pagar por el contenedor dado segun su estancai en la terminal.
	 */
	public double calcularCosto(Orden orden) {
		
		return 0;
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
