package entornoGrafico;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import personal.ListaPersonas;
import personal.Persona;
import personal.Puesto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * Elige un puesto de empleado.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class ElegirPuesto extends JDialog {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * JPanel
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * objeto de la clase MostrarPorPuesto
	 */
	private MostrarPorPuesto mostrarPorPuesto;
	
	/**
	 * ButtonPane
	 */
	private JPanel buttonPane;
	
	/**
	 * Botón Ok.
	 */
	private JButton okButton;
	
	/**
	 * Botón cancelar.
	 */
	private JButton cancelButton;
	
	/**
	 * Grupo de radiobutton.
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * JRadioButton director.
	 */
	private JRadioButton rdbtnDirector;
	
	/**
	 * JRadioButton empleado de sala.
	 */
	private JRadioButton rdbtnEmpleadoSala;
	
	/**
	 * JRadioButton limpiador.
	 */
	private JRadioButton rdbtnLimpiador;

	/**
	 * Create the dialog.
	 */
	public ElegirPuesto(final ListaPersonas empleados) {
		setModal(true);
		setTitle("Elige un Puesto");
		setResizable(false);
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		rdbtnDirector = new JRadioButton("Director");
		buttonGroup.add(rdbtnDirector);
		rdbtnDirector.setBounds(41, 29, 76, 23);
		contentPanel.add(rdbtnDirector);
		
		rdbtnEmpleadoSala = new JRadioButton("Empleado Sala");
		buttonGroup.add(rdbtnEmpleadoSala);
		rdbtnEmpleadoSala.setBounds(159, 29, 109, 23);
		contentPanel.add(rdbtnEmpleadoSala);
		
		rdbtnLimpiador = new JRadioButton("Limpiador");
		buttonGroup.add(rdbtnLimpiador);
		rdbtnLimpiador.setBounds(308, 29, 109, 23);
		contentPanel.add(rdbtnLimpiador);
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						elegirPuesto(empleados);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Atrás");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	/**
	 * Elige un puesto según la opción elegida.
	 * @return puesto elegido
	 */
	private Puesto getPuesto() {
		if (rdbtnDirector.isSelected())
			return Puesto.DIRECTOR;
		else if (rdbtnEmpleadoSala.isSelected())
			return Puesto.EMPLEADO_SALA;
		else if (rdbtnLimpiador.isSelected())
			return Puesto.LIMPIEZA;
		return null;
	}


	private void elegirPuesto(final ListaPersonas empleados) {
		Puesto puesto = getPuesto();
		if (puesto == null)
			JOptionPane.showMessageDialog(contentPanel, "Selecciona un puesto y pulsa OK.", "Error", JOptionPane.ERROR_MESSAGE);
		else{
			ArrayList<Persona> persona = empleados.getPuesto(puesto);
			if (persona.isEmpty()) {
				JOptionPane.showMessageDialog(contentPanel, "No existe ningún empleado con el puesto elegido.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			mostrarPorPuesto = new MostrarPorPuesto(persona);
			mostrarPorPuesto.setVisible(true);
		}
	}
}