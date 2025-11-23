package contenedor;

import bl.Bl;

public class Dry extends Contenedor {
	
	private Bl carga;
	
	public Dry(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso, Bl carga) {
		
		super(idString, idNumero, ancho, largo, alto, peso);
		this.carga = carga;
		
	}

	@Override
	public Bl getCarga() {
		return this.carga;
	}
	
	@Override
	public double getConsumoDeEnergía() {
		return 0;
	}
	
	

}
