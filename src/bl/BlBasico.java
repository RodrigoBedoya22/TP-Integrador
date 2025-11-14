package bl;

import cliente.Cliente;

public class BlBasico implements Bl{

	String tipoDeProducto;
	Double peso;
	Cliente propietario;
	
	/**
	 * Constructor de un B/L basico
	 * @param tipoDeProducto - El tipo de producto indicado en el B/L
	 * @param peso - El peso de la carga
	 * @param propietario - El propietario de la carga
	 */
	public BlBasico(String tipoDeProducto, double peso, Cliente propietario) {
		
		this.tipoDeProducto= tipoDeProducto;
		this.peso= peso;
		this.propietario= propietario;
	}
	
	/**
	 * Retorna el peso de la carga
	 */
	@Override
	public double getPeso() {
		
		return this.peso;
	}
	
	/**
	 * Retorna el propietario de la carga
	 */
	@Override
	public Cliente getPropietario() {
		return this.propietario;
	}
	
	/**
	 * Retorna el tipo de producto de la carga
	 */
	@Override
	public String getTipoDeProducto() {
		return this.tipoDeProducto;
	}

}
