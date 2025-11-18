package empresa_naviera;

import java.util.ArrayList;

public class CircuitoMaritimo {
	
	ArrayList<Tramo> tramos;
	
    public CircuitoMaritimo (ArrayList<Tramo> tramos) {
    	
    	if(this.validarListaDeTramos(tramos)) {
    		this.tramos = tramos;
    	}
    }
    
    /**
     * Verifica que la lista de tramos del circuito cumpla con las condiciones: 
     * 	-	la lista de tramos no debe ser vacia.
     * 	- 	el puerto origen de un tramo debe ser el puerto destino del tramo anterior a él
     * 	-	el puerdo destino del tramo final del circuito debe ser el puerto origen del primer tramo, volviendolo cerrado.
     * 
     * @param tramos - La lista de tramos a validar si cumple las condiciones requeridas.
     * @return Boolean - True si es que cumple todas las condiciones, en caso contrario devuleve una excepcion.
     */
    public boolean validarListaDeTramos(ArrayList<Tramo> tramos){
    	//verificacion de lista vacia
    	if (tramos == null || tramos.isEmpty()) {
            throw new IllegalArgumentException("La lista de tramos del CircuitoMaritimo no es válida");
        }
    	//verificacion de que el puerto origen de un tramo es el puerto origen del anterior a él.
    	ArrayList<Tramo> copia = new ArrayList<>(tramos);
    	Tramo tramoAnterior = copia.get(0);
    	//por cada tramo
    	for (int i = 1; i < copia.size(); i++) {
    		Tramo tramo = copia.get(i);
            //si el tramo no tiene el puerto origen igual al puerto destino de su antepasado, genera excepcion
            if (!tramo.getTerminalOrigen().equals(tramoAnterior.getTerminalDestino())) {
                throw new IllegalArgumentException("Los tramos no están conectados correctamente");
            }

            tramoAnterior = tramo;
        }
    	//verificacion de que el ultimo tramo tiene como terminal destino a la terminal origen del primer tramo del circuito.
    	Tramo ultimo = copia.get(copia.size() - 1);
        if (!ultimo.getTerminalDestino().equals(copia.get(0).getTerminalOrigen())) {
            throw new IllegalArgumentException("El circuito no es cerrado correctamente");
        }
    	
    	 return true;
    	
    }

    public ArrayList<Tramo> getTramos() {
	
    	 return tramos;
    }
    
    /**
     * Obtiene la duracion en dias del circuito segun la duracion de sus tramos
     * @return Double - la duracion en días del circuito.
     */
	public double getDuracion() {
		
		double duracion= 0;
		for (Tramo tramo: tramos) {
			duracion+= tramo.getDuracion();
		}
		return duracion;
	}
	
	/**
	 * Retorna el precio segun el precio de sus tramos
	 * @return double- La suma de los precios del circuito
	 */
	public double getPrecio() {
		
		double precio= 0;
		for (Tramo tramo: tramos) {
			precio+= tramo.getPrecio();
		}
		return precio;
		
	}
	
	/**
	 * Indica si el circuito contiene a un tramo cuya terminal destino posea el nombre dado.
	 * @param nombre - El nombre del tramo destino que se buscará dentro del circuito.
	 * @return True si alguno de los tramos posee dicho puerto destino con ese nombre, False en caso contrario.
	 */
	public Boolean contieneTramoConDestino(String nombre) {	
		
		return tramos.stream().anyMatch(tramo -> tramo.getTerminalDestino().getNombre() == nombre);
	}

}
