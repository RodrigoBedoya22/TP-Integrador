package reportes;

public interface Reportable {
	/**
	 * Indica al visitante dado que puede acceder a su información.
	 * @param visitor - El visitante al cual se le informará el acceso a los datos del reportable.
	*/
	public void aceptar(ReporteVisitor reporte);
}
