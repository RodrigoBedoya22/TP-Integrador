package cliente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import carga.CargaBL;
import empresa_naviera.*;
import empresa_transportista.*;
import terminal_portuaria.*;
import servicio.Servicio;

class ClienteTest {
	
	Cliente cliente;
	@BeforeEach
	void setUp() throws Exception {
		
		cliente = new Cliente("Sergio", 12345678, "sergio@gmail.com");
	}

	@Test
	void test001_CuandoUnClienteCreaUnaOrdenDeExportacion_LaTerminalLaRegistra() {
		//Se crea el contexto :terminal como MOCK y lo demas como DUMMY porque son para relleno
		TerminalPortuaria terminal = mock(TerminalPortuaria.class);
		CargaBL carga= mock(CargaBL.class);
		BuqueViaje viaje= mock(BuqueViaje.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
				
		//se realiza la accion
		cliente.crearOrdenExportacion(viaje,carga, camion, chofer, serviciosRecibidos, terminal );
		
		//Se usa la terminal como un MOCK y se verifica que se le haya mandado el mensaje registrarOrden.
		verify(terminal).registrarOrden(any());
		
	}
	
	/*
	 * TODAVIA HAY QUE DEFINIR BIEN LA ORDEN DE IMPORTACION
	@Test
	void test002_CuandoUnClienteCreaUnaOrdenDeImportacion_LaTerminalLaRegistra() {
		
		TerminalPortuaria terminal = mock(TerminalPortuaria.class);
		CargaBL carga= mock(CargaBL.class);
		BuqueViaje viaje= mock(BuqueViaje.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		ArrayList<Servicio> serviciosRecibidos = new ArrayList<Servicio>();
				
		
		cliente.crearOrdenImportacion(viaje,carga, camion, chofer, serviciosRecibidos, terminal );
		
		verify(terminal).registrarOrden(any());
		
	}
	*/
	

}
