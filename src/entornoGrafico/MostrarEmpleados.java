package entornoGrafico;
import personal.Director;
import personal.EmpleadoSala;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
import personal.PersonaNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Muestra todos los empleados añadidos al ArrayList.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class MostrarEmpleados extends EmpleadosGUI {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Almacena la colección empleados.
	 */
	private ListaPersonas empleados;
	
	/**
	 * Índice para los botones anterior / siguiente
	 */
	private int indice = -1;
	

	/**
	 * Create the dialog.
	 * @throws PersonaNoExisteException 
	 * @throws NoHayEmpleadosException 
	 */
	public MostrarEmpleados(ListaPersonas empleados) {
		super();
		lblUniforme.setLocation(410, 266);
		cmbxUniforme.setLocation(410, 283);
		setModal(true);
		setTitle("Mostrar Empleados");
		
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
		txfldDni.setEditable(false);
		txfldNombreApellidos.setEditable(false);
		
		lblTitulacion.setVisible(false);
		txfldTitulacion.setVisible(false);
		lblUniforme.setVisible(false);
		cmbxUniforme.setVisible(false);
		
		okButton.setVisible(false);
		
		this.empleados = empleados;
		
		
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
		
		comprobar();
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
	 * Muestra la información almacenada en el ArrayList.
	 * @param persona
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
