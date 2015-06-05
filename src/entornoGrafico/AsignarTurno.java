package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import personal.EmpleadoSala;
import personal.ListaPersonas;
import personal.Persona;
import personal.Puesto;
import personal.Turno;
import utiles.Gestion;

/**
 * Asigna turnos a los empleados de sala.
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class AsignarTurno extends FuncionalidadesGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Almacena la colección empleados.
	 */
	private ListaPersonas empleados;

	/**
	 * Objeto de la clase Persona
	 */
	private Persona empleadoSala;

	/**
	 * Índice para comprobar si hay más elementos antes o después en el
	 * ArrayList.
	 */
	private int indice;

	/**
	 * Create the dialog.
	 */
	public AsignarTurno(ListaPersonas empleados) {
		super();
		cmbxPuesto.setEnabled(false);
		cmbxZona.setLocation(225, 284);
		setModal(true);
		setTitle("Asignar Turno");

		lblZona.setVisible(false);
		cmbxZona.setVisible(false);
		lblSueldo.setVisible(false);
		txfldSueldo.setVisible(false);
		lblAntiguedad.setVisible(false);
		txfldAntiguedad.setVisible(false);
		okButton.setVisible(false);
		btnGuardar.setVisible(false);
		btnComparar.setVisible(false);

		this.empleados = empleados;

		comprobar();

		cmbxTurno.setModel(new DefaultComboBoxModel<Turno>(Turno.values()));
		cmbxTurno.setEnabled(false);

		/** ***************** Funcionalidades Botones ****************** */

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionalidadGuardado();
				mostrarAnterior();
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionalidadGuardado();
				mostrarSiguiente();
			}
		});

		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbxTurno.setEnabled(true);
				btnCambiar.setVisible(false);
				btnGuardar.setVisible(true);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarTurno();
				funcionalidadGuardado();
				System.out.println("\n\nModificación:\n");
				System.out.println(empleadoSala.getNombreYApellidos());
				System.out.println(((EmpleadoSala) empleadoSala).getPuesto());
				System.out.println(((EmpleadoSala) empleadoSala).getTurno());
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}

	/**
	 * Muestra el elemento anterior del ArrayList empleados.
	 */
	private void mostrarAnterior() {
		mostrarEmpleado(empleados.getIndex(--indice));
		comprobarArray();
	}

	/**
	 * Muestra el elemento siguiente del ArrayList empleados.
	 */
	private void mostrarSiguiente() {
		mostrarEmpleado(empleados.getIndex(++indice));
		comprobarArray();
	}

	/**
	 * Muestra el primer elemento del ArrayList.
	 */
	private void comprobar() {
		indice = 0;
		mostrarEmpleado(empleados.getIndex(indice));
		comprobarArray();
	}

	/**
	 * Comprueba los elementos anteriores y posteriores en el ArrayList para
	 * deshabilitar, o no, los botones anterior y siguiente.
	 */
	private void comprobarArray() {
		if (empleados.getIndex(indice + 1) == null)
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);

		if (empleados.getIndex(indice - 1) == null)
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
	}

	/**
	 * Muestra el empleado con la información almacenada en el ArrayList.
	 * 
	 * @param persona
	 */
	private void mostrarEmpleado(Persona persona) {
		System.out.println(empleadoSala);
		txfldNombreApellidos.setText(persona.getNombreYApellidos());
		txfldDni.setText(persona.getDni());
		cmbxPuesto.addItem(((EmpleadoSala) persona).getPuesto());
		cmbxPuesto.setSelectedItem(((EmpleadoSala) persona).getPuesto());
		cmbxTurno.addItem(((EmpleadoSala) persona).getTurno());
		cmbxTurno.setSelectedItem(((EmpleadoSala) persona).getTurno());

	}


	
	

	
	
	
	

	
	/**
	 * Modifica el turno de los empleados de sala
	 * 
	 * @param empleados
	 */
	private void modificarTurno() {
		empleadoSala = (EmpleadoSala) empleados.getIndex(indice);
		System.out.println("\nAntes de Modificar:\n");
		System.out.println(empleadoSala.getNombreYApellidos());
		System.out.println(((EmpleadoSala) empleadoSala).getPuesto());
		System.out.println(((EmpleadoSala) empleadoSala).getTurno());
		switch ((Turno) cmbxTurno.getSelectedItem()) {
		case SIN_TURNO:
			((EmpleadoSala) empleadoSala).setTurno(Turno.SIN_TURNO);
			break;
		case TURNO_DIURNO:
			((EmpleadoSala) empleadoSala).setTurno(Turno.TURNO_DIURNO);
			break;
		case TURNO_TARDE:
			((EmpleadoSala) empleadoSala).setTurno(Turno.TURNO_TARDE);
			break;
		case TURNO_NOCTURNO:
			((EmpleadoSala) empleadoSala).setTurno(Turno.TURNO_NOCTURNO);
			break;
		default:
			break;
		}
	}

	/**
	 * Modifica el estado de los botones
	 */
	private void funcionalidadGuardado() {
		cmbxTurno.setEnabled(false);
		btnGuardar.setVisible(false);
		btnCambiar.setVisible(true);
	}

}
