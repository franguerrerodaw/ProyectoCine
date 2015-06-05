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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import peliculas.Formato;
import peliculas.Genero;
/**
 * Clase padre de los elementos para agregar una película
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class PeliculasGUI extends JDialog {

	/**
	 * Serial UID
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
	 * Etiqueta título
	 */
	protected JLabel lblTitulo;
	
	/**
	 * Campo título
	 */
	protected JTextField txfldTitulo;
	
	/*
	 * Etiqueta género
	 */
	protected JLabel lblGenero;
	
	/**
	 * ComboBox género
	 */
	protected JComboBox<Genero> cmbxGenero;
	
	/**
	 * Etiqueta formato
	 */
	protected JLabel lblFormato;
	
	/**
	 * ComoBox formato
	 */
	protected JComboBox<Formato> cmbxFormato;
	
	/**
	 * Etiqueta fecha estreno
	 */
	protected JLabel lblfechaEstreno;
	
	/**
	 * Campo fecha estreno
	 */
	protected JTextField txfldFechaEstreno;
	
	/**
	 * Etiqueta duración
	 */
	protected JLabel lblDuracion;
	
	/**
	 * Campo duración
	 */
	protected JTextField txfldDuracion;
	
	/**
	 * Etiqueta sinopsis
	 */
	protected JLabel lblSinopsis;
	
	/**
	 * JTextArea Sinopsis
	 */
	protected JTextArea txtArSinopsis;
	
	/**
	 * Button Panel
	 */
	protected JPanel buttonPane;
	
	/**
	 * Botón anterior
	 */
	protected JButton btnAnterior;
	
	/**
	 * botón siguiente
	 */
	protected JButton btnSiguiente;
	
	/**
	 * botón ok
	 */
	protected JButton okButton;
	
	/**
	 * botón cancelar
	 */
	protected JButton cancelButton;
	
	/**
	 * ScrollPane
	 */
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public PeliculasGUI() {
		setResizable(false);
		setBounds(100, 100, 450, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txfldTitulo = new JTextField();
		txfldTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldTitulo.setBounds(58, 31, 313, 23);
		contentPanel.add(txfldTitulo);
		txfldTitulo.setColumns(10);
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(58, 11, 87, 20);
		contentPanel.add(lblTitulo);
		
		cmbxGenero = new JComboBox<Genero>();
		cmbxGenero.setBounds(58, 83, 130, 23);
		contentPanel.add(cmbxGenero);
		
		lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenero.setBounds(58, 62, 69, 20);
		contentPanel.add(lblGenero);
		
		cmbxFormato = new JComboBox<Formato>();
		cmbxFormato.setBounds(241, 83, 130, 23);
		contentPanel.add(cmbxFormato);
		
		lblFormato = new JLabel("Formato:");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormato.setBounds(241, 62, 69, 20);
		contentPanel.add(lblFormato);
		
		txfldFechaEstreno = new JTextField();
		txfldFechaEstreno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txfldFechaEstreno.setBounds(242, 133, 129, 23);
		contentPanel.add(txfldFechaEstreno);
		formato.setLenient(false); //corrige las fechas inválidas, evita que sume días.
		txfldFechaEstreno.setColumns(10);
		
		lblfechaEstreno = new JLabel("Fecha Estreno:");
		lblfechaEstreno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblfechaEstreno.setBounds(60, 113, 99, 20);
		contentPanel.add(lblfechaEstreno);
		
		txfldDuracion = new JTextField();
		txfldDuracion.setBounds(58, 134, 130, 23);
		contentPanel.add(txfldDuracion);
		txfldDuracion.setColumns(10);
		
		lblDuracion = new JLabel("Duración:");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuracion.setBounds(241, 113, 69, 20);
		contentPanel.add(lblDuracion);
		
		lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinopsis.setBounds(60, 168, 69, 20);
		contentPanel.add(lblSinopsis);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 190, 313, 107);
		contentPanel.add(scrollPane);
		
		txtArSinopsis = new JTextArea();
		scrollPane.setViewportView(txtArSinopsis);
		txtArSinopsis.setLineWrap(true);
		txtArSinopsis.setWrapStyleWord(true);
		
		
		
		
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
