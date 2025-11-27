package reportes;

import java.util.ArrayList;

import buque.Buque;
import orden.Orden;
import terminal_portuaria.TerminalPortuaria;

public class ReporteMuelle implements ReporteVisitor{

	private String datos;
	
	public ReporteMuelle() {
		
	}
	
	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {
		
		
		
	}

	
	@Override
	public void visitarBuque(Buque buque) {
		
		
		
	}

	private void armarReporte(Buque buque) {
		
		
		
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


