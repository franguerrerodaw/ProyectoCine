package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import personal.Director;
import personal.DniInvalidoException;
import personal.EmpleadoSala;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
import personal.PersonaNoExisteException;
/**
 * Busca un empleado a través del DNI.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class BuscarEmpleado extends EmpleadosGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public BuscarEmpleado(final ListaPersonas empleados) {
		super();
		lblUniforme.setLocation(410, 266);
		cmbxUniforme.setLocation(410, 283);
		lblTitulacion.setLocation(33, 266);
		txfldTitulacion.setLocation(33, 283);
		
		setModal(true);
		setTitle("Buscar Empleado por DNI");
		
		
		cmbxUniforme.setEnabled(false);
		txfldTitulacion.setEditable(false);
		txfldHorasSemanales.setEditable(false);
		cmbxPuesto.setEnabled(false);
		txfldPrecioHora.setEditable(false);
		txfldAlta.setEditable(false);
		txfldTelefono.setEditable(false);
		txfldFechaNacimiento.setEditable(false);
		txfldEmail.setEditable(false);
		txfldDireccion.setEditable(false);
		txfldNombreApellidos.setEditable(false);
		
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		
		okButton.setText("Buscar");
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		
		
		
		/** ***************** Funcionalidades Botones ******************  */
		
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Persona persona = empleados.getP(txfldDni.getText());
					mostrarEmpleado(persona);
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
	
	/**
	 * Muestra el empleado con la información almacenada en el ArrayList.
	 * @param persona alojada en el ArrayList.
	 */
	private void mostrarEmpleado(Persona persona) {
		
		txfldNombreApellidos.setText(persona.getNombreYApellidos());
		txfldDni.setText(persona.getDni());
		txfldDireccion.setText(persona.getDireccion());
		txfldEmail.setText(persona.getEmail());
		txfldFechaNacimiento.setText(formato.format(persona.getFechaNacimiento()));
		txfldTelefono.setText(persona.getTelefono());
		txfldAlta.setText(formato.format(persona.getAlta()));
		txfldPrecioHora.setText(Integer.toString(persona.getPrecioHora()));
		txfldHorasSemanales.setText(Integer.toString(persona.getHorasSemanales()));
		
		if (persona instanceof Director){
			Director director = (Director) persona;
			lblTitulacion.setVisible(true);
			txfldTitulacion.setVisible(true);
			lblUniforme.setVisible(false);
			cmbxUniforme.setVisible(false);
			cmbxPuesto.addItem(director.getPuesto());
			cmbxPuesto.setSelectedItem(director.getPuesto());
			txfldTitulacion.setText(director.getTitulacion());
			
		} else if (persona instanceof EmpleadoSala) {
			EmpleadoSala empleadoSala = (EmpleadoSala) persona;
			lblTitulacion.setVisible(true);
			txfldTitulacion.setVisible(true);
			lblUniforme.setVisible(true);
			cmbxUniforme.setVisible(true);
			cmbxPuesto.addItem(empleadoSala.getPuesto());
			cmbxPuesto.setSelectedItem(empleadoSala.getPuesto());
			txfldTitulacion.setText(empleadoSala.getTitulacion());
			cmbxUniforme.addItem(empleadoSala.getUniforme());
			cmbxUniforme.setSelectedItem(empleadoSala.getUniforme());
			
		} else if (persona instanceof  Limpiador) {
			Limpiador limpiador = (Limpiador) persona;
			lblTitulacion.setVisible(false);
			txfldTitulacion.setVisible(false);
			lblUniforme.setVisible(false);
			cmbxUniforme.setVisible(false);
			cmbxPuesto.addItem(limpiador.getPuesto());
			cmbxPuesto.setSelectedItem(limpiador.getPuesto());
		}
		
		
	}

}
