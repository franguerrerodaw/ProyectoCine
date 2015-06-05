package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
import personal.Puesto;
import personal.Zona;
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
	private int indice;
	
	
	/**
	 * Objeto de la clase Limpiador.
	 */
	private Limpiador limpiador;
	
	

	/**
	 * Create the dialog.
	 */
	public AsignarZonaLimpieza(final ArrayList<Persona> personas) {
		super();
		cmbxPuesto.setEnabled(false);
		setModal(true);
		setTitle("Asignar Zona de Limpieza");
		
		
		lblTurno.setVisible(false);
		cmbxTurno.setVisible(false);
		lblSueldo.setVisible(false);
		txfldSueldo.setVisible(false);
		lblAntiguedad.setVisible(false);
		txfldAntiguedad.setVisible(false);
		okButton.setVisible(false);
		btnGuardar.setVisible(false);
		btnComparar.setVisible(false);
		
		
		this.empleados = mostrarPuesto(personas);
		
		comprobar();
		
		cmbxZona.setModel(new DefaultComboBoxModel<Zona>(Zona.values()));
		cmbxZona.setEnabled(false);
		
		
		/** ***************** Funcionalidades Botones ******************  */
		
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
				cmbxZona.setEnabled(true);
				btnCambiar.setVisible(false);
				btnGuardar.setVisible(true);
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarZona();
				funcionalidadGuardado();
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
		mostrarEmpleado();
		comprobarArray();
	}
	
	
	/**
	 * Muestra el elemento siguiente del ArrayList empleados.
	 */
	private void mostrarSiguiente() {
		mostrarEmpleado();
		comprobarArray();
	}
	
	/**
	 * Muestra el primer elemento del ArrayList.
	 */
	private void comprobar() {
		indice = 0;
		mostrarEmpleado();
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
	private void mostrarEmpleado() {
		limpiador = (Limpiador) empleados.getIndex(indice);
		txfldNombreApellidos.setText(limpiador.getNombreYApellidos());
		txfldDni.setText(limpiador.getDni());
		cmbxPuesto.addItem(limpiador.getPuesto());
		cmbxPuesto.setSelectedItem(limpiador.getPuesto());
		cmbxZona.addItem(limpiador.getZona());
		cmbxZona.setSelectedItem(limpiador.getZona());
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
	
	
	/**
	 * Modifica la zona de trabajo de los limpiadores
	 * @param empleados
	 */
	private void modificarZona() {
		limpiador = (Limpiador) empleados.getIndex(indice);
		
		switch ((Zona) cmbxZona.getSelectedItem()) {
			case SIN_ZONA:
				limpiador.setZona(Zona.SIN_ZONA);
				break;
			case LOCAL_RECIBIDOR:
				limpiador.setZona(Zona.LOCAL_RECIBIDOR);
				break;
			case ASEOS:
				limpiador.setZona(Zona.ASEOS);
				break;
			case SALA1:
				limpiador.setZona(Zona.SALA1);
				break;
			case SALA2:
				limpiador.setZona(Zona.SALA2);
				break;
			case SALA3:
				limpiador.setZona(Zona.SALA3);
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * Modifica el estado de los botones
	 */
	private void funcionalidadGuardado() {
		cmbxZona.setEnabled(false);
		btnGuardar.setVisible(false);
		btnCambiar.setVisible(true);
	}

}
