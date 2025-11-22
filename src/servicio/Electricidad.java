package servicio;

import contenedor.Contenedor;
import contenedor.Reefer;

public class Electricidad implements Servicio {
	
	//ver como calcular el costo
	
	private double precioFijo;
	
	public Electricidad(double precioFijo) {
		this.asertarValorPositivo(precioFijo);
		this.precioFijo = precioFijo;
		
	}
	
	private boolean asertarValorPositivo(double precioFijo) {
		if(precioFijo <= 0) {
			throw new IllegalArgumentException("El precio fijo del servicio de electricidad no puede ser 0 o negativo");
		}
		return true;
	}

	/**
	 * Calcula el costo del servicio para un contenedor conectado basandose en su consumo.
	 */
	
	
	public double calcularCosto(Contenedor contenedor) {
		/*
        if(contenedor.getClass().isInstance(Reefer.class)){
        	return contenedor.getConsumoDeEnergia() * this.precioFijo;
        }else {
        	return 0;
        }
        
        */
		return 0;
	}
     

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
