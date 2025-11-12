package empresa_naviera;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class CircuitoMaritimo {
	
	ArrayList<Tramo> tramos;
	
    public CircuitoMaritimo (ArrayList<Tramo> tramos) {
    	
    	if(this.validarListaDeTramos(tramos)) {
    		this.tramos = tramos;
    	}
    }
    
    public boolean validarListaDeTramos(ArrayList<Tramo> tramos){
   
    	if (tramos == null || tramos.isEmpty()) {
            throw new IllegalArgumentException("La lista de tramos del CircuitoMaritimo no es válida");
        }
    	
    	ArrayList<Tramo> copia = new ArrayList<>(tramos);
    	Tramo tramoAnterior = copia.get(0);
    	
    	for (int i = 1; i < copia.size(); i++) {
            Tramo tramo = copia.get(i);

            if (!tramo.getTerminalOrigen().equals(tramoAnterior.getTerminalDestino())) {
                throw new IllegalArgumentException("Los tramos no están conectados correctamente");
            }

            tramoAnterior = tramo;
        }
    	
    	Tramo ultimo = copia.get(copia.size() - 1);
        if (!ultimo.getTerminalDestino().equals(copia.get(0).getTerminalOrigen())) {
            throw new IllegalArgumentException("El circuito no es cerrado correctamente");
        }
    	
    	 return true;
    	
    }

    public ArrayList<Tramo> getTramos() {
	
    	 return tramos;
    }

	public double getDuracion() {
		
		double duracion= 0;
		for (Tramo tramo: tramos) {
			duracion+= tramo.getDuracion();
		}
		return duracion;
	}

	public Boolean contieneTramoConDestino(String nombre) {	
		
		return tramos.stream().anyMatch(tramo -> tramo.getTerminalDestino().getNombre() == nombre);
	}

}
