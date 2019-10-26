package edu.usal.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
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

import edu.usal.controller.ClienteController;
import edu.usal.controller.LineaAereaController;
import edu.usal.controller.VentaController;
import edu.usal.controller.VueloController;
import edu.usal.dto.ClienteDTO;
import edu.usal.dto.FormaDePago;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.VentaDTO;
import edu.usal.dto.VueloDTO;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentaView {

	private JFrame frame;
	private JTextField dniCliente;
	private JTextField numeroDeVuelo;
	private JLabel lblDNICliente;
	private JLabel lblNumeroDeVuelo;
	private JLabel lblFormaDePago;
	private JLabel lblAerolinea;
	private JComboBox <String> aerolinea;
	private JComboBox <String> formaDePago;
	private JComboBox <String> tipoFormaDePago;
	private static VentaController ventaController;
	private JButton btnAlta; 
	private JButton btnBajaModificacin;
	private JButton btnVolver;
	private static String[] a;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	private static int IDVentaAModificar;
	private static int verificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a = args;
					VentaView window = new VentaView();
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
	public VentaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventaController = new VentaController (this);
		frame = new JFrame();
		frame.setBounds(700, 300, 400, 279);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		
		String [] columnas = {"ID", "Fecha de venta", "Forma de pago", "DNI de cliente", "Número de vuelo", "Nombre de línea aérea"};
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lblDNICliente = new JLabel("DNI cliente:");
		
		dniCliente = new JTextField();
		dniCliente.setColumns(10);
		
		lblNumeroDeVuelo = new JLabel("Número de vuelo:");
		
		numeroDeVuelo = new JTextField();
		numeroDeVuelo.setColumns(10);
		
		lblAerolinea = new JLabel("Aerolínea:");
		
		aerolinea = new JComboBox <String>();
		cargarAerolineas();
		
		lblFormaDePago = new JLabel("Forma de pago:");
		
		formaDePago = new JComboBox <String>();
		formaDePago.addItemListener(ventaController);
		formaDePago.addItem("Efectivo");
		formaDePago.addItem("Tarjeta de crédito");
		formaDePago.addItem("Tarjeta de débito");
		
		tipoFormaDePago = new JComboBox <String>();
		tipoFormaDePago.setVisible(false);
		tipoFormaDePago.addItem("3 cuotas sin interés");
		tipoFormaDePago.addItem("6 cuotas 10% interés");
		tipoFormaDePago.addItem("12 cuotas 10% interés");
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(ventaController);
		
		btnBajaModificacin = new JButton("Baja");
		btnBajaModificacin.addActionListener(ventaController);
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(ventaController);
		
		if (a[0].equals("0")) {
			mostrarAlta();
		} else {
			mostrarTabla();
		}

	}

	public void mostrarAlta() {
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFormaDePago)
								.addComponent(lblAerolinea)
								.addComponent(lblNumeroDeVuelo)
								.addComponent(lblDNICliente))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tipoFormaDePago, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(formaDePago, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(aerolinea, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(numeroDeVuelo, Alignment.LEADING)
								.addComponent(dniCliente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addComponent(btnAlta)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNICliente)
						.addComponent(dniCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeVuelo)
						.addComponent(numeroDeVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAerolinea)
						.addComponent(aerolinea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormaDePago)
						.addComponent(formaDePago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tipoFormaDePago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlta)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void mostrarTabla () {
		formaDePago.setVisible(false);
		actualizarTabla();
		frame.setBounds(700, 300, 569, 372);
		int espacio = 0;
		if (a[0].equals("3")) {
			espacio = 200;
			btnBajaModificacin.setVisible(false);
		} else if (a[0].equals("1")) {
			btnBajaModificacin.setText("Baja");
			espacio = 72;
		} else if (a[0].equals("2")) {
			btnBajaModificacin.setText("Modificación");
			espacio = 72;
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
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
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void actualizarTabla() {
		List <VentaDTO> lista = ventaController.obtenerVentas();
		modelo.setRowCount(0);
		Object [] arrayDatos = new Object[6];
		if (lista != null) {
			if (lista.size() > 0) {
				for (int i = 0; i < lista.size(); i++) {
					arrayDatos[0] = lista.get(i).getId();
					arrayDatos[1] = lista.get(i).getFecVenta();
					arrayDatos[2] = lista.get(i).getFormaDePago();
					arrayDatos[3] = lista.get(i).getCliente().getdNI();
					arrayDatos[4] = lista.get(i).getVuelo().getNumeroVuelo();
					arrayDatos[5] = lista.get(i).getAerolinea().getNombre();
					modelo.addRow(arrayDatos);
				}	
			}
		}
	}
	
	public void mostrarFormaPago() {
		tipoFormaDePago.setVisible(true);
	}
	
	public void ocultarFormaPago() {
		if (tipoFormaDePago == null) {
			tipoFormaDePago = new JComboBox <String>();
			tipoFormaDePago.setVisible(false);
		} else {
			tipoFormaDePago.setVisible(false);
		}
	}
	
	public void cargarAerolineas() {
		List <LineaAereaDTO> lista = LineaAereaController.obtenerLineasAereas();
		for (int i = 0; i < lista.size(); i++) {
			aerolinea.addItem(lista.get(i).getNombre());
		}
	}
	
	public void dispose() {
		this.frame.dispose();
	}
	
	public int eliminarVenta() {
		if (table.getSelectedRow() != -1) {
			return (int) modelo.getValueAt(table.getSelectedRow(), 0);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
			return 0;
		}
	}
	
	public VentaDTO modificarVenta() {
		int a = IDVentaAModificar;
		IDVentaAModificar = -1;
		table.setVisible(true);
		scrollPane.setVisible(true);
		btnAlta.setVisible(false);
		modelo.setRowCount(0);
		String s = formaDePago.getSelectedItem().toString();
		if (s.equals("Tarjeta de crédito")) {
			s = "TarjetaCrédito";
		} else if (s.equals("Tarjeta de débito")) {
			s = "TarjetaDébito";
		}
		return new VentaDTO (a, FormaDePago.valueOf(s), new ClienteDTO(dniCliente.getText()), new VueloDTO (numeroDeVuelo.getText()), new LineaAereaDTO(aerolinea.getSelectedItem().toString()));
	}
	
	public void setIDVentaAModificar() {
		frame.setBounds(700, 300, 369, 300);
		formaDePago.setVisible(true);
		if (table.getSelectedRow() != -1) {
			IDVentaAModificar = (int) modelo.getValueAt(table.getSelectedRow(), 0);
			btnAlta.setText("Modificación de venta");
			btnAlta.setVisible(true);
			numeroDeVuelo.setText("");
			dniCliente.setText("");
			table.setVisible(false);
			scrollPane.setVisible(false);
			mostrarAlta();
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
	}
	
	public VentaDTO agregarVenta() {
		String s = formaDePago.getSelectedItem().toString();
		if (s.equals("Tarjeta de crédito")) {
			s = "TarjetaCrédito";
		} else if (s.equals("Tarjeta de débito")) {
			s = "TarjetaDébito";
		}
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String t = dt.format(LocalDateTime.now());
		LocalDateTime localDateTime = LocalDateTime.parse(t, dt);
		this.frame.dispose();
		
	    try {
	    	ClienteView clienteView = new ClienteView(1);
	    	ClienteController clienteController = new ClienteController (clienteView);
	    	List <ClienteDTO> lista = clienteController.obtenerClientes();
	    	ClienteDTO c = null;
	    	for (int i = 0; i < lista.size(); i++) {
	    		if (lista.get(i).getdNI().equals(dniCliente.getText())) {
	    			c = lista.get(i);
	    		}
	    	}
	    	VueloView vueloView = new VueloView(1);
	    	VueloController vueloController = new VueloController (vueloView);
	    	List <VueloDTO> listaVuelos = vueloController.obtenerVuelos();
	    	VueloDTO v = null;
	    	for (int i = 0; i < listaVuelos.size(); i++) {
	    		if (listaVuelos.get(i).getNumeroVuelo().equals(numeroDeVuelo.getText())) {
	    			v = listaVuelos.get(i);
	    		}
	    	}
	    	if (c != null && v != null) {
		    	if (c.getFecNac().plusYears(18).isBefore(LocalDate.now()) || c.getFecNac().plusYears(18).isEqual(LocalDate.now())) {
		    		if (c.getPasaporte().getFecEmision().isBefore(LocalDate.now())) {
		    			if (c.getPasaporte().getFecVencimiento().plusMonths(6).isAfter(v.getFecSalida().toLocalDate())) {
		    				return new VentaDTO (localDateTime, FormaDePago.valueOf(s), new ClienteDTO(dniCliente.getText()), new VueloDTO (numeroDeVuelo.getText()), new LineaAereaDTO(aerolinea.getSelectedItem().toString()));
		    			} else {
		    				if (verificar == 0) {
			    				JOptionPane.showMessageDialog(null, "La fecha de vencimiento del pasaporte no cumple con los requisitos");
		    				}
		    				this.frame.setVisible(true);
		    			}
		    		} else {
		    			if (verificar == 0) {
			    			JOptionPane.showMessageDialog(null, "La fecha de emisión del pasaporte no cumple con los requisitos");
		    			}
		    			this.frame.setVisible(true);
		    		}
		    	} else {
		    		if (verificar == 0) {
			    		JOptionPane.showMessageDialog(null, "El cliente no es mayor de 18 años");
		    		}
		    		this.frame.setVisible(true);
		    	}
	    	} else {
	    		if (c == null && v != null) {
	    			if (verificar == 0) {
			    		JOptionPane.showMessageDialog(null, "No se ha encontrado ese DNI de cliente");
	    			}
	    		} else if (v == null && c != null) {
	    			if (verificar == 0) {
		    			JOptionPane.showMessageDialog(null, "No se ha encontrado ese número de vuelo");
	    			}
	    		} else if (c == null && v == null) {
	    			if (verificar == 0) {
		    			JOptionPane.showMessageDialog(null, "No se han encontrado ni el cliente ni el vuelo");
	    			}
	    		}
	    		this.frame.setVisible(true);
	    	}
	    } catch (NumberFormatException e) {
	    	JOptionPane.showMessageDialog(null, "Ingrese datos válidos (solamente números)");
	    	this.frame.setVisible(true);
	    }
		verificar = 1;
	    return null;
	}
	
	public void setVerificar(int a) {
		verificar = a;
	}
	
}
