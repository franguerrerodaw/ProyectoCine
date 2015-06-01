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
import personal.Zona;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Asigna turnos a los empleados de sala.
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
	 * Índice para comprobar si hay más elementos antes o después en el ArrayList.
	 */
	private int indice = -1;

	/**
	 * Create the dialog.
	 */
	public AsignarTurno(final ArrayList<Persona> empleados) {
		super();
		setModal(true);
		setTitle("Asignar Turno");
		
		
		lblZona.setVisible(false);
		cmbxZona.setVisible(false);
		okButton.setVisible(false);
		
		
		this.empleados = mostrarPuesto(empleados);
		
		comprobar();
		
		cmbxTurno.setModel(new DefaultComboBoxModel<Turno>(Turno.values()));
		cmbxTurno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbxTurno.getSelectedItem() == Turno.SELECCIONA) {
					EmpleadoSala empleadoSala = (EmpleadoSala) empleados.get(indice);
					empleadoSala.setTurno(Turno.SELECCIONA);
					empleados.set(indice, empleadoSala);
				} else if (cmbxTurno.getSelectedItem() == Turno.TURNO_DIURNO) {
					EmpleadoSala empleadoSala = (EmpleadoSala) empleados.get(indice);
					empleadoSala.setTurno(Turno.TURNO_DIURNO);
					empleados.set(indice, empleadoSala);
				} else if (cmbxTurno.getSelectedItem() == Turno.TURNO_TARDE) {
					EmpleadoSala empleadoSala = (EmpleadoSala) empleados.get(indice);
					empleadoSala.setTurno(Turno.TURNO_TARDE);
					empleados.set(indice, empleadoSala);
				} else if (cmbxTurno.getSelectedItem() == Turno.TURNO_NOCTURNO) {
					EmpleadoSala empleadoSala = (EmpleadoSala) empleados.get(indice);
					empleadoSala.setTurno(Turno.TURNO_NOCTURNO);
					empleados.set(indice, empleadoSala);
				}
				
			}
		});
		
		
		
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
		
		if (persona instanceof EmpleadoSala) {
			EmpleadoSala empleadoSala = (EmpleadoSala) persona;
			cmbxPuesto.addItem(empleadoSala.getPuesto());
			cmbxPuesto.setSelectedItem(empleadoSala.getPuesto());
			cmbxTurno.addItem(empleadoSala.getTurno());
			cmbxTurno.setSelectedItem(empleadoSala.getTurno());
		}
		
	}
	
	
	/**
	 * Creación del ArrayList de Empleados de Sala. NO SE UTILIZA.
	 * @return ArrayList con los empleados de sala.
	 */
	private ArrayList<Persona> crearArrayList(){
		ArrayList<Persona> personas = empleados.getPuesto(Puesto.EMPLEADO_SALA);
		if (personas.isEmpty())
			JOptionPane.showMessageDialog(contentPanel, "No existe ningún empleado con el puesto elegido.", "Error", JOptionPane.ERROR_MESSAGE);	
		return personas;
	}
	
	
	/**
	 * Colección de Empleados de sala.
	 * @param empleados
	 * @return colección de empleados de sala.
	 */
	private ListaPersonas mostrarPuesto(ArrayList<Persona> empleados) {
		ListaPersonas mostrarPuesto = new ListaPersonas();
		for (Persona persona : empleados)
			mostrarPuesto.agregarPuesto(persona);
		return mostrarPuesto;
	}

}
