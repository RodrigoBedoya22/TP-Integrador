package buscadorRutas;

import empresa_naviera.BuqueViaje;

public class FiltroAnd implements FiltroRuta{
	
	private FiltroRuta primerFiltro;
	private FiltroRuta segundoFiltro;

	public FiltroAnd(FiltroRuta primerFiltro, FiltroRuta segundoFiltro) {
		  this.primerFiltro = primerFiltro;
		  this.segundoFiltro = segundoFiltro;
		
	}

	/**
	 * Indica si un viaje dado cumple con ambos filtros concretos.
	 */
	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		return this.primerFiltro.cumple(viaje) && this.segundoFiltro.cumple(viaje);
	}
	

}
