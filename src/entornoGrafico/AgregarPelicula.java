package entornoGrafico;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import peliculas.Formato;
import peliculas.Genero;
import peliculas.ListaPeliculas;
import peliculas.PeliculaYaExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Recoje la información de la interfaz gráfica para agregar una película.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class AgregarPelicula extends PeliculasGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Se utiliza para comprobar que la fecha introducida sea válida. Los días deben de comenzar por cero y un número cualquiera, seguido de una barra y un cero o un número cualquiera, seguido de una barra y fechas de cuatro dígitos a partir de 1900.
	 */
	private static final Pattern patternFecha = Pattern.compile("^((0[1-9])|([1-2][0-9])|(3[0-1]))\\/((0[1-9])|(1[0-2]))\\/((19([0-9]{2}))|(2([0-9]{3})))$");
	
	/**
	 * Tick verde para validar el campo fecha.
	 */
	private JLabel lblTickGreen;
	
	/**
	 * Aspa roja para advertir que el campo fecha tiene un formato incorrecto.
	 */
	private JLabel lblTickRed;

	/**
	 * Create the dialog.
	 */
	public AgregarPelicula(final ListaPeliculas cartelera) {
		super();
		txfldFechaEstreno.setLocation(58, 135);
		txfldDuracion.setLocation(241, 136);
		txfldDuracion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (esValido(txfldFechaEstreno.getText())){
					lblTickGreen.setVisible(true);
					lblTickRed.setVisible(false);
				} else {
					lblTickRed.setVisible(true);
					lblTickGreen.setVisible(false);
				}
			}
		});
		txfldDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char c = key.getKeyChar();
				if(Character.isLetter(c)) {
					getToolkit().beep();
					key.consume();
					JOptionPane.showMessageDialog(contentPanel, "Solo se aceptan números.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		setModal(true);
		setTitle("Añadir una Película");
		txfldFechaEstreno.setToolTipText("Formato de fecha: 01/03/2015");
		
		cmbxGenero.setModel(new DefaultComboBoxModel<Genero>(Genero.values())); //inicializamos el combobox Género.
		cmbxFormato.setModel(new DefaultComboBoxModel<Formato>(Formato.values()));
		
		lblTickGreen = new JLabel("");
		lblTickGreen.setVisible(false);
		lblTickGreen.setIcon(new ImageIcon(AgregarPelicula.class.getResource("/img/tick-green-18x18.png")));
		lblTickGreen.setBounds(191, 135, 24, 23);
		contentPanel.add(lblTickGreen);
		
		lblTickRed = new JLabel("");
		lblTickRed.setVisible(false);
		lblTickRed.setIcon(new ImageIcon(AgregarPelicula.class.getResource("/img/tick-red-18x18.gif")));
		lblTickRed.setBounds(191, 135, 24, 23);
		contentPanel.add(lblTickRed);
		
		
		okButton.setText("Añadir");
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		
		
		/** ***************** Funcionalidades Botones ******************  */
		
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbxGenero.getSelectedItem() == Genero.SELECCIONA){
					JOptionPane.showMessageDialog(contentPanel, "Por favor, selecciona un género y rellena los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (cmbxFormato.getSelectedItem() == Formato.SELECCIONA){
					JOptionPane.showMessageDialog(contentPanel, "Por favor, selecciona un formato y rellena los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				} else
					try {
						if (cartelera.agregar(txfldTitulo.getText(), (Genero) cmbxGenero.getSelectedItem(), (Formato) cmbxFormato.getSelectedItem(), formato.parse(txfldFechaEstreno.getText()), txfldDuracion.getText(), txtArSinopsis.getText()));
						JOptionPane.showMessageDialog(contentPanel, "La película ha sido añadida correctamente.");
					} catch (PeliculaYaExisteException e) {
						JOptionPane.showMessageDialog(contentPanel, "La película ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (ParseException e) {
						JOptionPane.showMessageDialog(contentPanel, "La fecha introducida es incorrecta. \nFormato: 01/03/2015", "Error", JOptionPane.ERROR_MESSAGE);
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
	 * Comprueba que la fecha introducida cumple con el patrón.
	 * @param fecha que introduce el usuario.
	 * @return verdadero si la fecha cumple con el patrón.
	 */
	private boolean esValido(String fecha){
		return patternFecha.matcher(fecha).matches();
	}
}
