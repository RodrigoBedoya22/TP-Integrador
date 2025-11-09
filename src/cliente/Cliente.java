package cliente;

public class Cliente {
	
	String nombre;
	int dni;
	String email;
	
	public Cliente(String nombre, int dni, String email) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDni() {
		return dni;
	}

}
