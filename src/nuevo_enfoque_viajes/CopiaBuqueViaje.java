package nuevo_enfoque_viajes;

import java.time.LocalDate;


public class CopiaBuqueViaje {

	private CopiaBuque buque;
	private CopiaCircuitoMaritimo circuito;
    private CopiaTramo tramoActual;
	private LocalDate fechaDeSalida;
	
	public CopiaBuqueViaje(CopiaBuque buque, CopiaCircuitoMaritimo circuito, LocalDate fechaDeSalida){
		this.buque = buque;
        this.circuito = circuito;
        //el tramo actual en principio es el primero del circuito.
        this.tramoActual = circuito.getTramos().get(0);
        this.fechaDeSalida = fechaDeSalida;
	}
	
	public CopiaTramo getTramoActual() {
        return tramoActual;
    }
	
	/**
	 * Avanza al tramo inmediatamente siguiente al tramo actual, segun la lista de tramos del circuito. 
	 */
	public void pasarASiguienteTramo() {
	  int indice = this.circuito.getTramos().indexOf(tramoActual);
	  this.setTramoActual(this.circuito.getTramos().get(indice + 1));  
		  
	}
	
	private void setTramoActual(CopiaTramo tramo) {
		this.tramoActual = tramo;	
	}

	public CopiaCircuitoMaritimo getCircuito() {
        return circuito;
    }

	public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

	public CopiaBuque getBuque() {
		return buque;
	}
	
	/**
	 * Indica la duracion del viaje basandose en el circuito que recorre. 
	 * @return
	 */
	 
	public double getDuracion() {
		
		return circuito.getDuracion();
		
	}
	
	public double getPrecio() {
		
		return circuito.getPrecio();
		
	}
	
	/**
	 * Indica la cantidad de tramos del viaje
	 * @return int - la cantidad de tramos del viaje
	 */
	public int cantidadDeTramos() {
		return this.getCircuito().getTramos().size();
	}
	
	/**
	 * Indica si el circuito del viaje contiene a un tramo cuya terminal destino posea el nombre dado.
	 * @param nombre - El nombre del tramo destino que se buscará dentro del circuito.
	 * @return True si alguno de los tramos posee dicho puerto destino con ese nombre, False en caso contrario.
	 */
	public Boolean contieneTramoConDestino(String nombre) {	
		
		return this.circuito.contieneTramoConDestino(nombre);
	}
  

}
