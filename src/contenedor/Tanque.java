package contenedor;

public class Tanque extends Contenedor {
	
	public Tanque(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso) {
		
	super(idString, idNumero, ancho, largo, alto, peso);
		
	}
	
	/**
	 * Retorna el tipo de contenedor que es.
	 */
	@Override
	public String tipo() {
		
		return "Tanque";
		
	}

}
