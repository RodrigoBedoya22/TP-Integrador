package terminal_portuaria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa_naviera.EmpresaNaviera;

class TerminalPortuariaTest {

	TerminalPortuaria terminal;
	EmpresaNaviera empresaNaviera;
	EmpresaNaviera empresaNaviera2;
	EmpresaNaviera empresaNaviera3;
	ArrayList<EmpresaNaviera> listaDeNavieras;

	@BeforeEach
	void setUp() throws Exception {
		
		empresaNaviera = new EmpresaNaviera("Atlantis");
		empresaNaviera2 = new EmpresaNaviera("Carilo");
		empresaNaviera3 = new EmpresaNaviera("Mardel");
		listaDeNavieras = new ArrayList<EmpresaNaviera>();
		
		listaDeNavieras.add(empresaNaviera);
		listaDeNavieras.add(empresaNaviera2);
		listaDeNavieras.add(empresaNaviera3);
		
		terminal = new TerminalPortuaria("ElAtlantico", listaDeNavieras);
		
	}

	@Test
	void test001_UnaTerminalPortuariaConoceSuNombre() {
		
		assertEquals(terminal.getNombre(), "ElAtlantico");
		
	}
	
	@Test
	void test002_UnaTerminalSabeCuantasEmpresasNavierasConoce() {
		
		assertEquals(terminal.navieras().size(), 3);
		
	}

}
