package entornoGrafico;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import personal.Puesto;
import personal.Turno;
import personal.Zona;
/**
 * Clase padre de los elementos para añadir funcionalidades.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class FuncionalidadesGUI extends JDialog {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JLabel lblNombreYApellidos;
	protected JTextField txfldNombreApellidos;
	protected JLabel lblDni;
	protected JTextField txfldDni;
	protected JLabel lblPuesto;
	protected JComboBox<Puesto> cmbxPuesto;
	protected JLabel lblTurno;
	protected JComboBox<Turno> cmbxTurno;
	protected JLabel lblZona;
	protected JComboBox<Zona> cmbxZona;
	protected JLabel lblSueldo;
	protected JTextField txfldSueldo;
	protected JLabel lblAntiguedad;
	protected JTextField txfldAntiguedad;
	protected JPanel buttonPane;
	protected JButton btnAnterior;
	protected JButton btnSiguiente;
	protected JButton btnCambiar;
	protected JButton btnGuardar;
	protected JButton btnComparar;
	protected JButton okButton;
	protected JButton cancelButton;
	

	/**
	 * Create the dialog.
	 */
	public FuncionalidadesGUI() {
		setResizable(false);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txfldNombreApellidos = new JTextField();
			txfldNombreApellidos.setEditable(false);
			txfldNombreApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txfldNombreApellidos.setBounds(33, 63, 340, 23);
			contentPanel.add(txfldNombreApellidos);
			txfldNombreApellidos.setColumns(10);
		}
		
		lblNombreYApellidos = new JLabel("Nombre y Apellidos:");
		lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreYApellidos.setBounds(33, 43, 120, 19);
		contentPanel.add(lblNombreYApellidos);
		
		txfldDni = new JTextField();
		txfldDni.setEditable(false);
		txfldDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldDni.setBounds(410, 60, 155, 23);
		contentPanel.add(txfldDni);
		txfldDni.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(410, 39, 46, 23);
		contentPanel.add(lblDni);
		
		cmbxPuesto = new JComboBox<Puesto>();
		cmbxPuesto.setBounds(225, 224, 155, 23);
		contentPanel.add(cmbxPuesto);
		
		lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(225, 205, 60, 23);
		contentPanel.add(lblPuesto);
		
		cmbxZona = new JComboBox<Zona>();
		cmbxZona.setBounds(225, 284, 155, 23);
		contentPanel.add(cmbxZona);
		
		lblZona = new JLabel("Zona:");
		lblZona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZona.setBounds(225, 266, 60, 19);
		contentPanel.add(lblZona);
		
		
		lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurno.setBounds(225, 266, 60, 19);
		contentPanel.add(lblTurno);
		
		cmbxTurno = new JComboBox<Turno>();
		cmbxTurno.setBounds(225, 285, 155, 20);
		contentPanel.add(cmbxTurno);
		
		lblSueldo = new JLabel("Sueldo Base:");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSueldo.setBounds(105, 144, 85, 19);
		contentPanel.add(lblSueldo);
		
		txfldSueldo = new JTextField();
		txfldSueldo.setEditable(false);
		txfldSueldo.setBounds(105, 162, 130, 23);
		contentPanel.add(txfldSueldo);
		txfldSueldo.setColumns(10);
		
		lblAntiguedad = new JLabel("Plus Antig\u00FCedad:");
		lblAntiguedad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAntiguedad.setBounds(347, 144, 109, 19);
		contentPanel.add(lblAntiguedad);
		
		txfldAntiguedad = new JTextField();
		txfldAntiguedad.setEditable(false);
		txfldAntiguedad.setBounds(347, 162, 129, 23);
		contentPanel.add(txfldAntiguedad);
		txfldAntiguedad.setColumns(10);
		
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnComparar = new JButton("Comparar");
			buttonPane.add(btnComparar);
			
			btnAnterior = new JButton("< Anterior");
			buttonPane.add(btnAnterior);
			
			btnSiguiente = new JButton("Siguiente >");
			buttonPane.add(btnSiguiente);
			
			btnGuardar = new JButton("Guardar");
			buttonPane.add(btnGuardar);
			
			btnCambiar = new JButton("Cambiar");
			buttonPane.add(btnCambiar);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Atrás");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}