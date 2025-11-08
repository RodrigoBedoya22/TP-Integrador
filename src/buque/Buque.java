package buque;

import terminal_portuaria.Coordenada;

public class Buque {
	
	private String nombre;
	private Coordenada coordenada;
	private EstadoBuque estado;

	public Buque(String nombre, Coordenada coordenada) {
		this.nombre= nombre;
		this.coordenada= coordenada;
		this.estado= new OutOfBound();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public Coordenada getCoordenada() {
		return this.coordenada;
	}

	public EstadoBuque getEstado() {
		
		return this.estado;
	}

}
