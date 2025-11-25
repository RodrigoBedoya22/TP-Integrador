package empresa_naviera;

import java.time.LocalDate;
import java.util.ArrayList;

import buque.Buque;


public class BuqueViaje {

	private Buque buque;
	private CircuitoMaritimo circuito;
    private Tramo tramoActual;
	private LocalDate fechaDeSalida;
	private ArrayList<LocalDate> fechasDeArribo;
	
	public BuqueViaje(Buque buque, CircuitoMaritimo circuito, LocalDate fechaDeSalida){
		this.buque = buque;
        this.circuito = circuito;
        //el tramo actual en principio es el primero del circuito.
        this.tramoActual = circuito.getTramos().get(0);
        this.fechaDeSalida = fechaDeSalida;
        this.fechasDeArribo = new ArrayList<LocalDate>();
        this.definirCronograma();
	}

	public Tramo getTramoActual() {
        return tramoActual;
    }
	
	/**
	 * Avanza al tramo inmediatamente siguiente al tramo actual, segun la lista de tramos del circuito. 
	 */
	public void pasarASiguienteTramo() {
	  int indiceActual = this.circuito.getTramos().indexOf(tramoActual);	  
	  if (indiceActual < circuito.getTramos().size() - 1) {
		  this.setTramoActual(this.circuito.getTramos().get(indiceActual + 1)); 
	  }
	}
	
	private void setTramoActual(Tramo tramo) {
		this.tramoActual = tramo;	
	}

	public CircuitoMaritimo getCircuito() {
        return circuito;
    }

	public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

	public Buque getBuque() {
		return buque;
	}
	
	/**
	 * Indica la duracion del viaje basandose en el circuito que recorre. 
	 * @return
	 */
	 
	public int getDuracion() {
		
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

	public LocalDate getFechaDeLlegadaA(String nombreDeTerminal) {
		
	 Tramo tramoActual = circuito.getTramos().stream().filter(tramo -> tramo.getTerminalDestino().getNombre().equals(nombreDeTerminal)).findFirst().get();
	 int indiceDeTramo = circuito.getTramos().indexOf(tramoActual);
	 return this.getFechasDeArribo().get(indiceDeTramo);
		
	}

	public ArrayList<LocalDate> getFechasDeArribo() {
	 	
		return this.fechasDeArribo;
	}
	/**
	 * Define el cronograma de fechas segun la fecha de salida del viaje.
	 * La fecha del siguiente tramo es la fecha de llegada del anterior + la duracion del tramo actual.
	 * Se asume que un buque llega y se retira el mismo dia, por lo que fecha de llegada y salida son las mismas.
	 */
	public void definirCronograma() {
	    // Se setea la primera fecha 
		Tramo tramoAnterior = circuito.getTramos().get(0);
		this.fechasDeArribo.add(fechaDeSalida.plusDays(tramoAnterior.getDuracion()));
		LocalDate fechaAnterior = this.fechasDeArribo.get(0);
		
		// Basandose en la fecha anterior se setea la siguiente por cada tramo del circuito
		for(int i = 1; i < circuito.getTramos().size(); i++) {
			Tramo tramoActual = circuito.getTramos().get(i);
			LocalDate fechaActual = fechaAnterior.plusDays(tramoActual.getDuracion());
			fechasDeArribo.add(fechaActual);
			
			// Se pasa al siguiente tramo
			tramoAnterior = tramoActual;
			fechaAnterior = fechaActual;
		}
		
	}
  

	/*
	public LocalDate fechaDeSalidaDesde(String nombreDeTerminal) {
		return this.fechaDeSalida.plusDays(this.getCircuito().getTramos().get(0).
				                           getTerminalOrigen().distanciaHastaTerminal(nombreDeTerminal));
	}
	*/
  

}
