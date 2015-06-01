package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import personal.EmpleadoSala;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
import personal.Puesto;
import personal.Turno;
import personal.Zona;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Asigna zonas de limpieza a los limpiadores.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class AsignarZonaLimpieza extends FuncionalidadesGUI {

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
	public AsignarZonaLimpieza(final ArrayList<Persona> empleados) {
		super();
		setModal(true);
		setTitle("Asignar Zona de Limpieza");
		
		
		lblTurno.setVisible(false);
		cmbxTurno.setVisible(false);
		okButton.setVisible(false);
		
		
		this.empleados = mostrarPuesto(empleados);
		
		comprobar();
		
		cmbxZona.setModel(new DefaultComboBoxModel<Zona>(Zona.values()));
		cmbxZona.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbxZona.getSelectedItem() == Zona.SELECCIONA) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.SELECCIONA);
					empleados.set(indice, limpiador);
				} else if (cmbxZona.getSelectedItem() == Zona.LOCAL_RECIBIDOR) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.LOCAL_RECIBIDOR);
					empleados.set(indice, limpiador);
				} else if (cmbxZona.getSelectedItem() == Zona.ASEOS) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.ASEOS);
					empleados.set(indice, limpiador);
				} else if (cmbxZona.getSelectedItem() == Zona.SALA1) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.SALA1);
					empleados.set(indice, limpiador);
				} else if (cmbxZona.getSelectedItem() == Zona.SALA2) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.SALA2);
					empleados.set(indice, limpiador);
				} else if (cmbxZona.getSelectedItem() == Zona.SALA3) {
					Limpiador limpiador = (Limpiador) empleados.get(indice);
					limpiador.setZona(Zona.SALA3);
					empleados.set(indice, limpiador);
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
		
		if (persona instanceof Limpiador) {
			Limpiador limpiador = (Limpiador) persona;
			cmbxPuesto.addItem(limpiador.getPuesto());
			cmbxPuesto.setSelectedItem(limpiador.getPuesto());
			cmbxZona.addItem(limpiador.getZona());
			cmbxZona.setSelectedItem(limpiador.getZona());
		}
		
	}
	
	
	/**
	 * Creación del ArrayList de Limpiadores. NO SE UTILIZA.
	 * @return ArrayList con los empleados de sala.
	 */
	private ArrayList<Persona> crearArrayList(){
		ArrayList<Persona> personas = empleados.getPuesto(Puesto.LIMPIEZA);
		if (personas.isEmpty())
			JOptionPane.showMessageDialog(contentPanel, "No existe ningún empleado con el puesto elegido.", "Error", JOptionPane.ERROR_MESSAGE);	
		return personas;
	}
	
	
	/**
	 * Colección de Limpiadores.
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
