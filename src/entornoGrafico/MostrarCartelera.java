package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peliculas.ListaPeliculas;
import peliculas.Pelicula;
/**
 * Muestra todas las películas almacenadas en el ArrayList
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class MostrarCartelera extends PeliculasGUI {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Almacena la colección cartelera.
	 */
	private ListaPeliculas cartelera;
	
	/**
	 * Índice para los botones anterior / siguiente
	 */
	private int indice = -1;

	/**
	 * Create the dialog.
	 */
	public MostrarCartelera(ListaPeliculas cartelera) {
		super();
		setModal(true);
		setTitle("Mostrar Cartelera");
		
		txfldTitulo.setEnabled(false);
		cmbxGenero.setEnabled(false);
		cmbxFormato.setEnabled(false);
		txfldFechaEstreno.setEnabled(false);
		txfldDuracion.setEnabled(false);
		txtArSinopsis.setEnabled(false);
		
		
		okButton.setVisible(false);
		
		this.cartelera = cartelera;
		
		/** ***************** Funcionalidades Botones ******************  */
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		comprobar();
		
	}
	
	/**
	 * Muestra el elemento anterior del ArrayList cartelera.
	 */
	private void mostrarAnterior() {
		mostrarPelicula(cartelera.get(--indice));
		comprobarArray();
	}
	
	/**
	 * Muestra el elemento siguiente del ArrayList cartelera.
	 */
	private void mostrarSiguiente() {
		mostrarPelicula(cartelera.get(++indice));
		comprobarArray();
	}
	
	/**
	 * Muestra el primer elemento del ArrayList.
	 */
	private void comprobar() {
		indice = 0;
		mostrarPelicula(cartelera.get(indice));
		comprobarArray();
	}
	
	/**
	 * Comprueba los elementos anteriores y posteriores en el ArrayList para deshabilitar, o no, los botones anterior y siguiente.
	 */
	private void comprobarArray() {
		if (cartelera.get(indice + 1) == null)
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);

		if (cartelera.get(indice - 1) == null)
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
	}
	
	/**
	 * Muestra la información almacenada en el ArrayList.
	 * @param pelicula
	 */
	private void mostrarPelicula(Pelicula pelicula){
		txfldTitulo.setText(pelicula.getTitulo());
		cmbxGenero.addItem(pelicula.getGenero());
		cmbxGenero.setSelectedItem(pelicula.getGenero());
		cmbxFormato.addItem(pelicula.getFormato());
		cmbxFormato.setSelectedItem(pelicula.getFormato());
		txfldFechaEstreno.setText(formato.format(pelicula.getFechaEstreno()));
		txfldDuracion.setText(pelicula.getDuracion());
		txtArSinopsis.setText(pelicula.getSinopsis());
	}
}
