package entornoGrafico;
import personal.DniInvalidoException;
import personal.ListaPersonas;
import personal.Persona;
import personal.PersonaNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
/**
 * Recoje la información de la interfaz gráfica para eliminar un empleado.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class EliminarEmpleado extends EmpleadosGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Etiqueta introduce un DNI.
	 */
	private JLabel lblIntroduceUnDni;

	/**
	 * Create the dialog.
	 */
	public EliminarEmpleado(final ListaPersonas empleados) {
		super();
		txfldNombreApellidos.setEditable(false);
		cmbxUniforme.setEditable(true);
		lblTitulacion.setLocation(225, 206);
		txfldTitulacion.setLocation(225, 224);
		lblPuesto.setSize(60, 22);
		lblPuesto.setLocation(167, 11);
		cmbxPuesto.setLocation(218, 11);
		
		setModal(true);
		setTitle("Eliminar un Empleado");
		
		lblIntroduceUnDni = new JLabel("Introduce un DNI para eliminar a un empleado.");
		lblIntroduceUnDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIntroduceUnDni.setBounds(110, 152, 402, 31);
		contentPanel.add(lblIntroduceUnDni);
		
		
		lblPuesto.setVisible(false);
		cmbxPuesto.setVisible(false);
		lblDireccion.setVisible(false);
		txfldDireccion.setVisible(false);
		lblFechaDeNacimiento.setVisible(false);
		txfldFechaNacimiento.setVisible(false);
		lblTelfono.setVisible(false);
		txfldTelefono.setVisible(false);
		lblEmail.setVisible(false);
		txfldEmail.setVisible(false);
		lblAlta.setVisible(false);
		txfldAlta.setVisible(false);
		lblPrecioHora.setVisible(false);
		txfldPrecioHora.setVisible(false);
		lblNHorasSemanales.setVisible(false);
		txfldHorasSemanales.setVisible(false);
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		
		
		
		okButton.setText("Eliminar");
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		
		
		/** ***************** Funcionalidades Botones ******************  */
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Persona persona = empleados.getP(txfldDni.getText());
					txfldNombreApellidos.setText(persona.getNombreYApellidos());
					int n = JOptionPane.showOptionDialog(contentPanel, "¿Está seguro de que desea borrar el empleado?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
						case JOptionPane.YES_OPTION:
							empleados.eliminar(persona);
							txfldNombreApellidos.setText("");
							txfldDni.setText("");
							break;
						}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(contentPanel, "El formato de número introducido es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (PersonaNoExisteException e) {
					JOptionPane.showMessageDialog(contentPanel, "El empleado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (DniInvalidoException e) {
					JOptionPane.showMessageDialog(contentPanel, "El DNI introducido es incorrecto. \nFormato: 20555111-J", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
}
