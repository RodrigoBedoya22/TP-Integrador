package carga;

import cliente.Cliente;

public class CargaBL extends Carga{

	Double peso;
	
	public CargaBL(String tipoDeProducto, double peso, Cliente propietario) {
		
		super(tipoDeProducto,propietario);
		this.peso= peso;
		
	}
	
	/**
	 * Retorna el peso registrado de la carga
	 */
	@Override
	public double getPeso() {
		
		return this.peso;
	}

}
