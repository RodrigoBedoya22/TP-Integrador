package nuevo_enfoque_viajes;

import terminal_portuaria.TerminalPortuaria;



public class CopiaTramo{
	
	CopiaTerminalPortuaria terminalOrigen;
	CopiaTerminalPortuaria terminalDestino;
	Double precio; 
	
	public CopiaTramo(CopiaTerminalPortuaria terminalOrigen, CopiaTerminalPortuaria terminalDestino, Double precio) throws Exception{
		
		this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.setPrecio(precio);
	}
	
	public CopiaTerminalPortuaria getTerminalOrigen() {
		return terminalOrigen;
	}

	public CopiaTerminalPortuaria getTerminalDestino() {
		return terminalDestino;
	}
	
	/**
	 * Retorna la duracion del tramo desde la terminal origen hacia la terminal destino, basandose en la distancia entre ellas.
	 * @return Double - La duracion del viaje entre la terminal origen y destino en dias.
	 * NOTA: Por convencion, esta distancia es en dias.
	 */
	public double getDuracion() {
		
		return this.terminalOrigen.distanciaHastaTerminal(this.terminalDestino);
	}

	public Double getPrecio() {
		return precio;
	}
	
	/**
	 * Setea el precio de un tramo en un monto dado, el monto debe ser mayor o igual a cero.
	 * @param precio - El nuevo precio del tramo
	 * @throws Exception - Si el precio dado es negativo o cero, genera una excepcion.
	 */
	public void setPrecio(Double precio) throws Exception{
		if (precio <= 0) {
			throw new IllegalArgumentException("El precio debe ser mayor a cero");
		}
		else {
			this.precio = precio;
		}
	}

}
