package buscadorRutas;

import empresa_naviera.BuqueViaje;

public class FiltroOr implements FiltroRuta{
	
	private FiltroRuta primerFiltro;
	private FiltroRuta segundoFiltro;

	public FiltroOr(FiltroPuertoDestino primerFiltro, FiltroPuertoDestino segundoFiltro) {
		  this.primerFiltro = primerFiltro;
		  this.segundoFiltro = segundoFiltro;
		
	}

	@Override
	public Boolean cumple(BuqueViaje viaje) {
		
		return this.primerFiltro.cumple(viaje) || this.segundoFiltro.cumple(viaje);
	}

}
