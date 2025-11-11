package carga;

import cliente.Cliente;

public abstract class Carga {
	
	String tipoDeProducto;
	double peso;
	Cliente propietario;
	
	public Carga(String tipoDeProducto, Cliente propietario) {
		this.tipoDeProducto = tipoDeProducto;
		this.propietario = propietario;
	}

	public String getTipoDeProducto() {
		return tipoDeProducto;
	}

	public abstract double getPeso();

	public Cliente getPropietario() {
		return propietario;
	}

}
