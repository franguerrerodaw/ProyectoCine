package utiles;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import peliculas.ListaPeliculas;
import personal.ListaPersonas;

/**
 * Gestiona abrir, guardar y crear nuevos archivos.
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Gestion {
	
	/**
	 * Instancia de la clase ListaPersonas
	 */
	public static ListaPersonas empleados = new ListaPersonas();
	
	/**
	 * Instancia de la clase ListaPeliculas
	 */
	public static ListaPeliculas cartelera = new ListaPeliculas();

	/**
	 * almacena si el ArrayList ha sido modificado a�adiendo o eliminando
	 * elementos.
	 */
	protected static boolean modificado = false;

	/**
	 * almacena si el ArrayList ha sido guardado o no para cambiar el t�tulo en
	 * barra de t�tulo.
	 */
	protected static boolean guardado = false;

	
	
	/**
	 * Modifica el valor de la variable modificado
	 * @param valor
	 * @return verdadero si se ha modificado el ArrayList.
	 */
	public static boolean setModificado(boolean valor) {
		modificado = valor;
		return true;
	}

	/**
	 * Getter Modificado
	 * @return verdadero si se ha modificado el ArrayList.
	 */
	public static boolean getModificado() {
		return modificado;
	}

	/**
	 * Modifica el t�tulo de la barra seg�n el fichero existente.
	 */
	public static void getTitle(Frame frame) {
		if (Gestion.getGuardado() == false)
			frame.setTitle("Administraci�n Cine  -  Sin_T�tulo");
		else
			frame.setTitle("Administraci�n Cine  -  " + Ficheros.getFile());

	}

	/**
	 * Modifica el estado de la variable guardado. Se utiliza para cambiar el
	 * t�tulo en la barra de t�tulo
	 * @param valor
	 */
	public static void setGuardado(boolean valor) {
		guardado = valor;
	}

	/**
	 * Getter Guardado.
	 * @return verdadero si se ha guardado el fichero.
	 */
	public static boolean getGuardado() {
		return guardado;
	}

	/** ********* GESTI�N DE FICHEROS ************* */

	/**
	 * Gestiona la creaci�n de un nuevo fichero.
	 */
	public static void nuevo(Frame frame) {
		if (Gestion.getModificado()) { // true == ArrayList ha sido modificado
			int n = JOptionPane.showOptionDialog(frame, "La administraci�n del cine ha sido modificada. \n�Desea guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
			case JOptionPane.YES_OPTION:
				try {
					Ficheros.guardar(cartelera, empleados);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case JOptionPane.NO_OPTION:
				gestionNuevo(frame);
				break;
			}
		}
		gestionNuevo(frame);
	}

	/**
	 * Gestiona la apertura de un fichero.
	 */
	public static void abrir(Frame frame) {
		if (Gestion.getModificado() == true) { // true == ArrayList ha sido modificado.
			int n = JOptionPane.showOptionDialog(frame, "La administraci�n del cine ha sido modificada. \n�Desea guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
				case JOptionPane.YES_OPTION:
					try {
						Ficheros.guardar(cartelera, empleados);
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case JOptionPane.NO_OPTION:
					abrirFichero(frame);
					break;
			}
		} else {
			abrirFichero(frame);
		}
		gestionModificadoGuardado(frame);
	}

	

	/**
	 * Gestiona el guardado de un fichero que ya existe.
	 */
	public static void guardar(Frame frame) {
		try {
			Ficheros.guardar(cartelera, empleados);
			gestionModificadoGuardado(frame);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido guardar el archivo", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al guardar", "Error: IOException", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Gestiona el guardado de un fichero por primera vez.
	 */
	public static void guardarComo(Frame frame) {
		try {
			Ficheros.guardarComo(cartelera, empleados);
			gestionModificadoGuardado(frame);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al guardar", "Error: IOException", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Crea un nuevo ArrayList. Restablece los valores de fichero modificado, fichero guardado y t�tulo cuando se crea un nuevo fichero.
	 */
	private static void gestionNuevo(Frame frame) {
		Gestion.cartelera = new ListaPeliculas();
		Gestion.empleados = new ListaPersonas();
		Ficheros.nuevo();
		Gestion.setModificado(true);
		Gestion.setGuardado(false); // modifica el estado del t�tulo.
		Gestion.getTitle(frame); // muestra la ruta del fichero en la barra de t�tulo.
	}
	
	
	/**
	 * Restablece los valores de fichero modificado, fichero guardado y t�tulo para los ficheros que se guardan.
	 */
	private static void gestionModificadoGuardado(Frame frame) {
		Gestion.setModificado(false);
		Gestion.setGuardado(true);
		Gestion.getTitle(frame);
	}
	
	/**
	 * Abre un fichero.
	 */
	private static void abrirFichero(Frame frame) {
		try {
			Ficheros.abrir();
			Gestion.cartelera = (ListaPeliculas) Ficheros.leerCartelera();
			Gestion.empleados = (ListaPersonas) Ficheros.leerEmpleados();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "El fichero no es v�lido", "Error: ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Permite avisar al usuario si desea guardar la configuraci�n antes de salir si se ha realizado alg�n cambio.
	 */
	public static void salir(Frame frame) {
		if (Gestion.getModificado()){
			int confirm = JOptionPane.showOptionDialog(null, "La administraci�n del cine ha sido modificada. \n�Desea guardar los cambios?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0)
				Gestion.guardar(frame);
			if (confirm == 1)
				System.exit(0);
			else
				return;
		}
		System.exit(0);
	}

}