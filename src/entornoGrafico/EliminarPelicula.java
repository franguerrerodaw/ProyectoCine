package entornoGrafico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import peliculas.ListaPeliculas;
import peliculas.Pelicula;
import peliculas.PeliculaNoExisteException;
/**
 * Recoje la información de la interfaz gráfica para eliminar un empleado.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class EliminarPelicula extends PeliculasGUI {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the dialog.
	 */
	public EliminarPelicula(final ListaPeliculas cartelera) {
		super();
		setModal(true);
		setTitle("Eliminar una Película");
		
		cmbxGenero.setEnabled(false);
		cmbxFormato.setEnabled(false);
		txfldFechaEstreno.setEnabled(false);
		txfldDuracion.setEnabled(false);
		txtArSinopsis.setEnabled(false);
		
		
		okButton.setText("Eliminar");
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		
		
		
		/** ***************** Funcionalidades Botones ******************  */
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pelicula pelicula = cartelera.get(txfldTitulo.getText());
					mostrarPelicula(pelicula);
					int n = JOptionPane.showOptionDialog(contentPanel, "¿Está seguro de que desea eliminar la película?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
						case JOptionPane.YES_OPTION:
							cartelera.eliminar(txfldTitulo.getText());
							limpiarCampos();
							break;
					}
				} catch (PeliculaNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, "La película no existe.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
	
	/**
	 * Muestra la información de la película antes de eliminarla.
	 * @param pelicula
	 */
	private void mostrarPelicula(Pelicula pelicula) {
		txfldTitulo.setText(pelicula.getTitulo());
		cmbxGenero.addItem(pelicula.getGenero());
		cmbxGenero.setSelectedItem(pelicula.getGenero());
		cmbxFormato.addItem(pelicula.getFormato());
		cmbxFormato.setSelectedItem(pelicula.getFormato());
		txfldFechaEstreno.setText(formato.format(pelicula.getFechaEstreno()));
		txfldDuracion.setText(pelicula.getDuracion());
		txtArSinopsis.setText(pelicula.getSinopsis());
	}
	
	
	/**
	 * Borra la información de los campos después de eliminar la película.
	 */
	private void limpiarCampos() {
		txfldTitulo.setText("");
		cmbxGenero.setSelectedItem(null);
		cmbxFormato.setSelectedItem(null);
		txfldFechaEstreno.setText("");
		txfldDuracion.setText("");
		txtArSinopsis.setText("");
	}

}
