package contenedor;

import bl.BlBasico;

public class Reefer extends Contenedor {
	
	private double consumoDeEnergia;
	private BlBasico carga;
		
	public Reefer(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso
					, double consumo, BlBasico carga) {
		
		super(idString, idNumero, ancho, largo, alto, peso);
		this.consumoDeEnergia = consumo;
		this.carga = carga;
		
	} 
	
	/**
	 * Retorna el consumo de energia del contenedor
	 */
	@Override
	public double getConsumoDeEnergía() {
		return this.consumoDeEnergia;
	}

	@Override
	public BlBasico getCarga() {
		return this.carga;
	}


}
