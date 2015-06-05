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
				Gestion.nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.salir();
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);
		
		
		/** ***************** Menú Películas ******************  */
		
		JMenu mnPelculas = new JMenu("Películas");
		menuBar.add(mnPelculas);
		
		JMenuItem mntmNuevaPelcula = new JMenuItem("A\u00F1adir");
		mntmNuevaPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPelicula agregarPelicula = new AgregarPelicula(Gestion.cartelera);
				agregarPelicula.setVisible(true);
			}
		});
		mnPelculas.add(mntmNuevaPelcula);
		
		JMenuItem mntmEliminarPelcula = new JMenuItem("Eliminar");
		mntmEliminarPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.cartelera.size() == 0) {
					JOptionPane.showMessageDialog(contentPanel, "No hay películas en la cartelera.");
				} else {
					EliminarPelicula eliminarPelicula = new EliminarPelicula(Gestion.cartelera);
					eliminarPelicula.setVisible(true);
				}
			}
		});
		mnPelculas.add(mntmEliminarPelcula);
		
		JMenuItem mntmMostrarCartelera = new JMenuItem("Mostrar");
		mntmMostrarCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.cartelera.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No hay películas en la cartelera.");
				} else {
					MostrarCartelera mostrarCartelera = new MostrarCartelera(Gestion.cartelera);
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
				AgregarEmpleado agregarEmpleado = new AgregarEmpleado(Gestion.empleados);
				agregarEmpleado.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmAgregarEmpleado);
		
		JMenuItem mntmEliminarEmpleado = new JMenuItem("Eliminar");
		mntmEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					EliminarEmpleado eliminarEmpleado = new EliminarEmpleado(Gestion.empleados);
					eliminarEmpleado.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmEliminarEmpleado);
		
		JMenuItem mntmMostrarEmpleados = new JMenuItem("Mostrar");
		mntmMostrarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					MostrarEmpleados mostrarEmpleados = new MostrarEmpleados(Gestion.empleados);
					mostrarEmpleados.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmMostrarEmpleados);
		
		JMenuItem mntmBuscarEmpleados = new JMenuItem("Buscar");
		mntmBuscarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					BuscarEmpleado buscarEmpleado = new BuscarEmpleado(Gestion.empleados);
					buscarEmpleado.setVisible(true);
				}
			}
		});
		mnEmpleados.add(mntmBuscarEmpleados);
		
		JMenuItem mntmBuscarPorPuesto = new JMenuItem("Buscar por Puesto");
		mntmBuscarPorPuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					ElegirPuesto elegirPuesto = new ElegirPuesto(Gestion.empleados);
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
				agregarEmpleadoSala();
			}
		});
		mnFuncionalidades.add(mntmAsignarTurno);
		
		JMenuItem mntmAsignarZonaLimpieza = new JMenuItem("Asignar Zona de Limpieza");
		mntmAsignarZonaLimpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Puesto puesto = Puesto.LIMPIEZA;
				ArrayList<Persona> persona = Gestion.empleados.getPuesto(puesto);
				if (persona.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "No existe ningún limpiador para asignarle una zona de limpieza.");
					return;
				}
				AsignarZonaLimpieza asignarZonaLimpieza = new AsignarZonaLimpieza(persona);
				asignarZonaLimpieza.setVisible(true);
			}
		});
		mnFuncionalidades.add(mntmAsignarZonaLimpieza);
		
		JMenuItem mntmVerSalarios = new JMenuItem("Ver Salarios");
		mntmVerSalarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() == 0){
					JOptionPane.showMessageDialog(contentPanel, "No existen empleados.");
				} else {
					VerSalarios verSalarios = new VerSalarios(Gestion.empleados);
					verSalarios.setVisible(true);
				}
			}
		});
		mnFuncionalidades.add(mntmVerSalarios);
		
		JMenuItem mntmCompararSueldos = new JMenuItem("Comparar Sueldos");
		mntmCompararSueldos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Gestion.empleados.size() < 2){
					JOptionPane.showMessageDialog(contentPanel, "No existen como mínimo 2 empleados para comparar su sueldo.");
				} else {
					CompararSueldos compararSueldos = new CompararSueldos(Gestion.empleados);
					compararSueldos.setVisible(true);
				}
			}
		});
		mnFuncionalidades.add(mntmCompararSueldos);
		
		
		
		/** ***************** Menú Ayuda ******************  */
		
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		
		
		/** ***************** Cerrar Aspa ******************  */
		
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			@Override
				public void windowClosing(WindowEvent e) {
					Gestion.salir();
				}
		};
		frame.addWindowListener(exitListener);
		
		
	}

	private void agregarEmpleadoSala() {
		if (Gestion.empleados.getPuesto(Puesto.EMPLEADO_SALA).isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "No existe ningún empleado de sala para asignarle un turno.");
			return;
		}
		AsignarTurno asignarTurno = new AsignarTurno(Gestion.empleados);
		asignarTurno.setVisible(true);
	}
}
