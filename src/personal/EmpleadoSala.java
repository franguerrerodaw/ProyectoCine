package personal;
import java.io.Serializable;
import java.util.Date;

import personal.Uniforme;
/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class EmpleadoSala extends Persona implements Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Puesto del empleado
	 */
	private Puesto puesto;

	/**
	 * Titulación del empleado de sala
	 */
	private String titulacion;
	
	/**
	 * Uniforme obligatorio del empleado de sala
	 */
	private Uniforme uniforme;
	
	/**
	 * Turno del empleado
	 */
	private Turno turno;

	/**
	 * Constructor clase hija empleado sala
	 * @param nombreYApellidos
	 * @param dni
	 * @param direccion
	 * @param fechaNacimiento
	 * @param telefono
	 * @param email
	 * @param puesto
	 * @param alta
	 * @param horasSemanales
	 * @param titulacion
	 * @param uniforme
	 * @throws NombreInvalidoException
	 * @throws DniInvalidoException
	 * @throws EmailInvalidoException
	 */
	public EmpleadoSala(String nombreYApellidos, int sueldo, String dni, String direccion, Date fechaNacimiento, String telefono, String email, Date alta, int horasSemanales, String titulacion, Uniforme uniforme) throws NombreInvalidoException, DniInvalidoException, EmailInvalidoException {
		super(nombreYApellidos, sueldo, dni, direccion, fechaNacimiento, telefono, email, alta, horasSemanales);
		setPuesto(puesto);
		this.titulacion = titulacion;
		this.uniforme = uniforme;
		setTurno(turno);
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
		this.puesto = Puesto.EMPLEADO_SALA;
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

	/**
	 * @return the uniforme
	 */
	public Uniforme getUniforme() {
		return uniforme;
	}

	/**
	 * @param uniforme the uniforme to set
	 */
	public void setUniforme(Uniforme uniforme) {
		this.uniforme = uniforme;
	}
	
	
	/**
	 * @return turno del empleado
	 */
	public Turno getTurno() {
		return turno;
	}

	/**
	 * @param turno del empleado
	 */
	public void setTurno(Turno turno) {
		this.turno = turno;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmpleadoSala: puesto=" + puesto + " turno=" + turno + "]";
	}
	
	

}
