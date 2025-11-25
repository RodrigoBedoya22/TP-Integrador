package servicio;

import orden.Orden;

public abstract class Servicio {
	
	private String nombre;
	private double precioFijo;
	
	public Servicio(String nombre, double precioFijo) {
		
		this.asertarValorPositivo(precioFijo);
		this.nombre= nombre;
		this.precioFijo = precioFijo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract double calcularCosto(Orden orden);

	public double getPrecioFijo() {
		return this.precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}

	/**
	 * Verifica si el precio fijo del servicio de lavado es un valor positivo mayor a 0., en caso contrario 
	 * levanta una excepcion 
	 */
	protected boolean asertarValorPositivo(double precioFijo) {
		if(precioFijo <= 0) {
			throw new IllegalArgumentException("El precio fijo del servicio de lavado no puede ser 0 o negativo");
		}
		return true;
	}

	
}
