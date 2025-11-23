package contenedor;

import bl.Bl;

public abstract class Contenedor {
	
	private String idString;
	private Integer idNumero;
	private Double ancho;
	private Double largo;
	private Double alto;
	private Double peso;
	
	public Contenedor(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso) {
		
		this.idString = idString;
		this.idNumero = idNumero;
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.peso = peso;
		
	}

	public Double getAncho() {
		return ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public Double getAlto() {
		return alto;
	}

	public Double getPeso() {
		return peso;
	}
	
	/**
	 * Retorna el identificador completo del contenedor, con 4 digitos alfabeticos y 7 digitos numericos.
	 * @return el identificador completo del contenedor
	 */
	public String getIdentificador() {
		
		String idNumerico = String.valueOf(idNumero);
		return idString +  idNumerico;
		
	}
	/**
	 * Retorna los metros cubicos de un contenedor basandose en sus medidas: ancho, largo y alto
	 * @return Double - Los metros cubicos del contenedor segun sus medidas.
	 */
	public double metrosCubicos() {
		
		double metrosCubicos = 0;
		metrosCubicos = this.alto * this.ancho * this.largo;
		//se redondea a 2 decimales
		return Math.round(metrosCubicos * 100.0) / 100.0;
		
	}
	
	public abstract Bl getCarga();
	public abstract double getConsumoDeEnergía();
	
}
