package bl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import cliente.Cliente;

public class BLConsolidado implements Bl{
	
	private ArrayList<Bl> cargas;
	
	/**
	 * Constructor de bl consolidado, en principio no tiene cargas.
	 */
	public BLConsolidado() {
		
		this.cargas = new ArrayList<Bl>();
	}
	
	/**
     * Retorna la lista de cargas dentro del B/L consolidado
     * @return - La lista de cargas.
     */
	public ArrayList<Bl> getCargas() {
		return this.cargas;
	}
	
	/**
	 * Retorna la suma del peso de las cargas del B/L consolidado.
	 */
	@Override
	public double getPeso() {
		Double peso= 0.0;
		for (Bl carga: cargas) {
			peso+= carga.getPeso();
		}
		return peso;
	}
	
	/**
	 * Retorna el propietario de todas las cargas del b/l consolidado. 
	 */
	@Override
	public Cliente getPropietario() {
		//
		return this.cargas.get(0).getPropietario();
	}
	
	/**
	 * Retorna el tipo de todos los productos de las cargas del b/l consolidado
	 */
	@Override
	public String getTipoDeProducto() {
	    return cargas.stream()
	            .map(Bl::getTipoDeProducto)
	            .distinct()
	            .collect(Collectors.joining(", "));
	}
	
	/**
	 * Agrega una Carga a la lista de cargas del B/L consolidado. Puede ser tanto un B/L comun como otro B/L consolidado.
	 * @param carga - La carga a agregar.
	 * NOTA: La carga a agregar debe ser del mismo propietario.
	 */
	public void agregarCarga(Bl carga) {
		
		//si el propietario es el mismo, agrega la carga. Si no tiene propietario, se agrega como primer elemento.
		if(   (this.cargas.isEmpty()) || (carga.getPropietario() == this.getPropietario()) ){
			
			this.cargas.add(carga); 
			
		} else {
			
			throw new IllegalArgumentException("La carga es de otro dueño");
			
		}    
	}
	
	/**
	 * Quita una carga de la lista de cargas del b/l consolidado. Si la carga no se encuentra en la lista de cargas, no hace nada
	 * @param carga - La carga a quitar
	 */
    public void quitarCarga(Bl carga) {
		if(this.cargas.contains(carga)) {
			this.cargas.remove(carga);
		}
	}
    
}
