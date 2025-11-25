package buque;

import java.util.ArrayList;

import contenedor.Contenedor;
import coordenada.Coordenada;
import empresa_naviera.BuqueViaje;
import empresa_naviera.GPS;
import orden.*;

public class Buque {
	
	private String nombre;
	private Coordenada coordenada;
	private EstadoBuque estado;
	private GPS gps;
	private BuqueViaje viajeActual;
	public ArrayList<Orden> listaDeOrdenes;
	

	public Buque(String nombre) {
		this.nombre= nombre;
		this.listaDeOrdenes = new ArrayList<Orden>();
		this.estado= new OutOfBound();
		this.gps= new GPS(new Coordenada(0, 0), this);
		this.coordenada= this.gps.getCoordenadaGPS();
		
		
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public Coordenada getCoordenada() {
		return this.coordenada;
	}
	
	public void actualizarCoordenada() {
		this.coordenada = this.gps.getCoordenadaGPS();
		this.evaluarEstado();
	}
	
	public GPS getGPS() {
		return this.gps;
	}
	public void evaluarEstado() {
		this.estado.evaluarCambioDeEstado(this);
	}

	public EstadoBuque getEstado() {
		
		return this.estado;
	}


	public void setEstado(EstadoBuque estado) {
		this.estado = estado;
	}

	/**
	 * Retorna los contenedores que posee el buque
	 * @return la lista de contenedores del buque
	 */
	public ArrayList<Orden> getOrdenes() {
		return this.listaDeOrdenes;
	}

	/**
	 * Agrega una orden dad< a la lista de ordenes del buque
	 * @param orden - La orden a a gregar
	 */
	public void agregarOrden(Orden orden) {
		
		this.listaDeOrdenes.add(orden);
		
	}

	/**
	 * Saca la orden dada de la lista de ordenes del buque
	 * @param orden - La orden a sacar del buque
	 */
	public void sacarOrden(Orden orden) {
		this.listaDeOrdenes.remove(orden);
		
	}
	
	public BuqueViaje getViaje() {
		return this.viajeActual;
	}
	public void setViaje(BuqueViaje viaje ) {
		this.viajeActual = viaje;
	}
	
	/**
	 * Retorna la distancia en kilometros hacia el destino del tramo actual.
	 * @return Double- La distancia en kilometros hacia el destino actual del viaje.
	 */
	public Double distanciaHaciaDestinoActual() {
		return this.coordenada.distanciaHaciaCoordenada(this.viajeActual.getTramoActual().getTerminalDestino().getCoordenada());
	}
	

}

