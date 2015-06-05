package entornoGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import personal.Director;
import personal.EmpleadoSala;
import personal.Limpiador;
import personal.ListaPersonas;
import personal.Persona;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * Comparar el sueldo entre dos empleados.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class CompararSueldos extends FuncionalidadesGUI {

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
	 * Cuenta las personas que se están comparando.
	 */
	private int comprobar = 0;
	
	/**
	 * Etiqueta comparar
	 */
	private JLabel lblComparar;
	
	/**
	 * Campo comparar 1
	 */
	private JTextField txtfldC1;
	
	/**
	 * Etiqueta con
	 */
	private JLabel lblCon;
	
	/**
	 * Campo comparar 2
	 */
	private JTextField txtfldC2;
	
	/**
	 * Declara una persona para compararla
	 */
	private Persona p1;
	
	/**
	 * Declara una persona para compararla
	 */
	private Persona p2;
	
	
	

	/**
	 * Create the dialog.
	 */
	public CompararSueldos(final ListaPersonas empleados) {
		super();
		setModal(true);
		setTitle("Comparar Sueldos de los Empleados");
		
		cmbxPuesto.setEnabled(false);
		lblZona.setVisible(false);
		cmbxZona.setVisible(false);
		lblTurno.setVisible(false);
		cmbxTurno.setVisible(false);
		okButton.setVisible(false);
		btnCambiar.setVisible(false);
		btnGuardar.setVisible(false);
		
		lblComparar = new JLabel("Comparar empleado:");
		lblComparar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComparar.setBounds(42, 286, 130, 19);
		contentPanel.add(lblComparar);
		
		txtfldC1 = new JTextField();
		txtfldC1.setBounds(167, 284, 130, 23);
		contentPanel.add(txtfldC1);
		txtfldC1.setColumns(10);
		
		lblCon = new JLabel("con empleado:");
		lblCon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCon.setBounds(309, 286, 103, 19);
		contentPanel.add(lblCon);
		
		txtfldC2 = new JTextField();
		txtfldC2.setBounds(401, 284, 130, 23);
		contentPanel.add(txtfldC2);
		txtfldC2.setColumns(10);
		
		btnComparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarComparable(empleados);
			}
		});
		
		
		
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
	
	
	/**
	 * Añade dos personas para compararlas
	 * @param empleados
	 */
	private void agregarComparable(final ListaPersonas empleados) {
		switch (comprobar) {
			case 0:
				p1 = empleados.getIndex(indice);
				txtfldC1.setText(empleados.getIndex(indice).getNombreYApellidos());
				++comprobar;
				break;
			case 1:
				p2 = empleados.getIndex(indice);
				txtfldC2.setText(empleados.getIndex(indice).getNombreYApellidos());
				comparar(p1, p2);
				comprobar = 0;
				txtfldC1.setText("");
				txtfldC2.setText("");
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * Recibe dos personas y las compara.
	 */
	private void comparar(Persona p1, Persona p2){
		if (p1.compareTo(p2) < 0 )
			JOptionPane.showMessageDialog(contentPanel, "El empleado " +p2.getNombreYApellidos()+ " tiene un sueldo superior.");
		else if (p1.compareTo(p2) > 0 )
			JOptionPane.showMessageDialog(contentPanel, "El empleado " +p1.getNombreYApellidos()+ " tiene un sueldo superior.");
		else if (p1.compareTo(p2) == 0 )
			JOptionPane.showMessageDialog(contentPanel, "El sueldo de ambos empleados es el mismo.");
	}
	
	
}
