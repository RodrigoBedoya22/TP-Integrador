package reportes;

import buque.Buque;
import terminal_portuaria.TerminalPortuaria;

public interface ReporteVisitor {

	void visitarTerminal(TerminalPortuaria terminal);
    void visitarBuque(Buque buque);
}
