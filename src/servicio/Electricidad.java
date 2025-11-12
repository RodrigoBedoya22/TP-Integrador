package servicio;

import contenedor.Contenedor;

public class Electricidad implements Servicio {
	
	//ver como calcular el costo
	
	private double precioFijo;
	
	public Electricidad(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	}
	
	/**
	 * Calcula el costo del servicio para un contenedor conectado basandose en su consumo.
	 */
	public double calcularCosto(Contenedor contenedor) {
		
		return  0; //contenedor.getConsumoDeEnergia() * this.precioFijo;
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
