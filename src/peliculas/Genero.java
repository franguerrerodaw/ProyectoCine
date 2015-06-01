package peliculas;
/**
 * G�nero de la pel�cula
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public enum Genero {
	
	/**
	 * Selecciona un elemento.
	 */
	SELECCIONA,
	
	/**
	 * Pel�cula de acci�n
	 */
	ACCION,
	
	/**
	 * Pel�cula de animaci�n
	 */
	ANIMACION,
	
	/**
	 * Pel�cula de aventura
	 */
	AVENTURA,
	
	/**
	 * Pel�cula de ciencia ficci�n
	 */
	CIENCIA_FICCION,
	
	/**
	 * Pel�cula de comedia
	 */
	COMEDIA,
	
	/**
	 * Pel�cula de drama
	 */
	DRAMA,
	
	/**
	 * Pel�cula de suspense
	 */
	SUSPENSE,
	
	/**
	 * Pel�cula de terror
	 */
	TERROR;
	
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n G�nero.
	 */
	private static final Genero[] VALUES = Genero.values();
	
	/**
	 * Almacena en un array los elementos de la enumeraci�n G�nero.
	 * @return array con los valores de la enumeraci�n g�nero.
	 */
	public static Genero[] getValues() {
		return VALUES;
	}

}
