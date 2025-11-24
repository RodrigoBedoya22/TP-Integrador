package servicio;

import java.time.Duration;
import orden.Orden;

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
     

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	/**
	 * Calcula el costo del servicio para un contenedor conectado basandose en su consumo y la cantidad de horas que estuvo conectado en la terminal.
	 */
	public double calcularCosto(Orden orden) {
		double consumoDelContainer = orden.getContenedor().getConsumoDeEnergía();
		double tiempoDeConsumo = Duration.between(
											orden.getViaje().getTramoActual().getTerminalDestino().fechaDeRegistroDeContenedor(orden.getContenedor()).atStartOfDay()
											, orden.getViaje().getFechaDeLlegadaA(orden.getNombreTerminalOrigen()).atStartOfDay()
												)
											.toHours();
		
        double costoACobrar= this.precioFijo * tiempoDeConsumo * consumoDelContainer;
        return costoACobrar;
	}
	

}
