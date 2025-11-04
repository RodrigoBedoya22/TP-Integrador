package empresa_naviera;

import java.util.ArrayList;

public class EmpresaNaviera {

	private String nombre;
	private ArrayList<BuqueViaje> viajes = new ArrayList<>();
	private ArrayList<CircuitoMaritimo> circuitos = new ArrayList<>();
	
	public EmpresaNaviera(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public ArrayList<BuqueViaje> getViajes() {
        return viajes;
    }
	
	public ArrayList<CircuitoMaritimo> getCircuitos() {
        return circuitos;
    }
	
	public void agregarViaje(BuqueViaje viaje) {
        viajes.add(viaje);
    }
	
	 public void agregarCircuito(CircuitoMaritimo circuito) {
	        circuitos.add(circuito);
	    }
	
	public String getNombre() {
		return nombre;
	}

    
}
