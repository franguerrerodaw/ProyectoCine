package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
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
		
		cmbxZona.setEnabled(false);
		
		
		this.empleados = mostrarPuesto(personas);
		this.limpiador = (Limpiador) empleados.getIndex(indice);
		
		comprobar();
		
		
		
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
				cmbxZona.setModel(new DefaultComboBoxModel<Zona>(Zona.values()));
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
		cmbxPuesto.addItem(((Limpiador) persona).getPuesto());
		cmbxPuesto.setSelectedItem(((Limpiador) persona).getPuesto());
		cmbxZona.addItem(((Limpiador) persona).getZona());
		cmbxZona.setSelectedItem(((Limpiador) persona).getZona());
	}
	
	
	/**
	 * Colección de Limpiadores.
	 * @param empleados
	 * @return colección de limpiadores.
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
