package personal;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Turno {
	
	/**
	 * Elemento sin turno.
	 */
	SIN_TURNO,
	
	/**
	 * Elemento turno diurno.
	 */
	TURNO_DIURNO,
	
	/**
	 * Elemento turno de tarde.
	 */
	TURNO_TARDE,
	
	/**
	 * Elemento turno nocturno.
	 */
	TURNO_NOCTURNO;
	

	/**
	 * Almacena en un array los elementos de la enumeración Turno.
	 */
	private static final Turno[] VALUES = Turno.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Turno.
	 * @return array con los valores de la enumeración turno.
	 */
	public static Turno[] getValues() {
		return VALUES;
	}
}
