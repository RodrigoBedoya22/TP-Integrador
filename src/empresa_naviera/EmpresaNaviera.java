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
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<BuqueViaje> getViajes() {
        return this.viajes;
    }
	
	public ArrayList<CircuitoMaritimo> getCircuitos() {
        return this.circuitos;
    }
	
	/**
	 * Agrega un viaje a la lista de viajes ofrecidos
	 * @param viaje - El viaje a agregar
	 */
	public void agregarViaje(BuqueViaje viaje) {
		
        this.viajes.add(viaje);
    }
	
	/**
	 * Agrega un buque a su lista de buques.
	 * @param buque - El buque a agregar
	 */
	public void agregarBuque(Buque buque) {
		
		this.buques.add(buque);
		
	}
	
	/**
	 * Retorna la lista de buques de la empresa naviera
	 * @return - La lista de buques de la naviera.
	 */
	public ArrayList<Buque> getBuques() {
        return this.buques;
    } 
	
	/**
	 * Agrega un circuito a la lista de circuitos maritimos de la empresa naviera.
	 * @param circuito - El circuito a agregar
	 */
	public void agregarCircuito(CircuitoMaritimo circuito) {
		this.circuitos.add(circuito);
	}
	

    
}
