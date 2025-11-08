package empresa_transportista;

public class Camion {
	
	private String patente;
	private Chofer chofer;
	
	public Camion(String patente) {
		
		this.patente = patente;
		
	}

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
