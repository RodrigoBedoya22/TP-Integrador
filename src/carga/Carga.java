package carga;

import cliente.Cliente;

public abstract class Carga {
	
	String tipoDeProducto;
	double peso;
	Cliente propietario;
	
	public Carga(String tipoDeProducto, double peso, Cliente propietario) {
		this.tipoDeProducto = tipoDeProducto;
		this.peso = peso;
		this.propietario = propietario;
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
