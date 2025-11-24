package servicio;

import java.time.Duration;
import orden.*;

public class AlmacenamientoExcedente implements Servicio {
	
	// ver como calcular el costo
	
	private double precioFijo;
	
	public AlmacenamientoExcedente(double precioFijo) {
		
		this.precioFijo = precioFijo;
		
	} 
	
	/**
	 * Calcula el costo a pagar por el contenedor dado segun su estancia en la terminal.
	 */
	public double calcularCosto(Orden orden) {
		
		long cantidadDeDias = Duration.between(orden.getViaje().getFechaDeLlegadaA(orden.getNombreTerminalDestino()).atStartOfDay(), 
											orden.getViaje().getTramoActual().getTerminalDestino().fechaDeRegistroDeCamion(orden.getCamion()).atStartOfDay()).toDays();
		
		return precioFijo * cantidadDeDias ;
		
	}

	public double getPrecioFijo() {
		return precioFijo;
	}

	public void setPrecioFijo(double precioFijo) {
		this.precioFijo = precioFijo;
	}
	
	

}
