package carga;

import java.util.ArrayList;

import cliente.Cliente;

public class CargaBLConsolidado extends Carga{
	
	private ArrayList<Carga> cargas;

	public CargaBLConsolidado(String tipoDeProducto, Cliente propietario) {
		super(tipoDeProducto, propietario);
		this.cargas = new ArrayList<Carga>();
		
	}
	
	public void agregarCarga(Carga carga) {
		
		if(carga.getPropietario() == this.propietario) {
			
			this.cargas.add(carga); 
			
		} else {
			
			throw new IllegalArgumentException("La carga es de otro dueño");
			
		}    
		
	}
	
    public void quitarCarga(Carga carga) {
		
		this.cargas.remove(carga);
	}

	public ArrayList<Carga> getCargas() {
		return cargas;
	}
    
	@Override
	public double getPeso() {
		Double peso= 0.0;
		for (Carga carga: cargas) {
			peso+= carga.getPeso();
		}
		return peso;
	}
}
