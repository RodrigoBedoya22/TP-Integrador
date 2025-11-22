package servicio;

import contenedor.Contenedor;

public class Lavado implements Servicio {
	
	private double precioFijo;
	
	public Lavado(double precioFijo) {
		this.asertarValorPositivo(precioFijo);
		this.precioFijo = precioFijo;
		
	}
	
	/**
	 * Verifica si el precio fijo del servicio de lavado es un valor positivo mayor a 0., en caso contrario 
	 * levanta una excepcion 
	 */
	
	private boolean asertarValorPositivo(double precioFijo) {
		if(precioFijo <= 0) {
			throw new IllegalArgumentException("El precio fijo del servicio de lavado no puede ser 0 o negativo");
		}
		return true;
	}

	/**
	 * Calcula el costo del servicio para un contenedor basandose en sus medidas.
	 * Si los metros cubicos del contenedor son menos de 70, cobra el precio base, en caso contrario se cobra el doble del precio base.
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
