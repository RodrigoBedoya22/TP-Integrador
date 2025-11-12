package empresa_naviera;

import java.util.Date;

import buque.Buque;

public class BuqueViaje {

	private Buque buque;
	private CircuitoMaritimo circuito;
	private Tramo tramoActual;
	private Date fechaDeSalida;
	
	public BuqueViaje(Buque buque, CircuitoMaritimo circuito, Date fechaDeSalida){
		this.buque = buque;
        this.circuito = circuito;
        this.fechaDeSalida = fechaDeSalida;
	}
	

	public Tramo getTramoActual() {
        return tramoActual;
    }
	
	public CircuitoMaritimo getCircuito() {
        return circuito;
    }
	
	public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

	public Buque getBuque() {
		return buque;
	}


}
