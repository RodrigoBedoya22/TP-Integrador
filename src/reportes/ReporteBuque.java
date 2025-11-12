package reportes;

import java.util.ArrayList;

import buque.Buque;
import contenedor.Contenedor;
import terminal_portuaria.TerminalPortuaria;

public class ReporteBuque implements ReporteVisitor{
	
    private ArrayList<String> idDeContenedoresImportados = new ArrayList<>();
    private ArrayList<String> idDeContenedoresExportados = new ArrayList<>();
    
    
    
	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visitarBuque(Buque buque) {
		// TODO Auto-generated method stub
		
	}



}
