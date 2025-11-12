package carga;

import java.util.ArrayList;

import cliente.Cliente;

public class CargaBLConsolidado extends Carga{
	
	private ArrayList<Carga> cargas;

	public CargaBLConsolidado(String tipoDeProducto, Cliente propietario) {
		super(tipoDeProducto, propietario);
		this.cargas = new ArrayList<Carga>();
		
	}
	
	/**
	 * Agrega una Carga a la lista de cargas del B/L consolidado. Puede ser tanto un B/L comun como otro B/L consolidado.
	 * @param carga - La carga a agregar.
	 * NOTA: La carga a agregar debe ser del mismo propietario.
	 */
	public void agregarCarga(Carga carga) {
		
		//si el propietario es el mismo, agrega la carga
		if(carga.getPropietario() == this.propietario) {
			
			this.cargas.add(carga); 
			
		} else {
			
			throw new IllegalArgumentException("La carga es de otro dueño");
			
		}    
		
	}
	
    public void quitarCarga(Carga carga) {
		
		this.cargas.remove(carga);
	}
    
    /**
     * Retorna la lista de cargas dentro del B/L consolidado
     * @return - La lista de cargas.
     */
	public ArrayList<Carga> getCargas() {
		return cargas;
	}
    
	/**
	 * Retorna la suma del peso de las cargas del B/L consolidado.
	 */
	@Override
	public double getPeso() {
		Double peso= 0.0;
		for (Carga carga: cargas) {
			peso+= carga.getPeso();
		}
		return peso;
	}
}
