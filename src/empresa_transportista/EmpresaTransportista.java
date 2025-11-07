package empresa_transportista;

import java.util.ArrayList;

// import java.util.ArrayList;


public class EmpresaTransportista {
	
	private String nombre;
	private ArrayList<Chofer> choferes;
	
    public EmpresaTransportista(String nombre) {
		
		this.nombre = nombre;
		//this.camiones = new ArrayList<Camion>();
		this.choferes = new ArrayList<Chofer>();
		
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
		
	}

	// public ArrayList<Camion> getCamiones() {
	//	return camiones;
	//}

	public ArrayList<Chofer> getChoferes() {
	    return choferes;
	}

}
