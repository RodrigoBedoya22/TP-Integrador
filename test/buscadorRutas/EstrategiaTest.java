package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import empresa_naviera.BuqueViaje;
import empresa_naviera.CircuitoMaritimo;
import empresa_naviera.Tramo;
import terminal_portuaria.Coordenada;
import terminal_portuaria.TerminalPortuaria;

class EstrategiaTest {

	Estrategia estrategiaMenorTiempo;
	Estrategia estrategiaMenorPrecio;
	Buque buque;
	BuqueViaje viaje;
	BuqueViaje viaje2;
	TerminalPortuaria terminalA, terminalB, terminalC, terminalD;
	Tramo tramoAB, tramoBC, tramoCA, tramoDB, tramoCD, tramoDA;
	CircuitoMaritimo circuito;
	
	@BeforeEach
	void setUp() throws Exception {
		
	estrategiaMenorTiempo = new EstrategiaMenorTiempo();
	estrategiaMenorPrecio = new EstrategiaMenorPrecio();
	Coordenada coordenadaDeBuque = new Coordenada(1.0,2.0);
	buque= new Buque("Titanic", coordenadaDeBuque);
		   
	terminalA = new TerminalPortuaria("Terminal A", new Coordenada(10, 222));
	terminalB = new TerminalPortuaria("Terminal B", new Coordenada(102, 5));
	terminalC = new TerminalPortuaria("Terminal C", new Coordenada(0, 33));
	terminalD = new TerminalPortuaria("Terminal D", new Coordenada(56, 73));
			
	tramoAB = new Tramo(terminalA, terminalB, 10000.0);
	tramoBC = new Tramo(terminalB, terminalC, 10000.0);
	tramoCA = new Tramo(terminalC, terminalA, 10000.0);
	tramoCD = new Tramo(terminalC, terminalD, 10000.0);
	tramoDA = new Tramo(terminalD, terminalA, 10000.0);
		
	}

	@Test
	void test001_LaEstrategiaDeMenorTiempoSabeCualEsElBuqueViajeQueTardaMenosEnLlegarASuDestino() {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		Calendar fecha = Calendar.getInstance();
	    fecha.set(1990, Calendar.OCTOBER, 23);
	    
	    viaje= new BuqueViaje(buque,circuito, fecha);
		
		ArrayList<Tramo> otraListaDeTramos = new ArrayList<Tramo>();
		otraListaDeTramos.add(tramoAB);
		otraListaDeTramos.add(tramoBC);
		otraListaDeTramos.add(tramoCD);
		otraListaDeTramos.add(tramoDA);
		CircuitoMaritimo circuito2 = new CircuitoMaritimo(otraListaDeTramos);
		
		Calendar fecha2 = Calendar.getInstance();
	    fecha2.set(1991, Calendar.OCTOBER, 23);
	    
	    viaje2= new BuqueViaje(buque,circuito2, fecha2);
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viaje);
	    listaDeViajes.add(viaje2);
	    
		assertTrue(estrategiaMenorTiempo.filtrar(listaDeViajes) == viaje);
		
	}
	
	@Test
	void test002_LaEstrategiaDeMenorPrecioSabeCualEsElBuqueViajeMásBarato() {
		
		ArrayList<Tramo> listaDeTramos= new ArrayList<Tramo>();
		listaDeTramos.add(tramoAB);
		listaDeTramos.add(tramoBC);
		listaDeTramos.add(tramoCA);
		CircuitoMaritimo circuito = new CircuitoMaritimo(listaDeTramos);
		
		Calendar fecha = Calendar.getInstance();
	    fecha.set(1990, Calendar.OCTOBER, 23);
	    
	    viaje= new BuqueViaje(buque,circuito, fecha);
		
		ArrayList<Tramo> otraListaDeTramos = new ArrayList<Tramo>();
		otraListaDeTramos.add(tramoAB);
		otraListaDeTramos.add(tramoBC);
		otraListaDeTramos.add(tramoCD);
		otraListaDeTramos.add(tramoDA);
		CircuitoMaritimo circuito2 = new CircuitoMaritimo(otraListaDeTramos);
		
		Calendar fecha2 = Calendar.getInstance();
	    fecha2.set(1991, Calendar.OCTOBER, 23);
	    
	    viaje2= new BuqueViaje(buque,circuito2, fecha2);
		
	    ArrayList<BuqueViaje> listaDeViajes = new ArrayList<BuqueViaje>();
	    listaDeViajes.add(viaje);
	    listaDeViajes.add(viaje2);
	    
		assertTrue(estrategiaMenorPrecio.filtrar(listaDeViajes) == viaje);
		
	}

}
