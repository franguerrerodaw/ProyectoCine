package peliculas;
/**
 * Formato en el que son reproducidas las pel�culas.
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
	 * Pel�culas en alta definici�n
	 */
	HD,
	
	/**
	 * Pel�culas en 3D y alta definici�n
	 */
	HD_3D;
	
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n Formato.
	 */
	private static final Formato[] VALUES = Formato.values();
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n Formato.
	 * @return array con los valores de la enumeraci�n formato.
	 */
	public static Formato[] getValues() {
		return VALUES;
	}

}
