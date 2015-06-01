package peliculas;
/**
 * Formato en el que son reproducidas las películas.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Formato {
	
	/**
	 * Selecciona un elemento.
	 */
	SELECCIONA,
	
	/**
	 * Películas en alta definición
	 */
	HD,
	
	/**
	 * Películas en 3D y alta definición
	 */
	HD_3D;
	
	
	/**
	 * Almacena en un array los elementos de la enumeración Formato.
	 */
	private static final Formato[] VALUES = Formato.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Formato.
	 * @return array con los valores de la enumeración formato.
	 */
	public static Formato[] getValues() {
		return VALUES;
	}

}
