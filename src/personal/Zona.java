package personal;

public enum Zona {
	
	/**
	 * Selecciona un elemento de la enumeración
	 */
	SIN_ZONA,
	
	/**
	 * Elemento local recibidor del cine
	 */
	LOCAL_RECIBIDOR,
	
	/**
	 * Elemento aseos del cine.
	 */
	ASEOS,
	
	/**
	 * Elemento sala 1 del cine.
	 */
	SALA1,
	
	/**
	 * Elemento sala 2 del cine.
	 */
	SALA2,
	
	/**
	 * Elemento sala 3 del cine.
	 */
	SALA3;
	
	/**
	 * Almacena en un array los elementos de la enumeración Zona.
	 */
	private static final Zona[] VALUES = Zona.values();
	
	/**
	 * Almacena en un array los elementos de la enumeración Zona.
	 * @return array con los valores de la enumeración zona.
	 */
	public static Zona[] getValues() {
		return VALUES;
	}

}
