package empresa_naviera;

import java.util.Date;

import terminal_portuaria.TerminalPortuaria;



public class Tramo {
	
	TerminalPortuaria terminalOrigen;
	TerminalPortuaria terminalDestino;
	Date duracion;
	Double precio; 
	
	public Tramo(TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino, Date duracion, Double precio){
		this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.duracion = duracion;
        this.precio = precio;
	}
	
	public TerminalPortuaria getTerminalOrigen() {
		return terminalOrigen;
	}

	public TerminalPortuaria getTerminalDestino() {
		return terminalDestino;
	}


	public Date getDuracion() {
		return duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
