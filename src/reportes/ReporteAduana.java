package reportes;

import java.util.ArrayList;
import java.util.Date;

import buque.Buque;
import contenedor.Contenedor;
import terminal_portuaria.TerminalPortuaria;

public class ReporteAduana implements ReporteVisitor {
	
	private String nombreDelBuque;
    private Date fechaDeLlegada;
    private Date fechaDePartida;
    private ArrayList<Contenedor> contenedores = new ArrayList<>();
    
    public ReporteAduana(String nombreDelBuque, Date fechaDeLlegada, Date fechaDePartida, ArrayList<Contenedor> contenedores) {
		this.nombreDelBuque = nombreDelBuque;
		this.fechaDeLlegada = fechaDeLlegada;
		this.fechaDePartida = fechaDePartida;
		this.contenedores = contenedores;
	}
    
	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {
		
		this.contenedores.addAll(terminal.getContenedores());
		
	}
	@Override
	public void visitarBuque(Buque buque) {
		
	}
	


}
