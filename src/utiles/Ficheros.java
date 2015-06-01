package utiles;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import peliculas.ListaPeliculas;
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
	private static File file = new File("sin_titulo.obj");
	
	/**
	 * Filechooser Ficheros
	 */
	private static JFileChooser fileChooser = new JFileChooser();
	
	/**
	 * JFrame Ficheros
	 */
	private static JFrame frame = new JFrame();
	
	/**
	 * Filtro para la extensi�n .obj
	 */
	private static FileNameExtensionFilter filtro = new FileNameExtensionFilter("objeto.obj", "obj");
	
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
		new File("sin_titulo.obj");
	}

	/**
	 * Abre un fichero desde una ubicaci�n
	 * @param cartelera
	 * @return contenido del fichero
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static ListaPeliculas abrir(ListaPeliculas cartelera) throws ClassNotFoundException, IOException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) { //si la opci�n elegida es aceptar abrimos el archivo
			file = fileChooser.getSelectedFile();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				cartelera = (ListaPeliculas) in.readObject();
			}
		}
		return cartelera;
	}
	
	/**
	 * Guarda la informaci�n en un fichero que ya existe
	 * @param cartelera
	 * @throws IOException
	 */
	public static void guardar(ListaPeliculas cartelera) throws IOException {
		if (file.getName() == "sin_titulo.obj")
			guardarComo(cartelera);
		else {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file+".obj"))) {
				out.writeObject(cartelera);
			}
		}
	}
	
	/**
	 * Guarda la informaci�n en un fichero que no se ha creado aun.
	 * @param cartelera
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void guardarComo(ListaPeliculas cartelera) throws FileNotFoundException, IOException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Ficheros.file+".obj"))) {
				out.writeObject(cartelera);
			}
		}
	}
	
}