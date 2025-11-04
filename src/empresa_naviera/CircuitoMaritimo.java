package empresa_naviera;

import java.util.ArrayList;

public class CircuitoMaritimo {
	
	ArrayList<Tramo> tramos;
	
    public CircuitoMaritimo (ArrayList<Tramo> tramos) {
		
		 this.tramos = tramos;	
	}

    public ArrayList<Tramo> getTramos() {
	
    	 return tramos;
    }

}
