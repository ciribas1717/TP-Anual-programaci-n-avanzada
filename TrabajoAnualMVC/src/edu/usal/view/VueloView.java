package edu.usal.view;



import javax.swing.JDialog;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import edu.usal.controller.LineaAereaController;
import edu.usal.controller.VueloController;
import edu.usal.dto.AeropuertoDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.VueloDTO;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VueloView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numeroDeVuelo;
	private JTextField cantAsientos;
	private JTextField fecSalida;
	private JTextField fecLlegada;
	private JTextField codigoAeropuertoSalida;
	private JTextField codigoAeropuertoLlegada;
	private JTextField tiempoDeVuelo;
	private JLabel lblNumeroDeVuelo;
	private JLabel lblCantAsientos;
	private JLabel lblFecSalida;
	private JLabel lblFechaDeLlegada;
	private JLabel lblNombreAeropuertoSalida;
	private JLabel lblNombreAeropuertoLlegada;
	private JLabel lblTiempoDeVuelo;
	private JLabel lblAerolnea;
	private JComboBox <String> aerolinea;
	private JButton btnAlta;
	private JButton btnBajaModificacin;
	private JButton btnVolver;
	private static String[] a;
	private static VueloController vueloController;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	private static int IDVueloAModificar;
	private static int verificar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			a = args;
			VueloView dialog = new VueloView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public VueloView(int a) {
		
	}
	
	public VueloView() {
		setBounds(700, 300, 385, 360);
		setResizable(false);
		setModal(true);
		vueloController = new VueloController (this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 379, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 331, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		String [] columnas = {"ID", "Número de vuelo", "Cantidad de asientos", "Fecha de salida", "Fecha de llegada", "Tiempo de vuelo", "Código de aeropuerto de salida", "Código de aeropuerto de llegada", "Nombre de línea aérea"};
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setPreferredWidth(200);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lblNumeroDeVuelo = new JLabel("Número de vuelo:");
		
		numeroDeVuelo = new JTextField();
		numeroDeVuelo.setColumns(10);
		
		lblCantAsientos = new JLabel("Cantidad de asientos:");
		
		cantAsientos = new JTextField();
		cantAsientos.setColumns(10);
		
		lblFecSalida = new JLabel("Fecha de salida (dd/MM/yyyy HH:mm):");
		
		fecSalida = new JTextField();
		fecSalida.setColumns(10);
		
		lblFechaDeLlegada = new JLabel("Fecha de llegada (dd/MM/yyyy HH:mm):");
		
		fecLlegada = new JTextField();
		fecLlegada.setColumns(10);
		
		lblNombreAeropuertoSalida = new JLabel("Código de aeropuerto de salida:");
		
		codigoAeropuertoSalida = new JTextField();
		codigoAeropuertoSalida.setColumns(10);
		
		lblNombreAeropuertoLlegada = new JLabel("Código de aeropuerto de llegada:");
		
		codigoAeropuertoLlegada = new JTextField();
		codigoAeropuertoLlegada.setColumns(10);
		
		lblAerolnea = new JLabel("Aerolínea:");
		
		aerolinea = new JComboBox<String>();
		cargarAerolineas();
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(vueloController);
		
		lblTiempoDeVuelo = new JLabel("Tiempo de vuelo:");
		
		tiempoDeVuelo = new JTextField();
		tiempoDeVuelo.setColumns(10);
		
		btnBajaModificacin = new JButton("Baja");
		btnBajaModificacin.addActionListener(vueloController);
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(vueloController);
		
		if (a[0].equals("0")) {
			mostrarAlta();
		} else {
			mostrarTabla();
		}

	}
	
	public void mostrarAlta() {
		aerolinea.setVisible(true);
		setBounds(700, 300, 385, 360);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaDeLlegada)
								.addComponent(lblFecSalida)
								.addComponent(lblCantAsientos)
								.addComponent(lblNumeroDeVuelo)
								.addComponent(lblTiempoDeVuelo)
								.addComponent(lblNombreAeropuertoSalida)
								.addComponent(lblNombreAeropuertoLlegada)
								.addComponent(lblAerolnea))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fecLlegada, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(aerolinea, 0, 158, Short.MAX_VALUE)
								.addComponent(codigoAeropuertoLlegada, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(codigoAeropuertoSalida, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addComponent(tiempoDeVuelo, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
								.addComponent(fecSalida, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(numeroDeVuelo, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(cantAsientos, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
							.addContainerGap(37, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnAlta)
							.addGap(157))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(numeroDeVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumeroDeVuelo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cantAsientos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantAsientos))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fecSalida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecSalida))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeLlegada)
						.addComponent(fecLlegada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoDeVuelo)
						.addComponent(tiempoDeVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreAeropuertoSalida)
						.addComponent(codigoAeropuertoSalida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreAeropuertoLlegada)
						.addComponent(codigoAeropuertoLlegada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAerolnea)
						.addComponent(aerolinea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAlta)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		numeroDeVuelo.requestFocusInWindow();
	}
	
	public void mostrarTabla() {
		aerolinea.setVisible(false);
		setBounds(700, 300, 900, 372);
		actualizarTabla();
		int espacio = 0;
		if (a[0].equals("3")) {
			espacio = 200;
			btnBajaModificacin.setVisible(false);
		} else if (a[0].equals("1")) {
			btnBajaModificacin.setVisible(true);
			btnBajaModificacin.setText("Baja");
			espacio = 72;
		} else if (a[0].equals("2")) {
			btnBajaModificacin.setVisible(true);
			btnBajaModificacin.setText("Modificación");
			espacio = 72;
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addComponent(btnBajaModificacin)
					.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addGap(espacio))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBajaModificacin)
						.addComponent(btnVolver))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void actualizarTabla() {
		List <VueloDTO> lista = vueloController.obtenerVuelos();
		modelo.setRowCount(0);
		Object [] arrayDatos = new Object[9];
		if (lista != null) {
			if (lista.size() > 0) {
				for (int i = 0; i < lista.size(); i++) {
					arrayDatos[0] = lista.get(i).getId();
					arrayDatos[1] = lista.get(i).getNumeroVuelo();
					arrayDatos[2] = lista.get(i).getCantAsientos();
					arrayDatos[3] = lista.get(i).getFecSalida();
					arrayDatos[4] = lista.get(i).getFecLlegada();
					arrayDatos[5] = lista.get(i).getTiempoVuelo();
					arrayDatos[6] = lista.get(i).getAeropuertoSalida().getCodigo();
					arrayDatos[7] = lista.get(i).getAeropuertoLlegada().getCodigo();
					arrayDatos[8] = lista.get(i).getAerolinea().getNombre();
					modelo.addRow(arrayDatos);
				}
			}
		}
	}
	
	public void setIDVueloAModificar() {
		if (table.getSelectedRow() != -1) {
			IDVueloAModificar = (int) modelo.getValueAt(table.getSelectedRow(), 0);
			btnAlta.setText("Modificación de vuelo");
			btnAlta.setVisible(true);
			btnBajaModificacin.setVisible(false);
			numeroDeVuelo.setText("");
			cantAsientos.setText("");
			fecSalida.setText("");
			fecLlegada.setText("");
			codigoAeropuertoSalida.setText("");
			codigoAeropuertoLlegada.setText("");
			tiempoDeVuelo.setText("");
			table.setVisible(false);
			scrollPane.setVisible(false);
			mostrarAlta();
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
	}
	
	public VueloDTO modificarVuelo() {
		setBounds(700, 300, 469, 372);
		int a = IDVueloAModificar;
		table.setVisible(true);
		scrollPane.setVisible(true);
		btnAlta.setVisible(false);
		modelo.setRowCount(0);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		if (comprobarFecha(fecSalida.getText()) && comprobarFecha(fecLlegada.getText())) {
			if (comprobarNumero(cantAsientos.getText()) && comprobarNumero(tiempoDeVuelo.getText())) {
				IDVueloAModificar = -1;
				return new VueloDTO (a, numeroDeVuelo.getText(), Integer.valueOf(cantAsientos.getText()), LocalDateTime.parse(fecSalida.getText(), dt), LocalDateTime.parse(fecLlegada.getText(), dt), Integer.valueOf(tiempoDeVuelo.getText()),
						new AeropuertoDTO(codigoAeropuertoSalida.getText()), new AeropuertoDTO (codigoAeropuertoLlegada.getText()), new LineaAereaDTO (aerolinea.getSelectedItem().toString()));
			} else {
				if (verificar == 0) {
					JOptionPane.showMessageDialog(null, "Ingrese datos válidos (números)");
				}
				verificar = 1;
			}
		} else {
			if (verificar == 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
			}
			verificar = 1;
		}
		btnAlta.setVisible(true);
		btnBajaModificacin.setVisible(false);
		numeroDeVuelo.setText("");
		cantAsientos.setText("");
		fecSalida.setText("");
		fecLlegada.setText("");
		codigoAeropuertoSalida.setText("");
		codigoAeropuertoLlegada.setText("");
		tiempoDeVuelo.setText("");
		table.setVisible(false);
		scrollPane.setVisible(false);
		mostrarAlta();
		return null;
	}
	
	public VueloDTO agregarVuelo() {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		if (comprobarFecha(fecSalida.getText()) && comprobarFecha(fecLlegada.getText())) {
			if (comprobarNumero(cantAsientos.getText()) && comprobarNumero(tiempoDeVuelo.getText())) {
				dispose();
				return new VueloDTO (numeroDeVuelo.getText(), Integer.valueOf(cantAsientos.getText()), LocalDateTime.parse(fecSalida.getText(), dt), LocalDateTime.parse(fecLlegada.getText(), dt), Integer.valueOf(tiempoDeVuelo.getText()),
				new AeropuertoDTO(codigoAeropuertoSalida.getText()), new AeropuertoDTO (codigoAeropuertoLlegada.getText()), new LineaAereaDTO (aerolinea.getSelectedItem().toString()));
			} else {
				if (verificar == 0) {
					JOptionPane.showMessageDialog(null, "Ingrese datos válidos (números)");
				}
				verificar = 1;
			}
		} else {
			if (verificar == 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
			}
			verificar = 1;
	}
		return null;
	}
	
	public int eliminarVuelo() {
		if (table.getSelectedRow() != -1) {
			return (int) modelo.getValueAt(table.getSelectedRow(), 0);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
			return 0;
		}
	}
	
	public void cargarAerolineas() {
		List <LineaAereaDTO> lista = LineaAereaController.obtenerLineasAereas();
		for (int i = 0; i < lista.size(); i++) {
			aerolinea.addItem(lista.get(i).getNombre());
		}
	}
	
	public boolean comprobarFecha(String s) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		try {
			LocalDateTime.parse(s, dt);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	public boolean comprobarNumero(String s) {
		try {
			Integer.valueOf(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public void setVerificar(int a) {
		verificar = a;
	}
}
