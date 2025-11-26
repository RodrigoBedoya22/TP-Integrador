package reportes;

import java.time.LocalDate;

import buque.Buque;
import orden.Orden;
import terminal_portuaria.TerminalPortuaria;

public class ReporteAduana implements ReporteVisitor{
	
	String datos;
	public ReporteAduana() {
		
	}
	/**
	 * En este caso no es necesario
	 */
	@Override
	public void visitarTerminal(TerminalPortuaria terminal) {
		
	}

	/**
	 * Visita a un buque dado para obtener sus datos y armar un reporte
	 */
	@Override
	public void visitarBuque(Buque buque) {
		
		this.armarReporte(buque);
	}
	
	/**
	 * Arma el reporte utilizando los datos del buque dado
	 * @param buque - El buque del cual se consultarán sus datos
	 */
	private void armarReporte(Buque buque) {

		String nombreBuque= buque.getNombre();
		LocalDate fechaLLegada = buque.getViaje().getFechaDeLlegadaA(
							buque.getViaje().getTramoActual().getTerminalDestino().getNombre()
							);
		LocalDate fechaSalida = fechaLLegada;
		
		String listaDeContenedores = "Lista de contenedores a bordo: ";
		for(Orden orden : buque.getOrdenes()) {
			listaDeContenedores += 
					System.lineSeparator() +"<Contenedor>" +
					System.lineSeparator() + "<idContenedor>" + orden.getContenedor().getIdentificador() + "</idContenedor>" +
					System.lineSeparator() + "<tipoContenedor>" + orden.getContenedor().getTipo() + "</tipoContenedor>" +
					System.lineSeparator() + "</Contenedor>";
		}
		
		String informeCompleto = 
				"<html>" + System.lineSeparator() +
				"<head>" + System.lineSeparator() +
				"</head>" + System.lineSeparator() +
				"<body>" + System.lineSeparator() +
				"<h1>Reporte aduana</h1>" + System.lineSeparator() +
				"<nombreBuque>" + nombreBuque + "</nombreBuque>" + System.lineSeparator() +
				"<fechaLLegada>" + fechaLLegada + "</fechaLLegada>" + System.lineSeparator() +
				"<fechaSalida>" + fechaSalida + "</fechaSalida>" + System.lineSeparator() +
				"<list>"  + System.lineSeparator() +  listaDeContenedores  + System.lineSeparator() + "</list>" + System.lineSeparator() +
				"</body>"+ System.lineSeparator() +
				"</html>" + System.lineSeparator();
		this.setDatos(informeCompleto);
		
	}
	
	public void setDatos(String datos) {
		this.datos= datos;
		
	}
	/**
	 * Saca a consola el informe construido
	 * @param datos - Los datos del informe construido
	 */
	public void print() {
		System.out.println(this.datos);
	}

}
