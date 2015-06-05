package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import personal.Director;
import personal.EmpleadoSala;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
/**
 * Ver el salario de todos los empleados.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class VerSalarios extends FuncionalidadesGUI {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Almacena la colección empleados.
	 */
	private ListaPersonas empleados;
	
	/**
	 * Índice para comprobar si hay más elementos antes o después en el ArrayList.
	 */
	private int indice = -1;

	/**
	 * Create the dialog.
	 */
	public VerSalarios(ListaPersonas empleados) {
		super();
		cmbxPuesto.setEnabled(false);
		setModal(true);
		setTitle("Ver Salarios de los Empleados");
		
		
		lblZona.setVisible(false);
		cmbxZona.setVisible(false);
		lblTurno.setVisible(false);
		cmbxTurno.setVisible(false);
		okButton.setVisible(false);
		btnCambiar.setVisible(false);
		btnGuardar.setVisible(false);
		btnComparar.setVisible(false);
		
		
		this.empleados = empleados;
		
		comprobar();
		
		
		
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
	 * Comprueba los elementos anteriores y posteriores en el ArrayList para deshabilitar, o no, los botones anterior y siguiente.
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
	 * @param persona
	 */
	private void mostrarEmpleado(Persona persona) {
		
		txfldNombreApellidos.setText(persona.getNombreYApellidos());
		txfldDni.setText(persona.getDni());
		txfldSueldo.setText(Integer.toString(persona.salario()));
		txfldAntiguedad.setText(Integer.toString(persona.bonificacion()));
		
		if (persona instanceof Director) {
			Director director = (Director) persona;
			cmbxPuesto.addItem(director.getPuesto());
			cmbxPuesto.setSelectedItem(director.getPuesto());
			
		} else if (persona instanceof EmpleadoSala) {
			EmpleadoSala empleadoSala = (EmpleadoSala) persona;
			cmbxPuesto.addItem(empleadoSala.getPuesto());
			cmbxPuesto.setSelectedItem(empleadoSala.getPuesto());
		} else if (persona instanceof Limpiador) {
			Limpiador limpiador = (Limpiador) persona;
			cmbxPuesto.addItem(limpiador.getPuesto());
			cmbxPuesto.setSelectedItem(limpiador.getPuesto());
		}
		
	}

}
