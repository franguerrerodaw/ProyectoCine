package entornoGrafico;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Ayuda y manual de usuario del programa.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * JPanel ayuda
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Scroll para el JEditorPane
	 */
	private JScrollPane scrollPane;
	
	/**
	 * JEditorPane
	 */
	private JEditorPane edtpnl;
	

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setModal(true);
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		edtpnl = new JEditorPane();
		edtpnl.setEditable(false);
		
		scrollPane.setViewportView(edtpnl);
		edtpnl.setContentType("text/html");
		edtpnl.setText("<html>\r\n<head></head>\r\n<body>\r\n\t<h1>Ayuda</h1>\r\n\t<h2>Administraci\u00F3n de las pel\u00EDculas y personal de un cine.</h2>\r\n\r\n\t<h3>Men\u00FA Archivo</h3>\r\n\t<ul>\r\n\t\t<li type=\"square\">Nuevo: crea un nuevo fichero</li>\r\n\t\t<li type=\"square\">Abrir: abre un nuevo fichero.</li>\r\n\t\t<li type=\"square\">Guardar: guarda un fichero si existe, si no se abre el JFileChooser.</li>\r\n\t\t<li type=\"square\">Abrir Como: guarda un fichero por primera vez.</li>\r\n\t</ul>\r\n\r\n\t<h3>Men\u00FA Pel\u00EDculas</h3>\r\n\t<ul>\r\n\t\t<li type=\"square\">A\u00F1adir: a\u00F1ade una nueva pel\u00EDcula. No pueden existir dos pel\u00EDculasa con el mismo t\u00EDtulo.</li>\r\n\t\t<li type=\"square\">Eliminar: elimina una pel\u00EDcula existente. Se elimina a trav\u00E9s del t\u00EDtulo de la pel\u00EDcula.</li>\r\n\t\t<li type=\"square\">Mostrar: muestra toda la cartelera.</li>\r\n\t</ul>\r\n\r\n\t<h3>Men\u00FA Empleados</h3>\r\n\t<ul>\r\n\t\t<li type=\"square\">A\u00F1adir: a\u00F1ade un nuevo empleado. No pueden existir dos empleados con el mismo DNI.</li>\r\n\t\t<li type=\"square\">Eliminar: elimina un empleado existente. Se elimina a trav\u00E9s del DNI del empleado.</li>\r\n\t\t<li type=\"square\">Mostrar: muestra todos los empleados.</li>\r\n\t\t<li type=\"square\">Buscar: busca a un solo empleado a trav\u00E9s del DNI.</li>\r\n\t\t<li type=\"square\">Buscar por Puesto: busca a todos los empleados del mismo puesto.</li>\r\n\t</ul>\r\n\r\n\t<h3>Men\u00FA Funcionalidades</h3>\r\n\t<ul>\r\n\t\t<li type=\"square\">Asignar Turno: asigna un turno de trabajo a los empleados de sala ya creados.</li>\r\n\t\t<li type=\"square\">Asignar Zona de Limpieza: asigna una zona de limpieza a los limpiadores ya creados.</li>\r\n\t\t<li type=\"square\">Ver Salarios: muestra todos los salarios y el plus de antig\u00FCedad de todos los trabajadores.</li>\r\n\t\t<li type=\"square\">Comparar Sueldos: compara dos sueldos de dos empleados distintos.</li>\r\n\t</ul>\r\n</body>\r\n</html>");
		edtpnl.setCaretPosition(0);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
