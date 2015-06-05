package personal;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Limpiador extends Persona implements Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Puesto del empleado
	 */
	private Puesto puesto;
	
	/**
	 * Espacio de limpieza asignado
	 */
	private Zona zona;

	/**
	 * Constructor clase hija limpiador
	 * @param nombreYApellidos
	 * @param dni
	 * @param direccion
	 * @param fechaNacimiento
	 * @param telefono
	 * @param email
	 * @param puesto
	 * @param alta
	 * @param horasSemanales
	 * @param herramientas
	 * @param zona
	 * @throws NombreInvalidoException
	 * @throws DniInvalidoException
	 * @throws EmailInvalidoException
	 */
	public Limpiador(String nombreYApellidos, int sueldo, String dni, String direccion, Date fechaNacimiento, String telefono, String email, Date alta, int horasSemanales) throws NombreInvalidoException, DniInvalidoException, EmailInvalidoException {
		super(nombreYApellidos, sueldo, dni, direccion, fechaNacimiento, telefono, email, alta, horasSemanales);
		setPuesto(puesto);
		setZona(zona);
	}
	
	
	/**
	 * @return the puesto
	 */
	public Puesto getPuesto() {
		return puesto;
	}


	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(Puesto puesto) {
		this.puesto = Puesto.LIMPIEZA;
	}
	
	

	/**
	 * @return the zona
	 */
	public Zona getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(Zona zona) {
		this.zona = zona;
	}

}