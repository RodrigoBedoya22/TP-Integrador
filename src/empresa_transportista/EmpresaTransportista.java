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
	
	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
		
	}

	public ArrayList<Camion> getCamiones() {
		return camiones;
	}

	public ArrayList<Chofer> getChoferes() {
	    return choferes;
	}

}
