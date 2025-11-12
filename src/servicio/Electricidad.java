package servicio;

import contenedor.Contenedor;

public class Electricidad implements Servicio {
	
	//ver como calcular el costo
	
	private double precioFijo;
	
	public Electricidad(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	public double calcularCosto(Contenedor contenedor) {
		
		return  0.0;
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
