package entornoGrafico;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
/**
 * Descripción del autor del programa
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class AcercaDe extends JDialog {

	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * JPanel ayuda
	 */
	private final JPanel contentPanel = new JPanel();
	
	
	/**
	 * Create the panel.
	 */
	public AcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de...");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JEditorPane dtrpnAdministracinDeCine = new JEditorPane();
		dtrpnAdministracinDeCine.setEditable(false);
		dtrpnAdministracinDeCine.setText("Administración de Cine. Versión 1.0\r\n\r\nAutor: Francisco Javier Guerrero Molina.");
		dtrpnAdministracinDeCine.setBounds(10, 11, 414, 206);
		contentPanel.add(dtrpnAdministracinDeCine);
		
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
