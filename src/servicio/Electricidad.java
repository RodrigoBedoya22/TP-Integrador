package servicio;

import java.time.Duration;
import orden.Orden;

public class Electricidad extends Servicio {
	
	public Electricidad(String nombre, double precioFijo) {
		
		super(nombre, precioFijo);	
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
		
        double costoACobrar= this.getPrecioFijo() * tiempoDeConsumo * consumoDelContainer;
        return costoACobrar;
	}
	

}
