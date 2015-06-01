package utiles;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entornoGrafico.Principal;
import peliculas.ListaPeliculas;
/**
 * Gestiona abrir, guardar y crear nuevos archivos.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Gestion {
	
	/**
	 * JFrame Gestion.
	 */
	private static JFrame frame = new JFrame();
	
	/**
	 * almacena si el ArrayList ha sido modificado a�adiendo o eliminando elementos.
	 */
	protected static boolean modificado = false;
	
	/**
	 * almacena si el ArrayList ha sido guardado o no para cambiar el t�tulo en barra de t�tulo.
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
	 * @param frame
	 */
	public static void getTitle(JFrame frame) {
		if(Gestion.getGuardado() == false)
			frame.setTitle("Administraci�n Cine  -  Sin_T�tulo");
		else
			frame.setTitle("Administraci�n Cine  -  " + Ficheros.getFile());
		
	}
	
	/**
	 * Modifica el estado de la variable guardado. Se utiliza para cambiar el t�tulo en la barra de t�tulo
	 * @param valor
	 * @return verdadero si se ha guardado el fichero.
	 */
	public static boolean setGuardado(boolean valor) {
		guardado = valor;
		return true;
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
	 * @param frame
	 * @param contentPanel
	 * @param cartelera
	 */
	public static void nuevo(JFrame frame, JPanel contentPanel, ListaPeliculas cartelera){
		if (Gestion.getModificado() == true){ //true == ArrayList ha sido modificado
			int n = JOptionPane.showOptionDialog(contentPanel, "La administraci�n del cine ha sido modificada. \n�Desea guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
				case JOptionPane.YES_OPTION:
				try {
					Ficheros.guardarComo(cartelera);
					gestionNuevo(frame);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
				}
					break;
				case JOptionPane.NO_OPTION:
					gestionNuevo(frame);
			}
		} else{
			gestionNuevo(frame);
		}
	}
	
	/**
	 * Gestiona la apertura de un fichero.
	 * @param frame
	 * @param contentPanel
	 * @param cartelera
	 */
	public static void abrir(JFrame frame, JPanel contentPanel, ListaPeliculas cartelera){
		if (Gestion.getModificado() == true){ //true == ArrayList ha sido modificado.
			int n = JOptionPane.showOptionDialog(contentPanel, "La administraci�n del cine ha sido modificada. \n�Desea guardar los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
				case JOptionPane.YES_OPTION:
				try {
					Ficheros.guardarComo(cartelera);
					gestionModificado(frame);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
				}
					break;
				case JOptionPane.NO_OPTION:
				try {
					Principal.cartelera = Ficheros.abrir(cartelera);
					gestionModificado(frame);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "El fichero no es v�lido", "Error: ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else {
			try {
				Principal.cartelera = Ficheros.abrir(cartelera);
				gestionModificado(frame);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "El fichero no es v�lido", "Error: ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "No se ha podido abrir el fichero", "Error: IOException", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Gestiona el guardado de un fichero que ya existe.
	 * @param frame
	 * @param cartelera
	 */
	public static void guardar(JFrame frame, ListaPeliculas cartelera){
		try {
			Ficheros.guardar(cartelera);
			gestionModificado(frame);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido guardar el archivo", "Error: FileNotFoundException", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al guardar", "Error: IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Gestiona el guardado de un fichero por primera vez.
	 * @param cartelera
	 */
	public static void guardarComo(ListaPeliculas cartelera){
		try {
			Ficheros.guardarComo(cartelera);
			Gestion.setModificado(false);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al guardar", "Error: IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Crea un nuevo ArrayList.
	 * @param frame
	 */
	private static void gestionNuevo(JFrame frame) {
		entornoGrafico.Principal.cartelera = new ListaPeliculas();
		gestionModificado(frame);
	}
	
	/**
	 * Restablece los valores de fichero modificado, fichero guardado, t�tulo y crea un nuevo fichero.
	 * @param frame
	 */
	private static void gestionModificado(JFrame frame) {
		Ficheros.nuevo();
		Gestion.setModificado(false);
		Gestion.setGuardado(false); // modifica el estado del t�tulo.
		Gestion.getTitle(frame); // muestra la ruta del fichero en la barra de t�tulo.
	}
	

}