package peliculas;
import java.io.Serializable;
import java.util.Date;
/**
 * Contiene los elementos de una pel�cula
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Pelicula implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * T�tulo de la pel�cula.
	 */
	private String titulo;
	
	/**
	 * G�nero de la pel�cula.
	 */
	private Genero genero;
	
	/**
	 * Formato de la pel�cula.
	 */
	private Formato formato;
	
	/**
	 * Fecha de estreno de la pel�cula.
	 */
	private Date fechaEstreno;
	
	/**
	 * Duraci�n de la pel�cula.
	 */
	private String duracion;
	
	/**
	 * Sinopsis de la pel�cula.
	 */
	private String sinopsis;
	
	
	/**
	 * Constructor pel�cula
	 * @param titulo de la pel�cula.
	 * @param genero de la pel�cula.
	 * @param formato de la pel�cula.
	 * @param fechaEstreno de la pel�cula.
	 * @param duracion de la pel�cula.
	 * @param sinopsis de la pel�cula.
	 */
	public Pelicula(String titulo, Genero genero, Formato formato, Date fechaEstreno, String duracion, String sinopsis){
		setTitulo(titulo);
		setGenero(genero);
		setFormato(formato);
		setFechaEstreno(fechaEstreno);
		setDuracion(duracion);
		setSinopsis(sinopsis);
	}
	
	
	/**
	 * Constructor pel�cula.
	 * @param titulo de la pel�cula.
	 */
	public Pelicula(String titulo){
		setTitulo(titulo);
	}
	
	
	/**
	 * Getter T�tulo
	 * @return t�tulo de la pel�cula.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Setter T�tulo
	 * @param titulo de la pel�cula
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Getter G�nero
	 * @return g�nero de la pel�cula
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Setter G�nero
	 * @param genero de la pel�cula
	 */
	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Getter Formato
	 * @return formato de la pel�cula
	 */
	public Formato getFormato() {
		return formato;
	}

	/**
	 * Setter Formato
	 * @param formato de la pel�cula
	 */
	private void setFormato(Formato formato) {
		this.formato = formato;
	}

	/**
	 * Getter Fecha de Estreno
	 * @return fecha de estreno de la pel�cula
	 */
	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	/**
	 * Setter Fecha de Estreno
	 * @param fechaEstreno de estreno de la pel�cula
	 */
	private void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	/**
	 * Getter Duraci�n
	 * @return duraci�n de la pel�cula
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Setter duraci�n
	 * @param duracion de la pel�cula
	 */
	private void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Getter Sinopsis
	 * @return sinopsis de la pel�cula
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * Setter Sinopsis
	 * @param sinopsis de la pel�cula
	 */
	private void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * hasCode de la clase Pel�cula
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * equals de la clase Pel�cula
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	

}
