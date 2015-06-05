package utiles;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import peliculas.ListaPeliculas;
import personal.ListaPersonas;
/**
* Permite guardar, abrir, y crear un nuevo fichero.
* @author Francisco Javier Guerrero Molina
* @version 1.0
* 
*/
public class Ficheros implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fichero nuevo
	 */
	private static File file = new File("sin_titulo");
	
	/**
	 * Filechooser Ficheros
	 */
	private static JFileChooser fileChooser = new JFileChooser();
	
	/**
	 * JFrame Ficheros
	 */
	private static JFrame frame = new JFrame();
	
	/**
	 * Filtro para la extensión .cin
	 */
	private static FileNameExtensionFilter filtro = new FileNameExtensionFilter("objeto.cin", "cin");
	
	/**
	 * Objeto de la clase ListaPeliculas
	 */
	private static ListaPeliculas cartelera;
	
	
	/**
	 * Objeto de la clase ListaPersonas
	 */
	private static ListaPersonas empleados;
	
	
	/**
	 * Getter fichero
	 * @return fichero
	 */
	public static File getFile() {
		return file;
	}
	
	/**
	 * Crea un nuevo fichero
	 */
	public static void nuevo(){
		new File("sin_titulo");
	}

	/**
	 * Abre un fichero desde una ubicación
	 * @param cartelera
	 * @return 
	 * @return contenido del fichero
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void abrir() throws ClassNotFoundException, IOException {
		filtro();
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) { //si la opción elegida es aceptar abrimos el archivo
			file = fileChooser.getSelectedFile();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				cartelera = (ListaPeliculas) in.readObject();
				empleados = (ListaPersonas) in.readObject();
			}
			leerCartelera();
			leerEmpleados();
		}
	}


	/**
	 * Envía las películas a su correspondiente instancia.
	 * @param cartelera
	 * @return películas almacenadas en el fichero
	 */
	public static ListaPeliculas leerCartelera(){
		return cartelera;
	}
	
	
	/**
	 * Envía los empleados a su correspondiente instancia.
	 * @param empleados
	 * @return empleados almacenados en el fichero
	 */
	public static ListaPersonas leerEmpleados(){
		return empleados;
	}
	
	
	/**
	 * Guarda la información en un fichero que ya existe
	 * @param cartelera
	 * @throws IOException
	 */
	public static void guardar(ListaPeliculas cartelera, ListaPersonas empleados) throws IOException {
		if (file.getName() == "sin_titulo")
			guardarComo(cartelera, empleados);
		else {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extension(Ficheros.file)))) {
				out.writeObject(cartelera);
				out.writeObject(empleados);
			}
		}
	}
	
	/**
	 * Guarda la información en un fichero que no se ha creado aun.
	 * @param cartelera
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void guardarComo(ListaPeliculas cartelera, ListaPersonas empleados) throws FileNotFoundException, IOException {
		filtro();
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extension(Ficheros.file)))) {
				out.writeObject(cartelera);
				out.writeObject(empleados);
			}
		}
	}
	
	
	/**
	 * Establece el filtro para mostrar solo los archivos terminados con extensión .obj
	 */
	private static void filtro(){
		fileChooser.setAcceptAllFileFilterUsed(false); //elimina el filtro de todos los archivos
		fileChooser.addChoosableFileFilter(filtro); //establece solo el filtro para los archivos .obj
	}
	
	
	/**
	 * Añade al fichero la extensión .cin
	 * @param file
	 * @return fichero con extension .cin
	 */
	private static File extension(File file) {
        String path = file.getPath();
        if (!path.endsWith(".cin"))
            return new File(path + ".cin");
        return file;
    }
	
	
}