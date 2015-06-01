package peliculas;
/**
 * Género de la película
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
	 * Película de acción
	 */
	ACCION,
	
	/**
	 * Película de animación
	 */
	ANIMACION,
	
	/**
	 * Película de aventura
	 */
	AVENTURA,
	
	/**
	 * Película de ciencia ficción
	 */
	CIENCIA_FICCION,
	
	/**
	 * Película de comedia
	 */
	COMEDIA,
	
	/**
	 * Película de drama
	 */
	DRAMA,
	
	/**
	 * Película de suspense
	 */
	SUSPENSE,
	
	/**
	 * Película de terror
	 */
	TERROR;
	
	
	/**
	 * Almacena en un array los elementos de la enumeración Género.
	 */
	private static final Genero[] VALUES = Genero.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Género.
	 * @return array con los valores de la enumeración género.
	 */
	public static Genero[] getValues() {
		return VALUES;
	}

}
