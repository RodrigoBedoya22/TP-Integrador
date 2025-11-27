package reportes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.Bl;
import buque.Buque;
import contenedor.Contenedor;
import contenedor.Dry;
import empresa_naviera.*;
import orden.*;
import terminal_portuaria.TerminalPortuaria;

class ReporteMuelleTest {

	ReporteMuelle reporte;
	BuqueViaje viaje;
	Buque buque;
	Orden orden1, orden2;
	TerminalPortuaria terminal;
	Contenedor contenedor;
	Bl carga;
	
	@BeforeEach
	void setUp() throws Exception {

		terminal= mock(TerminalPortuaria.class);
		reporte = new ReporteMuelle();
		viaje= mock(BuqueViaje.class);
		when(viaje.getTramoActual()).thenReturn(new Tramo(terminal, terminal, 2.0));
		when(viaje.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2020, 12, 2));
		buque= new Buque("Titanic");
		buque.setViaje(viaje);
		
		
		carga= mock(Bl.class);
		contenedor= new Dry("ABCD", 1234567, 2.0, 2.0, 2.0, 2.0, carga);
		
		orden1= mock(OrdenExportacion.class);
		when(orden1.getContenedor()).thenReturn(contenedor);
		
		orden2= mock(OrdenImportacion.class);
		when(orden2.getContenedor()).thenReturn(contenedor);
		
		buque.agregarOrden(orden1);
		buque.agregarOrden(orden2);
	}

/*	@Test
	void test001_SiElReporteMuelleAccedeAUnaTerminal_ObtieneSusDatos() {
		
		ReporteMuelle reporteSpy = spy(reporte);
		reporteSpy.visitarBuque(buque);
		
		verify(reporteSpy).setDatos(any());;
	}
	
	@Test
	void test002_SiSeLePideAUnReporteMuelleImprimirse_SeImprimeEnConsola() {
		
		ReporteMuelle reporteSpy = spy(reporte);
		reporteSpy.visitarBuque(buque);
		reporteSpy.print();
		verify(reporteSpy).print();
	}
*/
}
