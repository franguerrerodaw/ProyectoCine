package peliculas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import utiles.Gestion;
/**
 * Permite a�adir, eliminar y buscar pel�culas.
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
	 * Colecci�n de Pel�culas
	 */
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
	/**
	 * Agrega una pel�cula al ArrayList
	 * @param titulo
	 * @param genero
	 * @param formato
	 * @param anio
	 * @param duracion
	 * @param sinopsis
	 * @return a�ade la pel�cula al ArrayList
	 * @throws PeliculaYaExisteException
	 */
	public boolean agregar(String titulo, Genero genero, Formato formato, Date fechaEstreno, String duracion, String sinopsis) throws PeliculaYaExisteException{
		Pelicula pelicula = new Pelicula(titulo, genero, formato, fechaEstreno, duracion, sinopsis);
		if (listaPeliculas.contains(pelicula))
			throw new PeliculaYaExisteException("El coche ya existe");
		return listaPeliculas.add(pelicula) && Gestion.setModificado(true);
	}
	
	
	/**
	 * Elimina una pel�cula al ArrayList
	 * @param titulo
	 * @return elimina la pel�cula del ArrayList
	 * @throws PeliculaNoExisteException
	 */
	public boolean eliminar(String titulo) throws PeliculaNoExisteException{
		Pelicula pelicula = new Pelicula(titulo);
		if (listaPeliculas.contains(pelicula))
			return listaPeliculas.remove(pelicula) && Gestion.setModificado(true);
		else
			throw new PeliculaNoExisteException("La pel�cula no existe.");
	}
	
	
	/**
	 * Busca la pel�cula en el ArrayList a trav�s del t�tulo, se utiliza para mostrar una pel�cula antes de eliminarla.
	 * @param titulo
	 * @return pel�cula almacenada en el ArrayList
	 * @throws PeliculaNoExisteException
	 */
	public Pelicula get(String titulo) throws PeliculaNoExisteException {
		Pelicula pelicula = new Pelicula(titulo);
		int index = listaPeliculas.indexOf(pelicula);
		if (index != -1) {
			return listaPeliculas.get(index);
		}
		throw new PeliculaNoExisteException("La pel�cula no existe.");
	}
	
	
	/**
	 * Comprueba si hay m�s elementos antes o despu�s del ArrayList, se utiliza en mostrar cartelera
	 * @param index
	 * @return pel�cula almacenada en el ArrayList
	 */
	public Pelicula get(int index) {
		if(listaPeliculas.isEmpty())
			return null;
		if(index < 0 | index > listaPeliculas.size()-1)
			return null;
		return listaPeliculas.get(index);
	}
	
	
	/**
	 * Tama�o del ArrayList
	 * @return elementos del ArrayList
	 */
	public int size() {
		return listaPeliculas.size();
	}
	

}
