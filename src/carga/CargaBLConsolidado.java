package carga;

import java.util.ArrayList;

import cliente.Cliente;

public class CargaBLConsolidado extends Carga{
	
	private ArrayList<Carga> cargas = new ArrayList<>();

	public CargaBLConsolidado(String tipoDeProducto, double peso, Cliente propietario, ArrayList<Carga> cargas) {
		super(tipoDeProducto, peso, propietario);
		this.cargas = cargas;
		
	}
	
	public void agregarCarga(Carga carga) {
		
		this.cargas.add(carga);
	}
	
    public void quitarCarga(Carga carga) {
		
		this.cargas.remove(carga);
	}

}
