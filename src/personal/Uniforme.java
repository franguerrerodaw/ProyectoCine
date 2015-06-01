package personal;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Uniforme {
	
	/**
	 * Elemento camisa y pantalón.
	 */
	CAMISA_Y_PANTALON,
	
	/**
	 * Elemento camisa y falda.
	 */
	CAMISA_Y_FALDA;
	
	/**
	 * Almacena en un array los elementos de la enumeración Uniforme.
	 */
	private static final Uniforme[] VALUES = Uniforme.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Uniforme.
	 * @return array con los valores de la enumeración uniforme.
	 */
	public static Uniforme[] getValues() {
		return VALUES;
	}

}
