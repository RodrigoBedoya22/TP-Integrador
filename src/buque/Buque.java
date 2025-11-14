package buque;

import java.util.ArrayList;

import contenedor.Contenedor;
import coordenada.Coordenada;
import empresa_naviera.EmpresaNaviera;

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
	
	/**
	 * Delega a su estado actual el cambio al estado OutBound.Si se logra, el estado del buque cambiará, en caso contrario
	 *  se realiza una excepcion
	 */
    public void pasarAEstadoOutBound() {
   
    	estado.pasarAEstadoOutOfBound(this);
    }
	
    /**
	 * Delega a su estado actual el cambio al estado InBound.Si se logra, el estado del buque cambiará, en caso contrario
	 *  se realiza una excepcion
	 */
    public void pasarAEstadoInBound() {
    	
    	estado.pasarAEstadoInBound(this);
		
	}
    
    /**
	 * Delega a su estado actual el cambio al estado Arrived.Si se logra, el estado del buque cambiará, en caso contrario
	 *  se realiza una excepcion
	 */
    public void pasarAEstadoArrived() {
    	estado.pasarAEstadoArrived(this);
    }
    
    /**
	 * Delega a su estado actual el cambio al estado Working.Si se logra, el estado del buque cambiará, en caso contrario
	 *  se realiza una excepcion
	 */
    public void pasarAEstadoWorking() {
    	
    	estado.pasarAEstadoWorking(this);
		
	}
    
    /**
	 * Delega a su estado actual el cambio al estado Departing.Si se logra, el estado del buque cambiará, en caso contrario
	 *  se realiza una excepcion
	 */
    public void pasarAEstadoDeparting() {
    	
    	estado.pasarAEstadoDeparting(this);
    	
    }

}
