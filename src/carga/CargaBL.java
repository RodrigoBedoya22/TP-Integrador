package carga;

import cliente.Cliente;

public class CargaBL extends Carga{

	Double peso;
	
	public CargaBL(String tipoDeProducto, double peso, Cliente propietario) {
		
		super(tipoDeProducto,propietario);
		this.peso= peso;
		
	}
	
	@Override
	public double getPeso() {
		
		return this.peso;
	}

}
