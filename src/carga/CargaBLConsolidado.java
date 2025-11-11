package carga;

import java.util.ArrayList;

import cliente.Cliente;

public class CargaBLConsolidado extends Carga{
	
	private ArrayList<Carga> cargas;

	public CargaBLConsolidado(String tipoDeProducto, double peso, Cliente propietario) {
		super(tipoDeProducto, peso, propietario);
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
    
}
