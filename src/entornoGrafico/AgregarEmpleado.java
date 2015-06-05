package entornoGrafico;

import personal.Director;
import personal.DniInvalidoException;
import personal.EmailInvalidoException;
import personal.EmpleadoSala;
import personal.EmpleadoYaExisteException;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.NombreInvalidoException;
import personal.Persona;
import personal.Puesto;
import personal.Uniforme;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Recoje la información de la interfaz gráfica para agregar un empleado.
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class AgregarEmpleado extends EmpleadosGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AgregarEmpleado(final ListaPersonas empleados) {
		super();
		setModal(true);
		setTitle("Añadir un Empleado");
		txfldDni.setToolTipText("Formato DNI: 20555777-J");
		txfldEmail.setToolTipText("Formato de email: name@gmail.com");
		txfldFechaNacimiento.setToolTipText("Formato de fecha: 01/03/2015");
		txfldAlta.setToolTipText("Formato de fecha: 01/03/2015");
		txfldHorasSemanales.setToolTipText("Solo se aceptan números");

		txfldDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Persona.dniValido(txfldDni.getText())) {
					txfldDni.setForeground(Color.RED);
				} else {
					txfldDni.setForeground(new Color(0, 128, 0));
				}
			}
		});

		txfldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Persona.emailValido(txfldEmail.getText())) {
					txfldEmail.setForeground(Color.RED);
				} else {
					txfldEmail.setForeground(new Color(0, 128, 0));
				}
			}
		});

		txfldHorasSemanales.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char c = key.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					key.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se aceptan números.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		txfldPrecioHora.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char c = key.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					key.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se aceptan números.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		txfldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char c = key.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					key.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se aceptan números.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		txfldTitulacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent key) {
				char c = key.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					key.consume();
					JOptionPane.showMessageDialog(contentPanel,
							"Solo se acepta texto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		lblTitulacion.setLocation(225, 206);
		txfldTitulacion.setLocation(225, 224);
		lblPuesto.setSize(60, 22);
		lblPuesto.setLocation(167, 11);
		cmbxPuesto.setLocation(218, 11);

		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);

		camposPruebas();

		cmbxUniforme.setModel(new DefaultComboBoxModel<Uniforme>(Uniforme
				.values())); // inicia el combobox con la enumeración uniforme.

		cmbxPuesto.setModel(new DefaultComboBoxModel<Puesto>(Puesto.values())); // inicia
																				// el
																				// combobox
																				// con
																				// la
																				// enumeración
																				// puesto.
		cmbxPuesto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbxPuesto.getSelectedItem() == Puesto.DIRECTOR) {
					elementosDirector();
				} else if (cmbxPuesto.getSelectedItem() == Puesto.EMPLEADO_SALA) {
					elementosEmpleado();
				} else if (cmbxPuesto.getSelectedItem() == Puesto.LIMPIEZA) {
					elementosLimpiador();
				} else {
					elementosOcultos();
				}

			}
		});

		okButton.setText("Añadir");
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);

		/** ***************** Funcionalidades Botones ****************** */

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((Puesto) cmbxPuesto.getSelectedItem() == Puesto.DIRECTOR
							|| (Puesto) cmbxPuesto.getSelectedItem() == Puesto.EMPLEADO_SALA
							|| (Puesto) cmbxPuesto.getSelectedItem() == Puesto.LIMPIEZA)
						crearEmpleado((Puesto) cmbxPuesto.getSelectedItem(),
								empleados);
					else
						JOptionPane
								.showMessageDialog(
										contentPanel,
										"Por favor, selecciona un puesto y rellena los campos.",
										"Error", JOptionPane.ERROR_MESSAGE);

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"El formato numérico introducido es incorrecto.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (NombreInvalidoException e1) {
					JOptionPane
							.showMessageDialog(
									contentPanel,
									"El nombre introducido es incorrecto. \nSolo puede contener letras.",
									"Error", JOptionPane.ERROR_MESSAGE);
				} catch (DniInvalidoException e1) {
					JOptionPane
							.showMessageDialog(
									contentPanel,
									"El DNI introducido es incorrecto. \nFormato: 20555777-J",
									"Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmailInvalidoException e1) {
					JOptionPane
							.showMessageDialog(
									contentPanel,
									"El email introducido es incorrecto. \nFormato: name@gmail.com",
									"Error", JOptionPane.ERROR_MESSAGE);
				} catch (ParseException e1) {
					JOptionPane
							.showMessageDialog(
									contentPanel,
									"La fecha introducida es incorrecta. \nFormato: 01/03/2015",
									"Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmpleadoYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"El empleado ya existe. \nEl DNI está repetido.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

	/**
	 * Muestra los campos relacionados con el director.
	 */
	private void elementosDirector() {
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		lblTitulacion.setVisible(true);
		txfldTitulacion.setVisible(true);
	}

	/**
	 * Muestra los campos relacionados con el empleado de sala.
	 */
	private void elementosEmpleado() {
		lblUniforme.setVisible(true);
		cmbxUniforme.setVisible(true);
		lblTitulacion.setVisible(true);
		txfldTitulacion.setVisible(true);
	}

	/**
	 * Muestra los campos relacionados con el limpiador.
	 */
	private void elementosLimpiador() {
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);
	}

	/**
	 * Oculta los campos individuales de cada empleado.
	 */
	private void elementosOcultos() {
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);
	}

	/**
	 * Crea un empleado recogiendo la información de los campos.
	 * 
	 * @param puesto
	 *            del empleado
	 * @param empleados
	 * @throws NumberFormatException
	 *             se lanza si el formato de número introducido no es correcto.
	 * @throws EmpleadoYaExisteException
	 *             se lanza si el empleado ya existe en la colección.
	 * @throws NombreInvalidoException
	 *             se lanza si el nombre no cumple con el patrón.
	 * @throws DniInvalidoException
	 *             se lanza si el dni no cumple con el patrón.
	 * @throws EmailInvalidoException
	 *             se lanza si el email no cumple con el patrón.
	 * @throws ParseException
	 *             se lanza si la fecha no cumple con el formato.
	 * @throws HeadlessException
	 *             se lanza cuando el entorno no soporta un teclado o ratón.
	 */
	private void crearEmpleado(Puesto puesto, ListaPersonas empleados)
			throws NumberFormatException, EmpleadoYaExisteException,
			NombreInvalidoException, DniInvalidoException,
			EmailInvalidoException, ParseException, HeadlessException {
		switch (puesto) {
		case DIRECTOR:
			Persona director = new Director(txfldNombreApellidos.getText(),
					Integer.parseInt(txfldPrecioHora.getText()),
					txfldDni.getText(), txfldDireccion.getText(),
					formato.parse(txfldFechaNacimiento.getText()),
					txfldTelefono.getText(), txfldEmail.getText(),
					formato.parse(txfldAlta.getText()),
					Integer.parseInt(txfldHorasSemanales.getText()),
					txfldTitulacion.getText());
			if (empleados.agregarPersona(director, txfldDni.getText()))
				JOptionPane.showMessageDialog(contentPanel,
						"El director ha sido añadido correctamente.");
			break;
		case EMPLEADO_SALA:
			Persona empleadoSala = new EmpleadoSala(
					txfldNombreApellidos.getText(),
					Integer.parseInt(txfldPrecioHora.getText()),
					txfldDni.getText(), txfldDireccion.getText(),
					formato.parse(txfldFechaNacimiento.getText()),
					txfldTelefono.getText(), txfldEmail.getText(),
					formato.parse(txfldAlta.getText()),
					Integer.parseInt(txfldHorasSemanales.getText()),
					txfldTitulacion.getText(),
					(Uniforme) (cmbxUniforme.getSelectedItem()));
			if (empleados.agregarPersona(empleadoSala, txfldDni.getText()))
				JOptionPane.showMessageDialog(contentPanel,
						"El empleado de sala ha sido añadido correctamente.");
			break;
		case LIMPIEZA:
			Persona limpiador = new Limpiador(txfldNombreApellidos.getText(),
					Integer.parseInt(txfldPrecioHora.getText()),
					txfldDni.getText(), txfldDireccion.getText(),
					formato.parse(txfldFechaNacimiento.getText()),
					txfldTelefono.getText(), txfldEmail.getText(),
					formato.parse(txfldAlta.getText()),
					Integer.parseInt(txfldHorasSemanales.getText()));
			if (empleados.agregarPersona(limpiador, txfldDni.getText()))
				JOptionPane.showMessageDialog(contentPanel,
						"El limpiador ha sido añadido correctamente.");
			break;
		default:
			break;
		}
	}

}
