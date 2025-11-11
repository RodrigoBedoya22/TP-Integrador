package empresa_naviera;

import java.util.Date;

import terminal_portuaria.TerminalPortuaria;



public class Tramo{
	
	TerminalPortuaria terminalOrigen;
	TerminalPortuaria terminalDestino;
	Double precio; 
	
	public Tramo(TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino, Double precio) throws Exception{
		
		this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.setPrecio(precio);
	}
	
	public TerminalPortuaria getTerminalOrigen() {
		return terminalOrigen;
	}

	public TerminalPortuaria getTerminalDestino() {
		return terminalDestino;
	}
	
	/**
	 * Retorna la duracion del tramo desde la terminal origen hacia la terminal destino, basandose en la distancia entre ellas.
	 * @return Double - La distancia entre la terminal origen y destino.
	 * NOTA: Por convencion, esta distancia es en dias.
	 */
	public double getDuracion() {
		
		return this.terminalOrigen.distanciaHastaTerminal(this.terminalDestino);
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) throws Exception{
		if (precio <= 0) {
			throw new IllegalArgumentException("El precio debe ser mayor a cero");
		}
		else {
			this.precio = precio;
		}
	}

}
