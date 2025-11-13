package empresa_naviera;

import java.util.Calendar;
import java.util.Date;

import buque.Buque;

public class BuqueViaje {

	private Buque buque;
	private CircuitoMaritimo circuito;
    private Tramo tramoActual;
	private Calendar fechaDeSalida;
	
	public BuqueViaje(Buque buque, CircuitoMaritimo circuito, Calendar fechaDeSalida){
		this.buque = buque;
        this.circuito = circuito;
        //el tramo actual en principio es el primero del circuito.
        this.tramoActual = circuito.getTramos().get(0);
        this.fechaDeSalida = fechaDeSalida;
	}
	
	public Tramo getTramoActual() {
        return tramoActual;
    }
	
	
	public void pasarASiguienteTramo() {
	  int indice = this.circuito.getTramos().indexOf(tramoActual);
	  this.setTramoActual(this.circuito.getTramos().get(indice + 1));  
		  
	}
	
	private void setTramoActual(Tramo tramo) {
		this.tramoActual = tramo;	
	}

	public CircuitoMaritimo getCircuito() {
        return circuito;
    }

	public Calendar getFechaDeSalida() {
        return fechaDeSalida;
    }

	public Buque getBuque() {
		return buque;
	}
	
	public double getDuracion() {
		
		return this.circuito.getDuracion();
		
	}
  

}
