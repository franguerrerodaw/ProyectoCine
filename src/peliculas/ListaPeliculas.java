package peliculas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import utiles.Gestion;
/**
 * Permite añadir, eliminar y buscar películas.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class ListaPeliculas implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Colección de Películas
	 */
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
	/**
	 * Agrega una película al ArrayList
	 * @param titulo
	 * @param genero
	 * @param formato
	 * @param anio
	 * @param duracion
	 * @param sinopsis
	 * @return añade la película al ArrayList
	 * @throws PeliculaYaExisteException
	 */
	public boolean agregar(String titulo, Genero genero, Formato formato, Date fechaEstreno, String duracion, String sinopsis) throws PeliculaYaExisteException{
		Pelicula pelicula = new Pelicula(titulo, genero, formato, fechaEstreno, duracion, sinopsis);
		if (listaPeliculas.contains(pelicula))
			throw new PeliculaYaExisteException("El coche ya existe");
		return listaPeliculas.add(pelicula) && Gestion.setModificado(true);
	}
	
	
	/**
	 * Elimina una película al ArrayList
	 * @param titulo
	 * @return elimina la película del ArrayList
	 * @throws PeliculaNoExisteException
	 */
	public boolean eliminar(String titulo) throws PeliculaNoExisteException{
		Pelicula pelicula = new Pelicula(titulo);
		if (listaPeliculas.contains(pelicula))
			return listaPeliculas.remove(pelicula) && Gestion.setModificado(true);
		else
			throw new PeliculaNoExisteException("La película no existe.");
	}
	
	
	/**
	 * Busca la película en el ArrayList a través del título, se utiliza para mostrar una película antes de eliminarla.
	 * @param titulo
	 * @return película almacenada en el ArrayList
	 * @throws PeliculaNoExisteException
	 */
	public Pelicula get(String titulo) throws PeliculaNoExisteException {
		Pelicula pelicula = new Pelicula(titulo);
		int index = listaPeliculas.indexOf(pelicula);
		if (index != -1) {
			return listaPeliculas.get(index);
		}
		throw new PeliculaNoExisteException("La película no existe.");
	}
	
	
	/**
	 * Comprueba si hay más elementos antes o después del ArrayList, se utiliza en mostrar cartelera
	 * @param index
	 * @return película almacenada en el ArrayList
	 */
	public Pelicula get(int index) {
		if(listaPeliculas.isEmpty())
			return null;
		if(index < 0 | index > listaPeliculas.size()-1)
			return null;
		return listaPeliculas.get(index);
	}
	
	
	/**
	 * Tamaño del ArrayList
	 * @return elementos del ArrayList
	 */
	public int size() {
		return listaPeliculas.size();
	}
	

}
