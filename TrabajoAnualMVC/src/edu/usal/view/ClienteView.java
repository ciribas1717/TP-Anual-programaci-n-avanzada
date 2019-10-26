package edu.usal.view;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import edu.usal.controller.ClienteController;
import edu.usal.controller.LineaAereaController;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.ClienteDTO;
import edu.usal.dto.DireccionDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.dto.PaisDTO;
import edu.usal.dto.PasajeroFrecuenteDTO;
import edu.usal.dto.PasaporteDTO;
import edu.usal.dto.ProvinciaDTO;
import edu.usal.dto.TelefonoDTO;
import edu.usal.util.PropertiesUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ClienteView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private static String [] a;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoDni;
	private JTextField campoNumeroDePasaporte;
	private JTextField campoAutoridad;
	private JTextField campoFechaEmision;
	private JTextField campoFechaVencimiento;
	private JTextField campoCuitCuil;
	private JTextField campoFechaNacimiento;
	private JTextField campoEmail;
	private JTextField campoNumeroTelefonoPersonal;
	private JTextField campoNumeroTelefonoCelular;
	private JTextField campoNumeroTelefonoLaboral;
	private JTextField campoNumeroPasajeroFrecuente;
	private JTextField campoCategoria;
	private JTextField campoCalle;
	private JTextField campoAltura;
	private JTextField campoCiudad;
	private JTextField campoCodigoPostal;
	private JTextField campoProvincia;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblNmeroDePasaporte;
	private JLabel lblAutoridad;
	private JLabel lblFechaDeEmisin;
	private JLabel lblFechaDeVencimiento;
	private JLabel lblPaisPasaporte;
	private JComboBox <String> comboPaisPasaporte;
	private JLabel lblCuitcuil;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblEmail;
	private JLabel lblNmeroDeTelfono;
	private JLabel lblNmeroDeTelfonoCelular;
	private JLabel lblNmeroDeTelfonoLaboral;
	private JLabel lblAlianzaDePasajero;
	private JComboBox <String> comboAlianza;
	private JLabel lblNmeroDePasajero;
	private JLabel lblCategoria;
	private JLabel lblAerolnea;
	private JComboBox <String> comboAerolinea;
	private JLabel lblCalle;
	private JLabel lblAltura;
	private JLabel lblCiudad;
	private JLabel lblCdigoPostal;
	private JLabel lblPaisDireccion;
	private JComboBox <String> comboPaisDireccion;
	private JLabel lblProvincia;
	private JButton btnAlta;
	private static ClienteController clienteController;
	private JComboBox <String> comboProvincia;
	private DefaultTableModel modelo;
	private JButton btnBajaModificacin;
	private JButton btnVolver;
	private static int IDClienteAModificar;
	private JLabel lblProvinciaCombo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			a = args;
			ClienteView dialog = new ClienteView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public ClienteView(int a) {
		
	}
	
	public ClienteView() {
		setBounds(700, 300, 857, 478);
		setModal(true);
		setResizable(false);
		clienteController = new ClienteController (this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 851, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 449, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		lblNombre = new JLabel("Nombre:");
		
		String [] columnas = {"ID", "Nombre", "Apellido", "DNI", "ID pasaporte", "Número de pasaporte", "Nombre país pasaporte", "Autoridad", "Fecha de emisión", "Fecha de vencimiento", "CUIT_CUIL", "Fecha de nacimiento", "Email",
		"ID teléfono", "Número personal", "Número celular", "Número laboral", "ID pasajero frecuente", "Alianza", "ID línea aérea", "Nombre línea aérea", "Número de pasajero frecuente", "Categoría", "ID dirección", "Calle", "Altura", "Ciudad", "Nombre país de provincia", "Provincia", "Código postal"};
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		
		campoApellido = new JTextField();
		campoApellido.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		
		lblNmeroDePasaporte = new JLabel("Número de pasaporte:");
		
		campoNumeroDePasaporte = new JTextField();
		campoNumeroDePasaporte.setColumns(10);
		
		lblAutoridad = new JLabel("Autoridad:");
		
		campoAutoridad = new JTextField();
		campoAutoridad.setColumns(10);
		
		lblFechaDeEmisin = new JLabel("Fecha de emisión (dd/MM/yyyy):");
		
		lblFechaDeVencimiento = new JLabel("Fecha de vencimiento (dd/MM/yyyy):");
		
		campoFechaEmision = new JTextField();
		campoFechaEmision.setColumns(10);
		
		campoFechaVencimiento = new JTextField();
		campoFechaVencimiento.setColumns(10);
		
		lblPaisPasaporte = new JLabel("País de pasaporte:");
		
		comboPaisPasaporte = new JComboBox <String>();
		
		lblCuitcuil = new JLabel("CUIT/CUIL:");
		
		campoCuitCuil = new JTextField();
		campoCuitCuil.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento (dd/MM/yyyy):");
		
		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		
		lblNmeroDeTelfono = new JLabel("Número de teléfono personal:");
		
		campoNumeroTelefonoPersonal = new JTextField();
		campoNumeroTelefonoPersonal.setColumns(10);
		
		lblNmeroDeTelfonoCelular = new JLabel("Número de teléfono celular:");
		
		campoNumeroTelefonoCelular = new JTextField();
		campoNumeroTelefonoCelular.setColumns(10);
		
		lblNmeroDeTelfonoLaboral = new JLabel("Número de teléfono laboral:");
		
		campoNumeroTelefonoLaboral = new JTextField();
		campoNumeroTelefonoLaboral.setColumns(10);
		
		lblAlianzaDePasajero = new JLabel("Alianza de pasajero frecuente:");
		
		comboAlianza = new JComboBox <String>();
		
		lblNmeroDePasajero = new JLabel("Número de pasajero frecuente:");
		
		campoNumeroPasajeroFrecuente = new JTextField();
		campoNumeroPasajeroFrecuente.setColumns(10);
		
		lblCategoria = new JLabel("Categoría:");
		
		campoCategoria = new JTextField();
		campoCategoria.setColumns(10);
		
		lblAerolnea = new JLabel("Aerolínea:");
		
		comboAerolinea = new JComboBox <String>();
		
		lblCalle = new JLabel("Calle:");
		
		campoCalle = new JTextField();
		campoCalle.setColumns(10);
		
		lblAltura = new JLabel("Altura de dirección:");
		
		campoAltura = new JTextField();
		campoAltura.setColumns(10);
		
		lblCiudad = new JLabel("Ciudad:");
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		
		lblCdigoPostal = new JLabel("Código postal:");
		
		campoCodigoPostal = new JTextField();
		campoCodigoPostal.setColumns(10);
		
		lblPaisDireccion = new JLabel("País (dirección):");
		
		comboPaisDireccion = new JComboBox <String>();
		comboPaisDireccion.addItemListener(clienteController);
		
		lblProvincia = new JLabel("Provincia:");
		
		campoProvincia = new JTextField();
		campoProvincia.setColumns(10);
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(clienteController);
		
		comboProvincia = new JComboBox <String>();
		comboProvincia.setVisible(false);
		
		lblProvinciaCombo = new JLabel("Provincia:");
		lblProvinciaCombo.setVisible(false);
		
		btnBajaModificacin = new JButton("Baja");
		btnBajaModificacin.addActionListener(clienteController);
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(clienteController);
		cargarPaises();
		cargarAerolineas();
		cargarProvincias();
		cargarAlianzas();
		
		if (a[0].equals("0")) {
			mostrarAlta();
		} else {
			mostrarTabla();
		}

	}
	
	public void mostrarAlta() {
		setBounds(500, 200, 1000, 500);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNmeroDeTelfonoCelular)
						.addComponent(lblNmeroDeTelfono)
						.addComponent(lblEmail)
						.addComponent(lblFechaDeNacimiento)
						.addComponent(lblCuitcuil)
						.addComponent(lblPaisPasaporte)
						.addComponent(lblNombre)
						.addComponent(lblApellido)
						.addComponent(lblDni)
						.addComponent(lblFechaDeEmisin)
						.addComponent(lblAutoridad)
						.addComponent(lblFechaDeVencimiento)
						.addComponent(lblNmeroDeTelfonoLaboral)
						.addComponent(lblNmeroDePasaporte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(campoNumeroTelefonoLaboral)
						.addComponent(campoNumeroTelefonoCelular)
						.addComponent(campoNumeroTelefonoPersonal)
						.addComponent(campoEmail)
						.addComponent(campoFechaNacimiento)
						.addComponent(campoCuitCuil)
						.addComponent(comboPaisPasaporte, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(campoFechaVencimiento)
						.addComponent(campoFechaEmision)
						.addComponent(campoAutoridad)
						.addComponent(campoNumeroDePasaporte)
						.addComponent(campoDni)
						.addComponent(campoApellido)
						.addComponent(campoNombre, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAlianzaDePasajero)
								.addComponent(lblNmeroDePasajero)
								.addComponent(lblCategoria)
								.addComponent(lblAerolnea)
								.addComponent(lblCalle)
								.addComponent(lblAltura)
								.addComponent(lblCiudad)
								.addComponent(lblCdigoPostal)
								.addComponent(lblPaisDireccion)
								.addComponent(lblProvincia)
								.addComponent(lblProvinciaCombo))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboProvincia, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoProvincia)
								.addComponent(comboPaisDireccion, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoCodigoPostal)
								.addComponent(campoCiudad)
								.addComponent(campoAltura)
								.addComponent(campoCalle)
								.addComponent(comboAerolinea, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(campoCategoria)
								.addComponent(campoNumeroPasajeroFrecuente)
								.addComponent(comboAlianza, 0, 148, Short.MAX_VALUE))
							.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlianzaDePasajero)
						.addComponent(comboAlianza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApellido)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(campoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNmeroDePasajero)
							.addComponent(campoNumeroPasajeroFrecuente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDni)
								.addComponent(campoDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoNumeroDePasaporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNmeroDePasaporte))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoAutoridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAutoridad))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaDeEmisin)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(campoFechaEmision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(campoFechaVencimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaDeVencimiento))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPaisPasaporte)
								.addComponent(comboPaisPasaporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCuitcuil)
								.addComponent(campoCuitCuil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDeNacimiento)
								.addComponent(campoFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(campoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNmeroDeTelfono)
								.addComponent(campoNumeroTelefonoPersonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNmeroDeTelfonoCelular)
								.addComponent(campoNumeroTelefonoCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoNumeroTelefonoLaboral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNmeroDeTelfonoLaboral)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCategoria)
								.addComponent(campoCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAerolnea)
								.addComponent(comboAerolinea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCalle)
								.addComponent(campoCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAltura)
								.addComponent(campoAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCiudad)
								.addComponent(campoCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCdigoPostal)
								.addComponent(campoCodigoPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPaisDireccion)
								.addComponent(comboPaisDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProvincia))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProvinciaCombo)
								.addComponent(comboProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(390, Short.MAX_VALUE)
					.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
	
	public void mostrarTabla () {
		actualizarTabla();
		setBounds(50, 300, 1850, 372);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1800, GroupLayout.PREFERRED_SIZE)
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
		List <ClienteDTO> lista = clienteController.obtenerClientes();
		modelo.setRowCount(0);
		Object [] arrayDatos = new Object[30];
		if (lista != null) {
			if (lista.size() > 0) {
				for (int i = 0; i < lista.size(); i++) {
					arrayDatos[0] = lista.get(i).getIdCliente();
					arrayDatos[1] = lista.get(i).getNombre();
					arrayDatos[2] = lista.get(i).getApellido();
					arrayDatos[3] = lista.get(i).getdNI();
					arrayDatos[4] = lista.get(i).getPasaporte().getId();
					arrayDatos[5] = lista.get(i).getPasaporte().getNumeroPasaporte();
					arrayDatos[6] = lista.get(i).getPasaporte().getPais().getNombre();
					arrayDatos[7] = lista.get(i).getPasaporte().getAutoridad();
					arrayDatos[8] = lista.get(i).getPasaporte().getFecEmision();
					arrayDatos[9] = lista.get(i).getPasaporte().getFecVencimiento();
					arrayDatos[10] = lista.get(i).getCuit_cuil();
					arrayDatos[11] = lista.get(i).getFecNac();
					arrayDatos[12] = lista.get(i).getEmail();
					arrayDatos[13] = lista.get(i).getTelefono().getId();
					arrayDatos[14] = lista.get(i).getTelefono().getNumPersonal();
					arrayDatos[15] = lista.get(i).getTelefono().getNumCelular();
					arrayDatos[16] = lista.get(i).getTelefono().getNumLaboral();
					arrayDatos[17] = lista.get(i).getPasajeroFrecuente().getId();
					arrayDatos[18] = lista.get(i).getPasajeroFrecuente().getAlianza().getNombre();
					arrayDatos[19] = lista.get(i).getPasajeroFrecuente().getAerolinea().getId();
					arrayDatos[20] = lista.get(i).getPasajeroFrecuente().getAerolinea().getNombre();
					arrayDatos[21] = lista.get(i).getPasajeroFrecuente().getNumeroPasajeroFrecuente();
					arrayDatos[22] = lista.get(i).getPasajeroFrecuente().getCategoria();
					arrayDatos[23] = lista.get(i).getDireccion().getIdDireccion();
					arrayDatos[24] = lista.get(i).getDireccion().getCalle();
					arrayDatos[25] = lista.get(i).getDireccion().getAltura();
					arrayDatos[26] = lista.get(i).getDireccion().getCiudad();
					arrayDatos[27] = lista.get(i).getDireccion().getPais().getNombre();
					arrayDatos[28] = lista.get(i).getDireccion().getProvincia().getNombre();
					arrayDatos[29] = lista.get(i).getDireccion().getCodPostal();
					modelo.addRow(arrayDatos);
				}	
			}
		}
	}
	
	public int eliminarCliente() {
		if (table.getSelectedRow() != -1) {
			return (int) modelo.getValueAt(table.getSelectedRow(), 0);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
			return 0;
		}
	}
	
	public ClienteDTO modificarCliente() {
		int a = IDClienteAModificar;
		IDClienteAModificar = -1;
		table.setVisible(true);
		scrollPane.setVisible(true);
		btnAlta.setVisible(false);
		modelo.setRowCount(0);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
			if (comprobarFecha(campoFechaEmision.getText()) && comprobarFecha(campoFechaVencimiento.getText()) && comprobarFecha(campoFechaNacimiento.getText())) {
					if (comboProvincia.isVisible()) {
						return new ClienteDTO (a, campoNombre.getText(), campoApellido.getText(), campoDni.getText(),
								new PasaporteDTO (campoNumeroDePasaporte.getText(), campoAutoridad.getText(), LocalDate.parse(campoFechaEmision.getText(), dt), LocalDate.parse(campoFechaVencimiento.getText(), dt), new PaisDTO (comboPaisPasaporte.getSelectedItem().toString())),
								campoCuitCuil.getText(), LocalDate.parse(campoFechaNacimiento.getText(), dt), campoEmail.getText(), 
								new TelefonoDTO (campoNumeroTelefonoPersonal.getText(), campoNumeroTelefonoCelular.getText(), campoNumeroTelefonoLaboral.getText()), 
								new PasajeroFrecuenteDTO (new AlianzaDTO (comboAlianza.getSelectedItem().toString()), campoNumeroPasajeroFrecuente.getText(), campoCategoria.getText(), new LineaAereaDTO (comboAerolinea.getSelectedItem().toString())), 
								new DireccionDTO (campoCalle.getText(), campoAltura.getText(), campoCiudad.getText(), campoCodigoPostal.getText(), new PaisDTO (comboPaisDireccion.getSelectedItem().toString()), new ProvinciaDTO (comboProvincia.getSelectedItem().toString())));
					} else {
							return new ClienteDTO (a, campoNombre.getText(), campoApellido.getText(), campoDni.getText(),
									new PasaporteDTO (campoNumeroDePasaporte.getText(), campoAutoridad.getText(), LocalDate.parse(campoFechaEmision.getText(), dt), LocalDate.parse(campoFechaVencimiento.getText(), dt), new PaisDTO (comboPaisPasaporte.getSelectedItem().toString())),
									campoCuitCuil.getText(), LocalDate.parse(campoFechaNacimiento.getText(), dt), campoEmail.getText(), 
									new TelefonoDTO (campoNumeroTelefonoPersonal.getText(), campoNumeroTelefonoCelular.getText(), campoNumeroTelefonoLaboral.getText()), 
									new PasajeroFrecuenteDTO (new AlianzaDTO (comboAlianza.getSelectedItem().toString()), campoNumeroPasajeroFrecuente.getText(), campoCategoria.getText(), new LineaAereaDTO (comboAerolinea.getSelectedItem().toString())), 
									new DireccionDTO (campoCalle.getText(), campoAltura.getText(), campoCiudad.getText(), campoCodigoPostal.getText(), new PaisDTO (comboPaisDireccion.getSelectedItem().toString()), new ProvinciaDTO (campoProvincia.getText())));
					}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
				   }
			return null;
	}
	
	public void setIDClienteAModificar() {
		//setBounds(700, 300, 369, 300);
		if (table.getSelectedRow() != -1) {
			IDClienteAModificar = (int) modelo.getValueAt(table.getSelectedRow(), 0);
			btnAlta.setText("Modificación de cliente");
			btnAlta.setVisible(true);
			campoNombre.setText("");
			campoDni.setText("");
			campoApellido.setText("");
			campoNumeroDePasaporte.setText("");
			campoAutoridad.setText("");
			campoFechaEmision.setText("");
			campoFechaVencimiento.setText("");
			campoCuitCuil.setText("");
			campoFechaNacimiento.setText("");
			campoEmail.setText("");
			campoNumeroTelefonoPersonal.setText("");
			campoNumeroTelefonoCelular.setText("");
			campoNumeroTelefonoLaboral.setText("");
			campoNumeroPasajeroFrecuente.setText("");
			campoCategoria.setText("");
			campoCalle.setText("");
			campoAltura.setText("");
			campoCiudad.setText("");
			campoCodigoPostal.setText("");
			campoProvincia.setText("");
			table.setVisible(false);
			scrollPane.setVisible(false);
			mostrarAlta();
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
	}
	
	public boolean comprobarFecha(String s) {
		try {
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(s, dt);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	public ClienteDTO agregarCliente() {
		dispose();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (comprobarFecha(campoFechaEmision.getText()) && comprobarFecha(campoFechaVencimiento.getText()) && comprobarFecha(campoFechaNacimiento.getText())) {
			if (comboProvincia.isVisible()) {
				return new ClienteDTO (campoNombre.getText(), campoApellido.getText(), campoDni.getText(),
						new PasaporteDTO (campoNumeroDePasaporte.getText(), campoAutoridad.getText(), LocalDate.parse(campoFechaEmision.getText(), dt), LocalDate.parse(campoFechaVencimiento.getText(), dt), new PaisDTO (comboPaisPasaporte.getSelectedItem().toString())),
						campoCuitCuil.getText(), LocalDate.parse(campoFechaNacimiento.getText(), dt), campoEmail.getText(), 
						new TelefonoDTO (campoNumeroTelefonoPersonal.getText(), campoNumeroTelefonoCelular.getText(), campoNumeroTelefonoLaboral.getText()), 
						new PasajeroFrecuenteDTO (new AlianzaDTO (comboAlianza.getSelectedItem().toString()), campoNumeroPasajeroFrecuente.getText(), campoCategoria.getText(), new LineaAereaDTO (comboAerolinea.getSelectedItem().toString())), 
						new DireccionDTO (campoCalle.getText(), campoAltura.getText(), campoCiudad.getText(), campoCodigoPostal.getText(), new PaisDTO (comboPaisDireccion.getSelectedItem().toString()), new ProvinciaDTO (comboProvincia.getSelectedItem().toString())));
			} else {
					return new ClienteDTO (campoNombre.getText(), campoApellido.getText(), campoDni.getText(),
							new PasaporteDTO (campoNumeroDePasaporte.getText(), campoAutoridad.getText(), LocalDate.parse(campoFechaEmision.getText(), dt), LocalDate.parse(campoFechaVencimiento.getText(), dt), new PaisDTO (comboPaisPasaporte.getSelectedItem().toString())),
							campoCuitCuil.getText(), LocalDate.parse(campoFechaNacimiento.getText(), dt), campoEmail.getText(), 
							new TelefonoDTO (campoNumeroTelefonoPersonal.getText(), campoNumeroTelefonoCelular.getText(), campoNumeroTelefonoLaboral.getText()), 
							new PasajeroFrecuenteDTO (new AlianzaDTO (comboAlianza.getSelectedItem().toString()), campoNumeroPasajeroFrecuente.getText(), campoCategoria.getText(), new LineaAereaDTO (comboAerolinea.getSelectedItem().toString())), 
							new DireccionDTO (campoCalle.getText(), campoAltura.getText(), campoCiudad.getText(), campoCodigoPostal.getText(), new PaisDTO (comboPaisDireccion.getSelectedItem().toString()), new ProvinciaDTO (campoProvincia.getText())));
			}
	} else {
		JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
		   }
	return null;
	}
	
	public void cargarPaises() {
		File n = new File (PropertiesUtil.getString("rutaPaises"));
		FileReader fr;
		try {
			fr = new FileReader (n);
			BufferedReader b = new BufferedReader (fr);
			String s;
			while ((s = b.readLine()) != null) {
				comboPaisPasaporte.addItem(s);
				comboPaisDireccion.addItem(s);
			}
			fr.close();
			b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarProvincias() {
		File n = new File (PropertiesUtil.getString("rutaProvincias"));
		FileReader fr;
		try {
			fr = new FileReader (n);
			BufferedReader b = new BufferedReader (fr);
			String s;
			while ((s = b.readLine()) != null) {
				comboProvincia.addItem(s);
			}
			fr.close();
			b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarAlianzas() {
		File n = new File (PropertiesUtil.getString("rutaAlianzas"));
		FileReader fr;
		try {
			fr = new FileReader (n);
			BufferedReader b = new BufferedReader (fr);
			String s;
			while ((s = b.readLine()) != null) {
				comboAlianza.addItem(s);
			}
			fr.close();
			b.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarAerolineas() {
		List <LineaAereaDTO> lista = LineaAereaController.obtenerLineasAereas(); 
		for (int i = 0; i < lista.size(); i++) {
			comboAerolinea.addItem(lista.get(i).getNombre());
		}
	}
	
	public void mostrarComboProvincias() {
		lblProvinciaCombo.setVisible(true);
		campoProvincia.setVisible(false);
		comboProvincia.setVisible(true);
		lblProvincia.setVisible(false);
	}
	
	public void ocultarComboProvincias() {
		lblProvinciaCombo.setVisible(false);
		campoProvincia.setVisible(true);
		comboProvincia.setVisible(false);
		lblProvincia.setVisible(true);
	}
	

}
