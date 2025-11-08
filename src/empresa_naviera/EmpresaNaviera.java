package empresa_naviera;

import java.util.ArrayList;

import buque.Buque;

public class EmpresaNaviera {

	private String nombre;
	private ArrayList<BuqueViaje> viajes;
	private ArrayList<CircuitoMaritimo> circuitos;
	private ArrayList<Buque> buques;
	
	public EmpresaNaviera(String nombre) {
		
		this.nombre = nombre;
		this.viajes = new ArrayList<BuqueViaje>();
		this.circuitos = new ArrayList<CircuitoMaritimo>();
		this.buques = new ArrayList<Buque>();
		
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
	
	public void agregarBuque(Buque buque) {
		
		this.buques.add(buque);
		
	}
	
	public ArrayList<Buque> getBuques() {
        return this.buques;
    } 
	
	public void agregarCircuito(CircuitoMaritimo circuito) {
		this.circuitos.add(circuito);
	}
	
	public String getNombre() {
		return nombre;
	}

    
}
