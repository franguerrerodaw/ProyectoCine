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
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import personal.Puesto;
import personal.Uniforme;
/**
 * Clase padre donde se establecen los distintos campos respecto a los empleados.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class EmpleadosGUI extends JDialog {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * JPanel
	 */
	protected final JPanel contentPanel = new JPanel();
	
	/**
	 * Formato válido para recoger una fecha, día/mes/año.
	 */
	protected SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Etiqueta Nombre y Apellidos.
	 */
	protected JLabel lblNombreYApellidos;
	
	/**
	 * Campo Nombre y Apellidos.
	 */
	protected JTextField txfldNombreApellidos;
	
	/**
	 * Etiqueta sueldo.
	 */
	protected JLabel lblPrecioHora;
	
	/**
	 * Campo sueldo.
	 */
	protected JTextField txfldPrecioHora;
	
	/**
	 * Etiqueta DNI.
	 */
	protected JLabel lblDni;
	
	/**
	 * Campo DNI.
	 */
	protected JTextField txfldDni;
	
	/**
	 * Etiqueta Dirección.
	 */
	protected JLabel lblDireccion;
	
	/**
	 * Campo Dirección.
	 */
	protected JTextField txfldDireccion;
	
	/**
	 * Etiqueta Fecha de Nacimiento.
	 */
	protected JLabel lblFechaDeNacimiento;
	
	/**
	 * Campo Fecha de Nacimiento.
	 */
	protected JTextField txfldFechaNacimiento;
	
	/**
	 * Etiqueta Teléfono.
	 */
	protected JLabel lblTelfono;
	
	/**
	 * Campo Teléfono.
	 */
	protected JTextField txfldTelefono;
	
	/**
	 * Etiqueta Email.
	 */
	protected JLabel lblEmail;
	
	/**
	 * Campo Email.
	 */
	protected JTextField txfldEmail;
	
	/**
	 * Etiqueta Fecha de Alta.
	 */
	protected JLabel lblAlta;
	
	/**
	 * Campo Fecha de Alta.
	 */
	protected JTextField txfldAlta;
	
	/**
	 * Etiqueta Puesto.
	 */
	protected JLabel lblPuesto;
	
	/**
	 * ComboBox Puesto.
	 */
	protected JComboBox<Puesto> cmbxPuesto;
	
	/**
	 * Etiqueta Horas Semanales.
	 */
	protected JLabel lblNHorasSemanales;
	
	/**
	 * Campo Horas Semanales.
	 */
	protected JTextField txfldHorasSemanales;
	
	
	/**
	 * Etiqueta Titulación.
	 */
	protected JLabel lblTitulacion;
	
	/**
	 * Campo Titulación.
	 */
	protected JTextField txfldTitulacion;
	
	/**
	 * Etiiqueta Uniforme.
	 */
	protected JLabel lblUniforme;
	
	/**
	 * ComboBox Uniforme.
	 */
	protected JComboBox<Uniforme> cmbxUniforme;
	
	/**
	 * JPanel botones.
	 */
	protected JPanel buttonPane;
	
	/***
	 * Botón Anterior.
	 */
	protected JButton btnAnterior;
	
	/**
	 * Botón Siguiente.
	 */
	protected JButton btnSiguiente;
	
	/**
	 * Botón Ok.
	 */
	protected JButton okButton;
	
	/**
	 * Botón Cancelar.
	 */
	protected JButton cancelButton;
	

	/**
	 * Create the dialog.
	 */
	public EmpleadosGUI() {
		setResizable(false);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		formato.setLenient(false);
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
		
		txfldPrecioHora = new JTextField();
		txfldPrecioHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldPrecioHora.setBounds(33, 225, 155, 23);
		contentPanel.add(txfldPrecioHora);
		txfldPrecioHora.setColumns(10);
		
		lblPrecioHora = new JLabel("Precio Por Hora:");
		lblPrecioHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioHora.setBounds(33, 204, 101, 19);
		contentPanel.add(lblPrecioHora);
		
		txfldDni = new JTextField();
		txfldDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldDni.setBounds(410, 60, 155, 23);
		contentPanel.add(txfldDni);
		txfldDni.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(410, 39, 46, 23);
		contentPanel.add(lblDni);
		
		txfldDireccion = new JTextField();
		txfldDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldDireccion.setBounds(33, 118, 340, 23);
		contentPanel.add(txfldDireccion);
		txfldDireccion.setColumns(10);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(33, 97, 94, 23);
		contentPanel.add(lblDireccion);
		
		txfldFechaNacimiento = new JTextField();
		txfldFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldFechaNacimiento.setBounds(33, 172, 155, 23);
		contentPanel.add(txfldFechaNacimiento);
		txfldFechaNacimiento.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(33, 152, 131, 23);
		contentPanel.add(lblFechaDeNacimiento);
		
		txfldTelefono = new JTextField();
		txfldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldTelefono.setBounds(225, 172, 155, 23);
		contentPanel.add(txfldTelefono);
		txfldTelefono.setColumns(10);
		
		lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelfono.setBounds(225, 152, 84, 23);
		contentPanel.add(lblTelfono);
		
		txfldEmail = new JTextField();
		txfldEmail.setBounds(410, 118, 155, 23);
		contentPanel.add(txfldEmail);
		txfldEmail.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(410, 97, 46, 23);
		contentPanel.add(lblEmail);
		
		txfldAlta = new JTextField();
		txfldAlta.setBounds(410, 171, 155, 23);
		contentPanel.add(txfldAlta);
		txfldAlta.setColumns(10);
		
		lblAlta = new JLabel("Alta:");
		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlta.setBounds(410, 152, 46, 19);
		contentPanel.add(lblAlta);
		
		txfldHorasSemanales = new JTextField();
		txfldHorasSemanales.setBounds(410, 225, 155, 23);
		contentPanel.add(txfldHorasSemanales);
		txfldHorasSemanales.setColumns(10);
		
		lblNHorasSemanales = new JLabel("N\u00BA Horas Semanales:");
		lblNHorasSemanales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNHorasSemanales.setBounds(410, 204, 137, 23);
		contentPanel.add(lblNHorasSemanales);
		
		cmbxPuesto = new JComboBox<Puesto>();
		cmbxPuesto.setBounds(225, 225, 155, 23);
		contentPanel.add(cmbxPuesto);
		
		lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(225, 206, 60, 23);
		contentPanel.add(lblPuesto);
		
		txfldTitulacion = new JTextField();
		txfldTitulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldTitulacion.setBounds(33, 283, 155, 23);
		contentPanel.add(txfldTitulacion);
		txfldTitulacion.setColumns(10);
		
		lblTitulacion = new JLabel("Titulaci\u00F3n:");
		lblTitulacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulacion.setBounds(33, 266, 75, 19);
		contentPanel.add(lblTitulacion);
		
		cmbxUniforme = new JComboBox<Uniforme>();
		cmbxUniforme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbxUniforme.setBounds(225, 283, 155, 23);
		contentPanel.add(cmbxUniforme);
		
		lblUniforme = new JLabel("Uniforme:");
		lblUniforme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUniforme.setBounds(225, 266, 88, 19);
		contentPanel.add(lblUniforme);
		
		
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