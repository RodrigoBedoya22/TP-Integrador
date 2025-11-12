package empresa_transportista;

import java.util.ArrayList;


public class EmpresaTransportista {
	
	private String nombre;
	private ArrayList<Chofer> choferes;
	private ArrayList<Camion> camiones;
	
    public EmpresaTransportista(String nombre, ArrayList<Camion> camiones) {
		
		this.nombre = nombre;
		this.camiones = camiones;
		this.choferes = new ArrayList<Chofer>();
		
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregarCamion(Camion camion) {
		
		this.camiones.add(camion);
		
	}
	/**
	 * Agrega un chofer a la lista de choferes que trabajan para la empresa transportista
	 * @param chofer - El chofer a agregar
	 */
	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
		
	}
	
	/**
	 * Retorna la lista de camiones de la empresa transportista
	 * @return - La lista de camiones de la empresa transportista
	 */
	public ArrayList<Camion> getCamiones() {
		return camiones;
	}

	/**
	 * Retorna la lista de choferes de la empresa transportista
	 * @return - La lista de choferes de la empresa transportista
	 */
	public ArrayList<Chofer> getChoferes() {
	    return choferes;
	}

}
