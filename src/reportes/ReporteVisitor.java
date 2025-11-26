package reportes;

import buque.Buque;
import terminal_portuaria.TerminalPortuaria;

public interface ReporteVisitor {
	
	public void visitarTerminal(TerminalPortuaria terminal);
	
	public void visitarBuque(Buque buque);
}
