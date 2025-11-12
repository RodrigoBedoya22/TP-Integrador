package buque;

import java.util.ArrayList;
import java.util.Date;

import contenedor.Contenedor;
import empresa_naviera.EmpresaNaviera;
import terminal_portuaria.Coordenada;

public class Buque {
	
	private String nombre;
	private ArrayList<Contenedor> contenedores;
	private Coordenada coordenada;
	private EstadoBuque estado;
	

	public Buque(String nombre, Coordenada coordenada) {
		this.nombre= nombre;
		this.coordenada= coordenada;
		this.contenedores = new ArrayList<Contenedor>();
		this.estado= new OutOfBound();
	}


	public String getNombre() {
		return this.nombre;
	}
	
	public Coordenada getCoordenada() {
		return this.coordenada;
	}
	
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public EstadoBuque getEstado() {
		
		return this.estado;
	}


	public void setEstado(EstadoBuque estado) {
		this.estado = estado;
	}


	public ArrayList<Contenedor> getContenedores() {
		return this.contenedores;
	}


	public void agregarContenedor(Contenedor contenedor) {
		
		this.contenedores.add(contenedor);
		
	}


	public void sacarContenedor(Contenedor contenedor) {
		this.contenedores.remove(contenedor);
		
	}
	
    public void pasarAEstadoOutBound() {
   
    	estado.pasarAEstadoOutOfBound(this);
    }
	
    public void pasarAEstadoInBound() {
    	
    	estado.pasarAEstadoOutOfBound(this);
		
	}
    
    public void pasarAEstadoArrived() {
    	
    }
    
    public void pasarAEstadoWorking() {
    	
    	estado.pasarAEstadoOutOfBound(this);
		
	}
    
    public void pasarAEstadoDeparting() {
    	
    	estado.pasarAEstadoOutOfBound(this);
    	
    }

}
