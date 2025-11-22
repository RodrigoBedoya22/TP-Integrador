package contenedor;

import bl.BlBasico;

public class Reefer extends Contenedor {
	
	private double consumoDeEnergia;
	private BlBasico carga;
		
	public Reefer(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso, double consumo, BlBasico carga) {
		
		super(idString, idNumero, ancho, largo, alto, peso);
		this.consumoDeEnergia = consumo;
		this.carga = carga;
		
	} 
	
	public double getConsumoDeEnergia() {
		return consumoDeEnergia;
	}

	
	public BlBasico getCarga() {
		return carga;
	}

	public void setCarga(BlBasico carga) {
		this.carga = carga;
	}

	/**
	 * Retorna el tipo de contenedor que es.
	 */
	@Override
	public String tipo() {
		
		return "Reefer";
		
	}
		
		

}
