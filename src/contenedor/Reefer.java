package contenedor;

public class Reefer extends Contenedor {
	
	private double consumoDeEnergia;
		
	public Reefer(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso, double consumo) {
		
		super(idString, idNumero, ancho, largo, alto, peso);
		this.consumoDeEnergia = consumo;
		
	} 
	
	/**
	 * Retorna el tipo de contenedor que es.
	 */
	@Override
	public String tipo() {
		
		return "Reefer";
		
	}
		
		

}
