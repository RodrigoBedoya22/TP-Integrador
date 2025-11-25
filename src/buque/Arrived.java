package buque;

import java.util.ArrayList;

import orden.*;

public class Arrived implements EstadoBuque {
	
	/**
	 * Pasa de estado Arrived a working
	 */
	@Override
	public void evaluarCambioDeEstado(Buque buque) {
		
		buque.setEstado(new Working());	
		operarOrdenes(buque);
	}

	public void operarOrdenes(Buque buque) {
		
		ArrayList<Orden> ordenesAOperar = buque.getViaje().getTramoActual().getTerminalDestino().getOrdenes();
		ArrayList<Orden> ordenesExportados = new ArrayList<Orden>();
		ArrayList<Orden> ordenesImportados = new ArrayList<Orden>();;
		
		for(Orden orden : ordenesAOperar) {
			if(orden.getNombreTerminalOrigen() == buque.getViaje().getTramoActual().getTerminalDestino().getNombre()) {
				buque.listaDeOrdenes.add(orden);
				ordenesExportados.add(orden);
			} else if(orden.getNombreTerminalDestino() == buque.getViaje().getTramoActual().getTerminalDestino().getNombre()){
				ordenesImportados.add(orden);
			    buque.listaDeOrdenes.remove(orden);
			}
			
		}
			   
	}

}
