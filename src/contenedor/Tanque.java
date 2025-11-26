package contenedor;

import bl.Bl;
import bl.BlBasico;

public class Tanque extends Contenedor {
	
	private BlBasico carga;
	
	public Tanque(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso, BlBasico carga) {
		
	super(idString, idNumero, ancho, largo, alto, peso);
	this.carga = carga;
		
	}

	@Override
	public Bl getCarga() {
		// TODO Auto-generated method stub
		return this.carga;
	}

	/**
	 * Un contenedor tanque no consume energia, retorna 0.
	 */
	@Override
	public double getConsumoDeEnergía() {
		return 0;
	}

	@Override
	public String getTipo() {
		
		return "Tanque";
	}
	
}
