package reportes;

import buque.Buque;
import orden.Orden;
import terminal_portuaria.TerminalPortuaria;

public class ReporteBuque implements ReporteVisitor {

	String datos;
	
	public ReporteBuque() {
		
	}
	//No hace nada
	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {

	}

	/**
	 * Visita a un buque dado para obtener sus datos y armar un reporte
	 */
	@Override
	public void visitarBuque(Buque buque) {
		
		this.armarReporte(buque);
	}
	
	/**
	 * Arma el reporte utilizando los datos del buque dado
	 * @param buque - El buque del cual se consultarán sus datos
	 */
	private void armarReporte(Buque buque) {
		String listaDeContenedoresExportados = "<Export>";
		String listaDeContenedoresImportados = "<Import>";
		
		for(Orden orden : buque.getOrdenes()) {
			//Se agregan las ordenes al buque, tanto exportaciones como importaciones
			//Exportaciones
			if(orden.getNombreTerminalOrigen() == buque.getViaje().getTramoActual().getTerminalDestino().getNombre()) {
				listaDeContenedoresExportados += 
						System.lineSeparator() + "<item>" + orden.getContenedor().getIdentificador() + "</item>";
			//Importaciones
			} else if(orden.getNombreTerminalDestino() == buque.getViaje().getTramoActual().getTerminalDestino().getNombre()){
				listaDeContenedoresImportados += 
						System.lineSeparator() + "<item>" + orden.getContenedor().getIdentificador() + "</item>"; 
			}
		}
		listaDeContenedoresExportados += System.lineSeparator() + "</Export>";
		listaDeContenedoresImportados += System.lineSeparator() + "</Import>";
		
		String informeCompleto = 
				"<report>" + System.lineSeparator() +
				listaDeContenedoresExportados + System.lineSeparator() +
				listaDeContenedoresImportados + System.lineSeparator() +
				"</report>" + System.lineSeparator();
		this.setDatos(informeCompleto);
		
	}
	
	public void setDatos(String datos) {
		this.datos= datos;
		
	}
	/**
	 * Saca a consola el informe construido
	 * @param datos - Los datos del informe construido
	 */
	public void print() {
		System.out.println(this.datos);
	}

}
