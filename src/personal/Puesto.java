package personal;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Puesto {
	
	/**
	 * Elemento selecciona una opción.
	 */
	SELECCIONA,
	
	/**
	 * Elemento director del cine.
	 */
	DIRECTOR,
	
	/**
	 * Elemento empleado de sala del cine.
	 */
	EMPLEADO_SALA,
	
	/**
	 * Elemento empleado de limpieza.
	 */
	LIMPIEZA;
	 
	/**
	 * Almacena en un array los elementos de la enumeración Puesto.
	 */
	private static final Puesto[] VALUES = Puesto.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Puesto.
	 * @return array con los valores de la enumeración puesto.
	 */
	public static Puesto[] getValues() {
		return VALUES;
	}
	

}
