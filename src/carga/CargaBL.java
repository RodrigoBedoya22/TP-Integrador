package carga;

import cliente.Cliente;

public class CargaBL extends Carga{

	public CargaBL(String tipoDeProducto, double peso, Cliente propietario) {
		super(tipoDeProducto, peso, propietario);
		
	}
	
	public String getTipoDeProducto() {
		return tipoDeProducto;
	}

	public double getPeso() {
		return peso;
	}

	public Cliente getPropietario() {
		return propietario;
	}
	
	

}
