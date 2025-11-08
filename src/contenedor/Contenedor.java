package contenedor;

public abstract class Contenedor {
	
	//falta agregar la carga y el b/l
	
	private String idString;
	private Integer idNumero;
	private Double ancho;
	private Double largo;
	private Double alto;
	private Double peso;
	
	public Contenedor(String idString, Integer idNumero, Double ancho, Double largo, Double alto, Double peso) {
		
		this.idString = idString;
		this.idNumero = idNumero;
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.peso = peso;
		
	}

	public Double getAncho() {
		return ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public Double getAlto() {
		return alto;
	}

	public Double getPeso() {
		return peso;
	}

	public String getIdentificador() {
		
		String idNumerico = String.valueOf(idNumero);
		return idString +  idNumerico;
		
	}
	
}
