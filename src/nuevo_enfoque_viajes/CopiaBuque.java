package nuevo_enfoque_viajes;

import java.util.ArrayList;

import contenedor.Contenedor;
import coordenada.Coordenada;

public class CopiaBuque {
	
	private String nombre;
	private ArrayList<Contenedor> contenedores;
	private Coordenada coordenada;
	private CopiaEstadoBuque estado;
	private CopiaGPS gps;
	private CopiaBuqueViaje viajeActual;
	

	public CopiaBuque(String nombre) {
		this.nombre= nombre;
		this.contenedores = new ArrayList<Contenedor>();
		this.estado= new CopiaOutOfBound();
		this.gps= new CopiaGPS(new Coordenada(0, 0), this);
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
	
	public CopiaGPS getGPS() {
		return this.gps;
	}
	public void evaluarEstado() {
		this.estado.evaluarCambioDeEstado(this);
	}

	public CopiaEstadoBuque getEstado() {
		
		return this.estado;
	}


	public void setEstado(CopiaEstadoBuque estado) {
		this.estado = estado;
	}

	/**
	 * Retorna los contenedores que posee el buque
	 * @return la lista de contenedores del buque
	 */
	public ArrayList<Contenedor> getContenedores() {
		return this.contenedores;
	}

	/**
	 * Agrega un contenedor dado a la lista de contenedores del buque
	 * @param contenedor - El contenedor a a gregar
	 */
	public void agregarContenedor(Contenedor contenedor) {
		
		this.contenedores.add(contenedor);
		
	}

	/**
	 * Saca el contenedor dado de la lista de contenedores del buque
	 * @param contenedor - El contenedor a sacar del buque
	 */
	public void sacarContenedor(Contenedor contenedor) {
		this.contenedores.remove(contenedor);
		
	}
	
	public CopiaBuqueViaje getViaje() {
		return this.viajeActual;
	}
	public void setViaje(CopiaBuqueViaje viaje ) {
		this.viajeActual = viaje;
	}
	public Double distanciaHaciaDestinoActual() {
		return this.coordenada.distanciaHaciaCoordenada(this.viajeActual.getTramoActual().getTerminalDestino().getCoordenada());
	}
	

}
