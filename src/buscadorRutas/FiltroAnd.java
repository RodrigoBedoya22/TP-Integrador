package buscadorRutas;

import empresa_naviera.BuqueViaje;

public class FiltroAnd implements FiltroRuta{
	
	private FiltroRuta primerFiltro;
	private FiltroRuta segundoFiltro;

	public FiltroAnd(FiltroPuertoDestino primerFiltro, FiltroPuertoDestino segundoFiltro) {
		  this.primerFiltro = primerFiltro;
		  this.segundoFiltro = segundoFiltro;
		
	}

	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		return this.primerFiltro.cumple(viaje) && this.segundoFiltro.cumple(viaje);
	}
	

}
