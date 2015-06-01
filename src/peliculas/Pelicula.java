package peliculas;
import java.io.Serializable;
import java.util.Date;
/**
 * Contiene los elementos de una película
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
	 * Título de la película.
	 */
	private String titulo;
	
	/**
	 * Género de la película.
	 */
	private Genero genero;
	
	/**
	 * Formato de la película.
	 */
	private Formato formato;
	
	/**
	 * Fecha de estreno de la película.
	 */
	private Date fechaEstreno;
	
	/**
	 * Duración de la película.
	 */
	private String duracion;
	
	/**
	 * Sinopsis de la película.
	 */
	private String sinopsis;
	
	
	/**
	 * Constructor película
	 * @param titulo de la película.
	 * @param genero de la película.
	 * @param formato de la película.
	 * @param fechaEstreno de la película.
	 * @param duracion de la película.
	 * @param sinopsis de la película.
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
	 * Constructor película.
	 * @param titulo de la película.
	 */
	public Pelicula(String titulo){
		setTitulo(titulo);
	}
	
	
	/**
	 * Getter Título
	 * @return título de la película.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Setter Título
	 * @param titulo de la película
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Getter Género
	 * @return género de la película
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Setter Género
	 * @param genero de la película
	 */
	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Getter Formato
	 * @return formato de la película
	 */
	public Formato getFormato() {
		return formato;
	}

	/**
	 * Setter Formato
	 * @param formato de la película
	 */
	private void setFormato(Formato formato) {
		this.formato = formato;
	}

	/**
	 * Getter Fecha de Estreno
	 * @return fecha de estreno de la película
	 */
	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	/**
	 * Setter Fecha de Estreno
	 * @param fechaEstreno de estreno de la película
	 */
	private void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	/**
	 * Getter Duración
	 * @return duración de la película
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Setter duración
	 * @param duracion de la película
	 */
	private void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Getter Sinopsis
	 * @return sinopsis de la película
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * Setter Sinopsis
	 * @param sinopsis de la película
	 */
	private void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * hasCode de la clase Película
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * equals de la clase Película
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
