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
//	protected SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	protected JLabel lblNombreYApellidos;
	protected JTextField txfldNombreApellidos;
	protected JLabel lblDni;
	protected JTextField txfldDni;
//	protected JLabel lblSueldo;
//	protected JTextField txfldSueldo;
//	protected JLabel lblDireccion;
//	protected JTextField txfldDireccion;
//	protected JLabel lblFechaDeNacimiento;
//	protected JTextField txfldFechaNacimiento;
//	protected JLabel lblTelfono;
//	protected JTextField txfldTelefono;
//	protected JLabel lblEmail;
//	protected JTextField txfldEmail;
//	protected JLabel lblAlta;
//	protected JTextField txfldAlta;
	protected JLabel lblPuesto;
	protected JComboBox<Puesto> cmbxPuesto;
//	protected JLabel lblNHorasSemanales;
//	protected JTextField txfldHorasSemanales;
//	protected JLabel lblTitulacion;
//	protected JTextField txfldTitulacion;
//	protected JLabel lblUniforme;
//	protected JComboBox<Uniforme> cmbxUniforme;
//	protected JLabel lblFondoMensual;
//	protected JTextField txfldFondoMensual;
	protected JLabel lblTurno;
	protected JComboBox<Turno> cmbxTurno;
	protected JLabel lblZona;
	protected JComboBox<Zona> cmbxZona;
	protected JPanel buttonPane;
	protected JButton btnAnterior;
	protected JButton btnSiguiente;
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
		//formato.setLenient(false);
		{
			txfldNombreApellidos = new JTextField();
			txfldNombreApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txfldNombreApellidos.setBounds(33, 63, 340, 23);
			contentPanel.add(txfldNombreApellidos);
			txfldNombreApellidos.setColumns(10);
		}
		
		lblNombreYApellidos = new JLabel("Nombre y Apellidos:");
		lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreYApellidos.setBounds(33, 39, 120, 23);
		contentPanel.add(lblNombreYApellidos);
		
//		txfldSueldo = new JTextField();
//		txfldSueldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldSueldo.setBounds(33, 225, 155, 23);
//		contentPanel.add(txfldSueldo);
//		txfldSueldo.setColumns(10);
//		
//		lblSueldo = new JLabel("Sueldo Base:");
//		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblSueldo.setBounds(33, 204, 101, 19);
//		contentPanel.add(lblSueldo);
		
		txfldDni = new JTextField();
		txfldDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldDni.setBounds(410, 60, 155, 23);
		contentPanel.add(txfldDni);
		txfldDni.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(410, 39, 46, 23);
		contentPanel.add(lblDni);
		
//		txfldDireccion = new JTextField();
//		txfldDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldDireccion.setBounds(33, 118, 340, 23);
//		contentPanel.add(txfldDireccion);
//		txfldDireccion.setColumns(10);
//		
//		lblDireccion = new JLabel("Dirección:");
//		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblDireccion.setBounds(33, 97, 94, 23);
//		contentPanel.add(lblDireccion);
//		
//		txfldFechaNacimiento = new JTextField();
//		txfldFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldFechaNacimiento.setBounds(33, 172, 155, 23);
//		contentPanel.add(txfldFechaNacimiento);
//		txfldFechaNacimiento.setColumns(10);
//		
//		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
//		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblFechaDeNacimiento.setBounds(33, 152, 131, 23);
//		contentPanel.add(lblFechaDeNacimiento);
//		
//		txfldTelefono = new JTextField();
//		txfldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldTelefono.setBounds(225, 172, 155, 23);
//		contentPanel.add(txfldTelefono);
//		txfldTelefono.setColumns(10);
//		
//		lblTelfono = new JLabel("Tel\u00E9fono:");
//		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTelfono.setBounds(225, 152, 84, 23);
//		contentPanel.add(lblTelfono);
//		
//		txfldEmail = new JTextField();
//		txfldEmail.setBounds(410, 118, 155, 23);
//		contentPanel.add(txfldEmail);
//		txfldEmail.setColumns(10);
//		
//		lblEmail = new JLabel("Email:");
//		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblEmail.setBounds(410, 97, 46, 23);
//		contentPanel.add(lblEmail);
//		
//		txfldAlta = new JTextField();
//		txfldAlta.setBounds(410, 171, 155, 23);
//		contentPanel.add(txfldAlta);
//		txfldAlta.setColumns(10);
//		
//		lblAlta = new JLabel("Alta:");
//		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblAlta.setBounds(410, 152, 46, 19);
//		contentPanel.add(lblAlta);
//		
//		txfldHorasSemanales = new JTextField();
//		txfldHorasSemanales.setBounds(410, 225, 155, 23);
//		contentPanel.add(txfldHorasSemanales);
//		txfldHorasSemanales.setColumns(10);
//		
//		lblNHorasSemanales = new JLabel("N\u00BA Horas Semanales:");
//		lblNHorasSemanales.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblNHorasSemanales.setBounds(410, 204, 137, 23);
//		contentPanel.add(lblNHorasSemanales);
		
		cmbxPuesto = new JComboBox<Puesto>();
		cmbxPuesto.setBounds(225, 224, 155, 23);
		contentPanel.add(cmbxPuesto);
		
		lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(225, 205, 60, 23);
		contentPanel.add(lblPuesto);
		
//		txfldTitulacion = new JTextField();
//		txfldTitulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldTitulacion.setBounds(33, 283, 155, 23);
//		contentPanel.add(txfldTitulacion);
//		txfldTitulacion.setColumns(10);
//		
//		lblTitulacion = new JLabel("Titulaci\u00F3n:");
//		lblTitulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTitulacion.setBounds(33, 266, 75, 19);
//		contentPanel.add(lblTitulacion);
//		
//		cmbxUniforme = new JComboBox<Uniforme>();
//		cmbxUniforme.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		cmbxUniforme.setBounds(225, 283, 155, 23);
//		contentPanel.add(cmbxUniforme);
//		
//		lblUniforme = new JLabel("Uniforme:");
//		lblUniforme.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblUniforme.setBounds(225, 266, 88, 19);
//		contentPanel.add(lblUniforme);
//		
//		txfldFondoMensual = new JTextField();
//		txfldFondoMensual.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txfldFondoMensual.setBounds(410, 283, 155, 23);
//		contentPanel.add(txfldFondoMensual);
//		txfldFondoMensual.setColumns(10);
//		
//		lblFondoMensual = new JLabel("Fondo Mensual:");
//		lblFondoMensual.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblFondoMensual.setBounds(410, 262, 94, 23);
//		contentPanel.add(lblFondoMensual);
		
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
		
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnAnterior = new JButton("< Anterior");
			buttonPane.add(btnAnterior);
			
			btnSiguiente = new JButton("Siguiente >");
			buttonPane.add(btnSiguiente);
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