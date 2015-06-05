package personal;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
/**
 * Clase padre Persona
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Persona implements Serializable, Salariable, Comparable<Persona> {

	/**
	 * Serial versión UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre y apellidos.
	 */
	protected String nombreYApellidos;
	
	/**
	 * Precio por hora para cada persona creada.
	 */
	protected int precioHora;

	/**
	 * Documento Nacional de Identidad.
	 */
	protected String dni;

	/**
	 * Dirección postal.
	 */
	protected String direccion;

	/**
	 * Fecha de nacimiento.
	 */
	protected Date fechaNacimiento;

	/**
	 * Teléfono de contacto.
	 */
	protected String telefono;

	/**
	 * Email de contacto.
	 */
	protected String email;

	/**
	 * Fecha de alta en la Seguridad Social.
	 */
	protected Date alta;

	/**
	 * Número de horas trabajadas.
	 */
	protected int horasSemanales;

	/**
	 * 
	 */
	private static final Pattern patternNombre = Pattern
			.compile("(?i)^[a-záéíóúñ ]+$");

	/**
	 * El DNI solo puede contener 8 dígitos, un guion y una letra.
	 */
	private static final Pattern patternDni = Pattern
			.compile("^(\\d{8})[-]([A-Z]{1})$");

	/**
	 * El email solo puede contener una palabra que comience por una letra
	 * seguido de más letras o números, un arroba, letras, un punto y más
	 * letras.
	 */
	private static final Pattern patternEmail = Pattern
			.compile("^([a-z]{1})[a-z0-9]+[@][a-z]+[.][a-z]+$");

	/**
	 * Constructor clase padre Persona.
	 * 
	 * @param id
	 * @param nombre
	 * @param dni
	 * @param direccion
	 * @param fechaNacimiento
	 * @param telefono
	 * @param email
	 * @param puesto
	 * @param alta
	 * @param horasSemanales
	 * @throws NombreInvalidoException
	 * @throws DniInvalidoException
	 * @throws EmailInvalidoException
	 */
	public Persona(String nombreYApellidos, int precioHora, String dni,
			String direccion, Date fechaNacimiento, String telefono,
			String email, Date alta, int horasSemanales)
			throws NombreInvalidoException, DniInvalidoException,
			EmailInvalidoException {
		setNombreYApellidos(nombreYApellidos);
		setDni(dni);
		setPrecioHora(precioHora);
		this.direccion = direccion;
		setFechaNacimiento(fechaNacimiento);
		setTelefono(telefono);
		setEmail(email);
		setAlta(alta);
		this.horasSemanales = horasSemanales;

	}

	/**
	 * Constructor clase padre Persona.
	 * 
	 * @param id
	 * @throws DniInvalidoException
	 */
	public Persona(String dni) throws DniInvalidoException {
		setDni(dni);
	}

	/**
	 * Setter sueldo
	 * 
	 * @param sueldo
	 */
	private void setPrecioHora(int precioHora) {
		this.precioHora = precioHora;
	}

	/**
	 * Getter sueldo
	 * 
	 * @return sueldo
	 */
	public int getPrecioHora() {
		return precioHora;
	}

	/**
	 * Setter Nombre y Apellidos
	 * 
	 * @param nombre
	 *            y apellidos de la persona
	 * @throws NombreInvalidoException
	 */
	private void setNombreYApellidos(String nombreYApellidos)
			throws NombreInvalidoException {
		if (nombreValido(nombreYApellidos))
			this.nombreYApellidos = nombreYApellidos;
		else
			throw new NombreInvalidoException(
					"El nombre introducido es incorrecto.");
	}

	/**
	 * Comprueba que el nombre los caracteres válidos en el patrón.
	 * 
	 * @param nombreYApellidos2
	 * @return nombre y apellidos de la persona
	 */
	private boolean nombreValido(String nombreYApellidos) {
		return patternNombre.matcher(nombreYApellidos).matches();
	}

	/**
	 * Getter Nombre y Apellidos
	 * 
	 * @return nombre y apellidos de la persona
	 */
	public String getNombreYApellidos() {
		return nombreYApellidos;
	}

	/**
	 * Setter DNI
	 * 
	 * @param dni
	 * @throws DniInvalidoException
	 */
	private void setDni(String dni) throws DniInvalidoException {
		if (dniValido(dni))
			this.dni = dni;
		else
			throw new DniInvalidoException("El DNI introducido es incorrecto.");
	}

	/**
	 * Comprueba que el DNI sea en minúscula, que contenga solo letras o
	 * números, que tenga un símbolo de arroba y un punto.
	 * 
	 * @param dni2
	 * @return dni de la persona
	 */
	public static boolean dniValido(String dni) {
		return patternDni.matcher(dni).matches();
	}

	/**
	 * Getter DNI
	 * 
	 * @return dni de la persona
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter Dirección
	 * 
	 * @return dirección de la persona
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Setter fecha de nacimiento
	 * 
	 * @param fechaNacimiento2
	 */
	public void setFechaNacimiento(Date fechaNacimiento2) {
		this.fechaNacimiento = fechaNacimiento2;
	}

	/**
	 * Getter fecha de nacimiento
	 * 
	 * @return
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Setter Teléfono
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Getter teléfono de la persona.
	 * 
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setter email de la persona
	 * 
	 * @param email
	 * @throws EmailInvalidoException
	 */
	public void setEmail(String email) throws EmailInvalidoException {
		if (emailValido(email))
			this.email = email;
		else
			throw new EmailInvalidoException(
					"El email introducido es incorrecto.");
	}

	/**
	 * Comprueba que el Email tenga 8 dígitos, un guion y una letra.
	 * 
	 * @param dni2
	 * @return dni de la persona
	 */
	public static boolean emailValido(String email) {
		return patternEmail.matcher(email).matches();
	}

	/***
	 * Getter email de la persona.
	 * 
	 * @return email de la persona.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter fecha de alta de la persona
	 * 
	 * @param alta
	 */
	public void setAlta(Date alta) {
		this.alta = alta;
	}

	/**
	 * Getter fecha de alta de la persona
	 * 
	 * @return fecha de alta de la persona
	 */
	public Date getAlta() {
		return alta;
	}

	/**
	 * Getter horas semanales de la persona.
	 * 
	 * @return
	 */
	public int getHorasSemanales() {
		return horasSemanales;
	}
	
	
	/**
	 * Calcula el sueldo mensual de la persona gracias a las horas semanales que trabaja y el precio por hora.
	 * @return sueldo de la persona.
	 */
	@Override
	public int salario() {
		return horasSemanales * precioHora * 4;
	}

	/**
	 * Calcula la bonificación por años trabajados
	 */
	@Override
	public int bonificacion() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		int anioActual = calendar.get(Calendar.YEAR);
		int anioAlta = Integer.parseInt(dateFormat.format(getAlta()));
		int antiguedad = anioActual - anioAlta;
		
		if (antiguedad > -1 && antiguedad < 5)
			return 0;
		else if (antiguedad > 4 && antiguedad < 10)
			return (int) (salario() * 0.33);
		else if (antiguedad > 10)
			return (int) (salario() * 0.66);
		return 0;
	}
	
	
	/**
	 * Compara el salario de dos empleados
	 * @return negativo si es menor, positivo si es mayor o cero si es igual
	 */
	@Override
	public int compareTo(Persona persona) {
		 if (this.salario() < persona.salario()) {
			 return -1;
		 }
		 else if (this.salario() > persona.salario()) {
			 return 1;
		 }
		 else if (this.salario() == persona.salario()) {
			 return 0;
		 }
		 return 0;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [nombreYApellidos=" + nombreYApellidos
				+ ", precioHora=" + precioHora + ", dni=" + dni
				+ ", direccion=" + direccion + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + ", email="
				+ email + ", alta=" + alta + ", horasSemanales="
				+ horasSemanales + "]";
	}

	
	
	

}
