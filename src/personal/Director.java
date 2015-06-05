package personal;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Director extends Persona implements Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Puesto del empleado.
	 */
	private Puesto puesto;
	
	/**
	 * Títulos académicos acreditativos.
	 */
	private String titulacion;

	
	/**
	 * Constructor clase hija director
	 * @param titulacion
	 * @throws EmailInvalidoException 
	 * @throws DniInvalidoException 
	 * @throws NombreInvalidoException 
	 */
	public Director(String nombreYApellidos, int sueldo, String dni, String direccion, Date fechaNacimiento, String telefono, String email, Date alta, int horasSemanales, String titulacion) throws NombreInvalidoException, DniInvalidoException, EmailInvalidoException {
		super(nombreYApellidos, sueldo, dni, direccion, fechaNacimiento, telefono, email, alta, horasSemanales);
		setPuesto(puesto);
		this.titulacion = titulacion;
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
		this.puesto = Puesto.DIRECTOR;
	}


	/**
	 * @return the titulacion
	 */
	public String getTitulacion() {
		return titulacion;
	}

	/**
	 * @param titulacion the titulacion to set
	 */
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}



}