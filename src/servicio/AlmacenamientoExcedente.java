package servicio;

import contenedor.Contenedor;

public class AlmacenamientoExcedente implements Servicio {
	
	// ver como calcular el costo
	
	private double precioFijo;
	
	public AlmacenamientoExcedente(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	public double calcularCosto(Contenedor contenedor) {
		
		return 0;
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
