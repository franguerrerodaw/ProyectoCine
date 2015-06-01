package personal;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Uniforme {
	
	/**
	 * Elemento camisa y pantal�n.
	 */
	CAMISA_Y_PANTALON,
	
	/**
	 * Elemento camisa y falda.
	 */
	CAMISA_Y_FALDA;
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n Uniforme.
	 */
	private static final Uniforme[] VALUES = Uniforme.values();
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n Uniforme.
	 * @return array con los valores de la enumeraci�n uniforme.
	 */
	public static Uniforme[] getValues() {
		return VALUES;
	}

}
