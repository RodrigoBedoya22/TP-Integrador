package empresa_transportista;

public class Camion {
	
	private String patente;
	private Chofer chofer;
	
	public Camion(String patente) {
		
		this.patente = patente;
		
	}
	/**
	 * Indica el chofer asignado a dicho camion.
	 * @param chofer - El chofer a asignar dicho camion.
	 */
	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Chofer getChofer() {
		return chofer;
	}
	
	public String getPatente() {
		return patente;
	}


	
	

}
