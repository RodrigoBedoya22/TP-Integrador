package coordenada;


public class Coordenada {
	
	double coordenadaX;
	double coordenadaY;
	 
	public Coordenada(double coordenadaX, double  coordenadaY){
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		
	}
	
	public double getX() {
		
		return coordenadaX;
	}
	 
	public double getY() {
			
		return coordenadaY;
	}
	/**
	 * Retorna la distancia hacia otra coordenada en un plano bidimensional, segun los puntos de ambas coordenadas.
	 * @param coordenada - La coordenada hacia la cual se calculará la distancia
	 * @return Double - La distancia hacia la otra coordenada, redondeada a dos decimales
	 */
	public double distanciaHaciaCoordenada(Coordenada coordenada) {
		//la formula utilizada es la de distancia entre dos puntos:
		//     √ [ (x2 – x1)² + (y2 – y1)²] 
		
		double calculoX = Math.pow( (this.getX() - coordenada.getX()), 2);
		double calculoY = Math.pow( (this.getY() - coordenada.getY()), 2);
		double distancia= Math.sqrt(calculoX + calculoY);
		
		//se redondea a dos decimales
		return Math.round(distancia * 100.0)/100.0;
	}

}

