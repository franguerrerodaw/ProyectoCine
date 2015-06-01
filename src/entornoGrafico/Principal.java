package entornoGrafico;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JSeparator;
import peliculas.ListaPeliculas;
import personal.ListaPersonas;
import personal.Persona;
import personal.Puesto;
import utiles.Gestion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * Clase principal del programa.
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class Principal {

	/**
	 * Jframe
	 */
	protected JFrame frame;
	
	/**
	 * JPanel content Panel
	 */
	protected final JPanel contentPanel = new JPanel();
	
	/**
	 * Instancia de la clase ListaPeliculas
	 */
	public static ListaPeliculas cartelera = new ListaPeliculas();
	
	/**
	 * Instancia de la clase ListaPersonas
	 */
	public static ListaPersonas empleados = new ListaPersonas();
	
	/**
	 * Objeto de la clase AgregarPelicula
	 */
	protected AgregarPelicula agregarPelicula;
	
	/**
	 * Objeto de la clase EliminarPelicula
	 */
	protected EliminarPelicula eliminarPelicula;
	
	/**
	 * Objeto de la clase MostrarCartelera
	 */
	protected MostrarCartelera mostrarCartelera;
	
	/**
	 * Objeto de la clase AgregarEmpleado
	 */
	protected AgregarEmpleado agregarEmpleado;
	
	/**
	 * Objeto de la clase EliminarEmpleado
	 */
	protected EliminarEmpleado eliminarEmpleado;
	
	/**
	 * Objeto de la clase MostrarEmpleado
	 */
	protected MostrarEmpleados mostrarEmpleados;
	
	/**
	 * Objeto de la clase BuscarEmpleado
	 */
	protected BuscarEmpleado buscarEmpleado;
	
	/**
	 * Objeto de la clase ElegirPuesto
	 */
	protected ElegirPuesto elegirPuesto;
	
	/**
	 * Objeto de la clase AsignarTurno
	 */
	protected AsignarTurno asignarTurno;
	
	/**
	 * Objeto de la clase AsignarZonaLimpieza
	 */
	protected AsignarZonaLimpieza asignarZonaLimpieza;
	
	/**
	 * Objeto de la clase Ayuda
	 */
	protected Ayuda ayuda;
	
	/**
	 * Objeto de la clase AcercaDe
	 */
	protected AcercaDe acercaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		Gestion.getTitle(frame);
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		frame.getContentPane().add(menuBar);
		
		
		/** ***************** Menú Archivo ******************  */
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.nuevo(frame, contentPanel, cartelera);
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.abrir(frame, contentPanel, cartelera);
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardar(frame, cartelera);
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardarComo(cartelera);
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnArchivo.add(mntmSalir);
		
		
		/** ***************** Menú Películas ******************  */
		
		JMenu mnPelculas = new JMenu("Películas");
		menuBar.add(mnPelculas);
		
		JMenuItem mntmNuevaPelcula = new JMenuItem("A\u00F1adir");
		mntmNuevaPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarPelicula = new AgregarPelicula(cartelera);
				agregarPelicula.setVisible(true);
			}
		});
		mnPelculas.add(mntmNuevaPelcula);
		
		JMenuItem mntmEliminarPelcula = new JMenuItem("Eliminar");
		mntmEliminarPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cartelera.size() == 0) {
					JOptionPane.showMessageDialog(contentPanel, "No hay películas en la cartelera.");
				} else {
					eliminarPelicula = new EliminarPelicula(cartelera);
					eliminarPelicula.setVisible(true);
				}
			}
		});
		mnPelculas.add(mntmEliminarPelcula);
		
		JMenuItem mntmMostrarCartelera = new JMenuItem("Mostrar");
		mntmMostrarCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cartelera.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No hay películas en la cartelera.");
				} else {
					mostrarCartelera = new MostrarCartelera(cartelera);
					mostrarCartelera.setVisible(true);
				}
			}
		});
		mnPelculas.add(mntmMostrarCartelera);
		
		
		/** ***************** Menú Empleados ******************  */
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setMnemonic('E');
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAgregarEmpleado = new JMenuItem("A\u00F1adir");
		mntmAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarEmpleado = new AgregarEmpleado(empleados);
				agregarEmpleado.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmAgregarEmpleado);
		
		JMenuItem mntmEliminarEmpleado = new JMenuItem("Eliminar");
		mntmEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					eliminarEmpleado = new EliminarEmpleado(empleados);
					eliminarEmpleado.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmEliminarEmpleado);
		
		JMenuItem mntmMostrarEmpleados = new JMenuItem("Mostrar");
		mntmMostrarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					mostrarEmpleados = new MostrarEmpleados(empleados);
					mostrarEmpleados.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmMostrarEmpleados);
		
		JMenuItem mntmBuscarEmpleados = new JMenuItem("Buscar");
		mntmBuscarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					buscarEmpleado = new BuscarEmpleado(empleados);
					buscarEmpleado.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmBuscarEmpleados);
		
		JMenuItem mntmBuscarPorPuesto = new JMenuItem("Buscar por Puesto");
		mntmBuscarPorPuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					elegirPuesto = new ElegirPuesto(empleados);
					elegirPuesto.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmBuscarPorPuesto);
		
		
		/** ***************** Menú Funcionalidades ******************  */
		
		
		JMenu mnFuncionalidades = new JMenu("Funcionalidades");
		menuBar.add(mnFuncionalidades);
		
		JMenuItem mntmAsignarTurno = new JMenuItem("Asignar Turno");
		mntmAsignarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Puesto puesto = Puesto.EMPLEADO_SALA;
				ArrayList<Persona> persona = empleados.getPuesto(puesto);
				if (persona.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "No existe ningún empleado de sala para asignarle un turno.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				asignarTurno = new AsignarTurno(persona);
				asignarTurno.setVisible(true);
			}
		});
		mnFuncionalidades.add(mntmAsignarTurno);
		
		JMenuItem mntmAsignarZonaLimpieza = new JMenuItem("Asignar Zona de Limpieza");
		mntmAsignarZonaLimpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Puesto puesto = Puesto.LIMPIEZA;
				ArrayList<Persona> persona = empleados.getPuesto(puesto);
				if (persona.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "No existe ningún limpiador para asignarle una zona de limpieza.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				asignarZonaLimpieza = new AsignarZonaLimpieza(persona);
				asignarZonaLimpieza.setVisible(true);
			}
		});
		mnFuncionalidades.add(mntmAsignarZonaLimpieza);
		
		
		
		/** ***************** Menú Ayuda ******************  */
		
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		
		
		/** ***************** Cerrar Aspa ******************  */
		
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent e) {
					if (Gestion.getModificado()){
						int confirm = JOptionPane.showOptionDialog(null, "La administración del cine ha sido modificada. \n¿Desea guardar los cambios?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (confirm == 0)
							Gestion.guardarComo(cartelera);
						if (confirm == 1)
							System.exit(0);
						else
							return;
					}
					System.exit(0);
				}
		};
		frame.addWindowListener(exitListener);
		
		
	}
}
