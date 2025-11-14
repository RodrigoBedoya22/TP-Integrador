package bl;

import cliente.Cliente;

public interface Bl {
	
	
	public String getTipoDeProducto();

	public abstract double getPeso();

	public Cliente getPropietario();
}
