package contenedor;

public class Tanque extends Contenedor {
	
	public Tanque(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso) {
		
	super(idString, idNumero, ancho, largo, alto, peso);
		
	}
	
	@Override
	public String tipo() {
		
		return "tanque";
		
	}

}
