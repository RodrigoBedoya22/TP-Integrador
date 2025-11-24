package buscadorRutas;

import empresa_naviera.BuqueViaje;

public class FiltroOr implements FiltroRuta{
	
	private FiltroRuta primerFiltro;
	private FiltroRuta segundoFiltro;

	public FiltroOr(FiltroRuta primerFiltro, FiltroRuta segundoFiltro) {
		
		  this.primerFiltro = primerFiltro;
		  this.segundoFiltro = segundoFiltro;
		
	}

	/**
	 * Indica si un viaje dado cumple con al menos uno de los dos filtros concretos. En caso de que no cumpla con ninguno retorna false
	 */
	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		return this.primerFiltro.cumple(viaje) || this.segundoFiltro.cumple(viaje);
	}

}
