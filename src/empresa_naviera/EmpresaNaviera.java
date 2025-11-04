package empresa_naviera;

import java.util.ArrayList;

public class EmpresaNaviera {

	private String nombre;
	private ArrayList<BuqueViaje> viajes;
	private ArrayList<CircuitoMaritimo> circuitos;
	
	public EmpresaNaviera(String nombre) {
		
		this.nombre = nombre;
		this.viajes = new ArrayList<BuqueViaje>();
		this.circuitos = new ArrayList<CircuitoMaritimo>();
		
	}
	
	public ArrayList<BuqueViaje> getViajes() {
        return this.viajes;
    }
	
	public ArrayList<CircuitoMaritimo> getCircuitos() {
        return this.circuitos;
    }
	
	public void agregarViaje(BuqueViaje viaje) {
		
        this.viajes.add(viaje);
    }
	
	public void agregarCircuito(CircuitoMaritimo circuito) {
		this.circuitos.add(circuito);
	}
	
	public String getNombre() {
		return nombre;
	}

    
}
