package empresa_transportista;

import contenedor.Contenedor;

public class Camion {
	
	private String patente;
	private Chofer chofer;
	private Contenedor contenedor;
	
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
	public Contenedor getContenedor() {
		return contenedor;
	}
	
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}


	
	

}
