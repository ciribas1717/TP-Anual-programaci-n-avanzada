package edu.usal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.usal.controller.MainController;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class MainView {

	private JFrame frame;
	private JButton btnNewButton;
	private JButton btnMenLneasAreas;
	private JButton btnMenVuelos;
	private JButton btnMenVentas;
	private JButton btnVolver;
	private MainController mainController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MainView window = new MainView();
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
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainController = new MainController (this);
		frame = new JFrame();
		frame.setBounds(700, 300, 350, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[10:10,shrink 0][10:10,shrink 0][10:10,shrink 0][240:240,shrink 0][10:10,shrink 0][10:10,shrink 0][10:10,shrink 0]", "[0][30:30,shrink 0][30:30,shrink 0][30:30,shrink 0][30:30,shrink 0][30:30,shrink 0][20:20,shrink 0][30:30,shrink 0]"));
		
		btnNewButton = new JButton("Menú clientes");
		btnNewButton.addActionListener(mainController);
		frame.getContentPane().add(btnNewButton, "cell 3 1,grow");
		
		btnMenLneasAreas = new JButton("Menú líneas aéreas");
		btnMenLneasAreas.addActionListener(mainController);
		frame.getContentPane().add(btnMenLneasAreas, "cell 3 2,grow");
		
		btnMenVuelos = new JButton("Menú vuelos");
		btnMenVuelos.addActionListener(mainController);
		frame.getContentPane().add(btnMenVuelos, "cell 3 3,grow");
		
		btnMenVentas = new JButton("Menú ventas");
		btnMenVentas.addActionListener(mainController);
		frame.getContentPane().add(btnMenVentas, "cell 3 4,grow");
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(mainController);
		btnVolver.setVisible(false);
		frame.getContentPane().add(btnVolver, "cell 3 6,grow");
	}
	
	public void cambiarTexto (int tipoMenu) {
		switch (tipoMenu) {
			case 1: btnNewButton.setText("Alta cliente");
		btnMenLneasAreas.setText("Baja cliente");
		btnMenVuelos.setText("Modificación cliente");
		btnMenVentas.setText("Consulta clientes");
		frame.setSize(350, 250);
		btnVolver.setVisible(true);
		break;
		
			case 2: btnNewButton.setText("Alta línea aérea");
		btnMenLneasAreas.setText("Baja línea aérea");
		btnMenVuelos.setText("Modificación línea aérea");
		btnMenVentas.setText("Consulta líneas aéreas");
		frame.setSize(350, 250);
		btnVolver.setVisible(true);
		break;
		
			case 3: btnNewButton.setText("Alta vuelo");
		btnMenLneasAreas.setText("Baja vuelo");
		btnMenVuelos.setText("Modificación vuelo");
		btnMenVentas.setText("Consulta vuelos");
		frame.setSize(350, 250);
		btnVolver.setVisible(true);
		break;
		
			case 4: btnNewButton.setText("Alta venta");
		btnMenLneasAreas.setText("Baja venta");
		btnMenVuelos.setText("Modificación venta");
		btnMenVentas.setText("Consulta ventas");
		frame.setSize(350, 250);
		btnVolver.setVisible(true);
		break;
		
			case 5: btnNewButton.setText("Menú clientes");
		btnMenLneasAreas.setText("Menú líneas aéreas");
		btnMenVuelos.setText("Menú vuelos");
		btnMenVentas.setText("Menú ventas");
		frame.setSize(350, 200);
		btnVolver.setVisible(false);
		}
	}

}
