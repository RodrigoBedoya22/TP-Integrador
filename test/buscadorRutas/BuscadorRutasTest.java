package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import empresa_naviera.EmpresaNaviera;
import terminal_portuaria.TerminalPortuaria;

class BuscadorRutasTest {
	
	BuscadorRutas buscador;
	TerminalPortuaria terminal;
	Coordenada coordenada;
	EmpresaNaviera empresaNaviera;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test001_UnBuscadorConoceASuTerminalPortuaria(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);

	    assertEquals(buscador.getTerminal(), terminal);
	
	}
	
	@Test
	void test002_UnBuscadorTienePorDefectoLaEstrategiaMenorTiempo(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);

	    assertInstanceOf(EstrategiaMenorTiempo.class, buscador.getEstrategia());
	}
	
	@Test
	void test003_SiElBuscadorCambiaDeEstrategia_SuEstrategiaCambia(){
		
	    TerminalPortuaria terminal = mock(TerminalPortuaria.class);
	    BuscadorRutas buscador= new BuscadorRutas(terminal);
	    EstrategiaMenorPrecio nuevaEstrategia = new EstrategiaMenorPrecio();
	    
	    buscador.setEstrategia(nuevaEstrategia);

	    assertInstanceOf(EstrategiaMenorPrecio.class, buscador.getEstrategia());
	}
	
	@Test
	void test004_CuandoElBuscadorUtilizaLaEstrategiaDeMenorPrecioConFiltroDePuertoDestinoDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorPrecio());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getPrecio()).thenReturn(400.0);
	    when(viajeStub1.contieneTramoConDestino("Miami")).thenReturn(true);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getPrecio()).thenReturn(200.0);
	    when(viajeStub2.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getPrecio()).thenReturn(300.0);
	    when(viajeStub3.contieneTramoConDestino("Miami")).thenReturn(true);
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub3);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    
	    assertEquals(buscador.buscar(new FiltroPuertoDestino("Miami")), listaDeViajesOrdenados);
		
	}
	
	@Test
	void test005_CuandoElBuscadorUtilizaLaEstrategiaDeMenorPrecioConFiltroDeFechaDeLlegadaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorPrecio());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getPrecio()).thenReturn(400.0);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getPrecio()).thenReturn(200.0);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 12, 5));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getPrecio()).thenReturn(300.0);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 12, 11));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeLlegada(LocalDate.of(2025, 12, 7), terminal.getNombre())), listaDeViajesOrdenados);
	    
	}
	
	@Test
	void test006_CuandoElBuscadorUtilizaLaEstrategiaDeMenorPrecioConFiltroDeFechaDeSalidaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorPrecio());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getPrecio()).thenReturn(400.0);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 1, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getPrecio()).thenReturn(200.0);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 2, 21));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getPrecio()).thenReturn(300.0);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 3, 21));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeSalida(LocalDate.of(2025, 12, 30), terminal.getNombre())), listaDeViajesOrdenados);
	    
	}
	
	@Test
	void test007_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTiempoConFiltroDePuertoDestinoDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTiempo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(60);
	    when(viajeStub1.contieneTramoConDestino("Miami")).thenReturn(true);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(31);
	    when(viajeStub2.contieneTramoConDestino("Miami")).thenReturn(true);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getDuracion()).thenReturn(30);
	    when(viajeStub3.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    
	    assertEquals(buscador.buscar(new FiltroPuertoDestino("Miami")), listaDeViajesOrdenados);
		
	}
	
	@Test
	void test008_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTiempoConFiltroDeFechaDeLlegadaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTiempo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(40);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(20);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 12, 5));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getDuracion()).thenReturn(30);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 11));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub3);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeLlegada(LocalDate.of(2025, 12, 7), terminal.getNombre())), listaDeViajesOrdenados);
	}

	@Test
	void test009_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTiempoConFiltroDeFechaDeSalidaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTiempo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(23);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 1, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(56);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 2, 21));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getDuracion()).thenReturn(98);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 3, 21));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub2);
	    
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeSalida(LocalDate.of(2025, 12, 30), terminal.getNombre())), listaDeViajesOrdenados);
	    
	}
	
	@Test
	void test010_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTransbordoConFiltroDePuertoDestinoDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTransbordo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.cantidadDeTramos()).thenReturn(6);
	    when(viajeStub1.contieneTramoConDestino("Miami")).thenReturn(true);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.cantidadDeTramos()).thenReturn(9);
	    when(viajeStub2.contieneTramoConDestino("Miami")).thenReturn(true);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.cantidadDeTramos()).thenReturn(8);
	    when(viajeStub3.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub2);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    
	    assertEquals(buscador.buscar(new FiltroPuertoDestino("Miami")), listaDeViajesOrdenados);
		
	}
	
	@Test
	void test011_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTransbordoConFiltroDeFechaDeLlegadaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTransbordo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.cantidadDeTramos()).thenReturn(14);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.cantidadDeTramos()).thenReturn(7);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 12, 5));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.cantidadDeTramos()).thenReturn(9);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 11));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub3);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeLlegada(LocalDate.of(2025, 12, 7), terminal.getNombre())), listaDeViajesOrdenados);
	}

	@Test
	void test012_CuandoElBuscadorUtilizaLaEstrategiaDeMenorTransbordoConFiltroDeFechaDeSalidaDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTransbordo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.cantidadDeTramos()).thenReturn(5);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 1, 21));
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.cantidadDeTramos()).thenReturn(9);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 2, 21));
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.cantidadDeTramos()).thenReturn(7);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 3, 21));
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    listaDeViajes.add(viajeStub2);
	    listaDeViajes.add(viajeStub3);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub1);
	    listaDeViajesOrdenados.add(viajeStub2);
	    
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroFechaDeSalida(LocalDate.of(2025, 12, 30), terminal.getNombre())), listaDeViajesOrdenados);
	    
	}
	
	@Test
	void test012_CuandoElBuscadorUtilizaLaEstrategiaMenorTiempoYUnFiltroANDDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTiempo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(40);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 21));
	    when(viajeStub1.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(20);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 12, 5));
	    when(viajeStub2.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getDuracion()).thenReturn(30);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 11));
	    when(viajeStub3.contieneTramoConDestino("Paraguay")).thenReturn(true);
	    BuqueViaje viajeStub4 = mock(BuqueViaje.class);
	    when(viajeStub4.getDuracion()).thenReturn(37);
	    when(viajeStub4.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 10, 21));
	    when(viajeStub4.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub4);
	    listaDeViajesOrdenados.add(viajeStub1);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    empresaNaviera.agregarViaje(viajeStub4);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroAnd(new FiltroPuertoDestino("LaPampa")
	    							, new FiltroFechaDeLlegada(LocalDate.of(2026, 1, 1), terminal.getNombre()  )  )  )
	    							, listaDeViajesOrdenados  );
		
	}
	
	@Test
	void test013_CuandoElBuscadorUtilizaLaEstrategiaMenorTiempoYUnFiltroORDevuelveLoQueCorresponde() {
		
		terminal = new TerminalPortuaria("jaja", new Coordenada(2.0, 3.7));
		buscador = new BuscadorRutas(terminal);
		empresaNaviera = new EmpresaNaviera("lol");
		
		buscador.setEstrategia(new EstrategiaMenorTiempo());
		BuqueViaje viajeStub1 = mock(BuqueViaje.class);
	    when(viajeStub1.getDuracion()).thenReturn(40);
	    when(viajeStub1.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 11, 21));
	    when(viajeStub1.contieneTramoConDestino("Canada")).thenReturn(true);
	    BuqueViaje viajeStub2 = mock(BuqueViaje.class);
	    when(viajeStub2.getDuracion()).thenReturn(20);
	    when(viajeStub2.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2026, 12, 5));
	    when(viajeStub2.contieneTramoConDestino("LaPampa")).thenReturn(true);
	    BuqueViaje viajeStub3 = mock(BuqueViaje.class);
	    when(viajeStub3.getDuracion()).thenReturn(30);
	    when(viajeStub3.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2025, 11, 11));
	    when(viajeStub3.contieneTramoConDestino("Paraguay")).thenReturn(true);
	    BuqueViaje viajeStub4 = mock(BuqueViaje.class);
	    when(viajeStub4.getDuracion()).thenReturn(37);
	    when(viajeStub4.getFechaDeLlegadaA(terminal.getNombre())).thenReturn(LocalDate.of(2027, 10, 21));
	    when(viajeStub4.contieneTramoConDestino("Jamaica")).thenReturn(true);
	    
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viajeStub1);
	    
	    ArrayList<BuqueViaje> listaDeViajesOrdenados = new ArrayList<BuqueViaje>();
	    listaDeViajesOrdenados.add(viajeStub2);
	    listaDeViajesOrdenados.add(viajeStub3);
	    
	    empresaNaviera.agregarViaje(viajeStub1);
	    empresaNaviera.agregarViaje(viajeStub2);
	    empresaNaviera.agregarViaje(viajeStub3);
	    empresaNaviera.agregarViaje(viajeStub4);
	    
	    terminal.agregarNaviera(empresaNaviera);
	    
	    assertEquals(buscador.buscar(new FiltroOr(new FiltroPuertoDestino("LaPampa")
	    							, new FiltroFechaDeLlegada(LocalDate.of(2026, 1, 1), terminal.getNombre()  )  )  )
	    							, listaDeViajesOrdenados  );
		
	}
	
}
