package servicio;

import java.time.Duration;
import orden.*;

public class AlmacenamientoExcedente extends Servicio {
	
	
	public AlmacenamientoExcedente(String nombre, double precioFijo) {
		super(nombre, precioFijo);
		
	} 
	
	/**
	 * Calcula el costo a pagar por el contenedor dado segun su estancia en la terminal.
	 */
	public double calcularCosto(Orden orden) {
		
		long cantidadDeDias = Duration.between(orden.getViaje().getFechaDeLlegadaA(orden.getNombreTerminalDestino()).atStartOfDay(), 
											orden.getViaje().getTramoActual().getTerminalDestino().fechaDeRegistroDeCamion(orden.getCamion()).atStartOfDay()).toDays();
		
		return this.getPrecioFijo() * cantidadDeDias ;
		
	}
	
	

}
