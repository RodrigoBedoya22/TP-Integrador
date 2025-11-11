package contenedor;

public class Reefer extends Contenedor {
	
	private Integer consumoDeEnergia;
		
	public Reefer(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso) {
		
	super(idString, idNumero, ancho, largo, alto, peso);
	this.consumoDeEnergia = 0;
		
	} 
	
	@Override
	public String tipo() {
		
		return "Reefer";
		
	}
		
		

}
