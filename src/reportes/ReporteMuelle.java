package reportes;

import java.util.ArrayList;
import java.util.Date;

import buque.Buque;
import contenedor.Contenedor;
import terminal_portuaria.TerminalPortuaria;

public class ReporteMuelle implements ReporteVisitor {

	private String nombreDelBuque;
    private Date fechaDeLlegada;
    private Date fechaDePartida;
    private int cantidadDeContenedoresExportados;
    private int cantidadDeContenedoresImportados;
    
    public ReporteMuelle(String nombreDelBuque, Date fechaDeLlegada, Date fechaDePartida,int cantidadDeContenedoresExportados, int cantidadDeContenedoresImportados) {
		this.nombreDelBuque = nombreDelBuque;
		this.fechaDeLlegada = fechaDeLlegada;
		this.fechaDePartida = fechaDePartida;
		this.cantidadDeContenedoresExportados = cantidadDeContenedoresExportados;
		this.cantidadDeContenedoresImportados = cantidadDeContenedoresImportados;
	}

	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBuque(Buque buque) {
		// TODO Auto-generated method stub
		
	}

}
