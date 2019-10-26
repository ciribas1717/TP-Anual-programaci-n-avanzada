package edu.usal.view;


import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import edu.usal.controller.LineaAereaController;
import edu.usal.dto.AlianzaDTO;
import edu.usal.dto.LineaAereaDTO;
import edu.usal.util.PropertiesUtil;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class LineaAereaView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField nombreAerolinea;
	private JComboBox <String> alianza;
	private JLabel lblNombreAerolinea;
	private JButton btnBajaModificacin;
	private JLabel lblAlianza;
	private JButton btnAlta;
	private JButton btnVolver;
	private static String [] a;
	private JScrollPane scrollPane;
	private static LineaAereaController lineaAereaController;
	private DefaultTableModel modelo;
	private static int IDAerolineaAModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			a = args;
			LineaAereaView dialog = new LineaAereaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineaAereaView() {
		setBounds(700, 300, 469, 372);
		setResizable(false);
		setModal(true);
		lineaAereaController = new LineaAereaController (this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 463, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 343, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		String [] columnas = {"ID", "Nombre", "Alianza"};
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


		lblNombreAerolinea = new JLabel("Nombre:");
		
		nombreAerolinea = new JTextField();
		nombreAerolinea.setColumns(10);
		
		lblAlianza = new JLabel("Alianza:");
		
		alianza = new JComboBox <String>();
		cargarAlianzas();
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(lineaAereaController);

		
		btnBajaModificacin = new JButton("Baja");
		btnBajaModificacin.addActionListener(lineaAereaController);
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(lineaAereaController);

		if (a[0].equals("0")) {
			menuAlta();
		} else {
			menuTabla();
		}

	}
	
	public void menuTabla() {
		actualizarTabla();
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
		alianza.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
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
	
	public void menuAlta() {
		setBounds(700, 300, 314, 223);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblAlianza, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNombreAerolinea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(alianza)
								.addComponent(nombreAerolinea, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(btnAlta)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreAerolinea)
						.addComponent(nombreAerolinea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlianza)
						.addComponent(alianza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnAlta)
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public int eliminarAerolinea() {
		if (table.getSelectedRow() != -1) {
			return (int) modelo.getValueAt(table.getSelectedRow(), 0);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
			return 0;
		}
	}
	
	public void actualizarTabla() {
		List <LineaAereaDTO> lista = LineaAereaController.obtenerLineasAereas();
		modelo.setRowCount(0);
		if (lista != null) {
			if (lista.size() > 0) {
				Object [] arrayDatos = new Object[3];
				for (int i = 0; i < lista.size(); i++) {
					arrayDatos[0] = lista.get(i).getId();
					arrayDatos[1] = lista.get(i).getNombre();
					arrayDatos[2] = lista.get(i).getAlianza().getNombre();
					modelo.addRow(arrayDatos);
				}
			}
		}
	}
	
	public void setIDAerolineaAModificar() {
		if (table.getSelectedRow() != -1) {
			IDAerolineaAModificar = (int) modelo.getValueAt(table.getSelectedRow(), 0);
			btnAlta.setText("Modificación de línea aérea");
			btnAlta.setVisible(true);
			nombreAerolinea.setText("");
			table.setVisible(false);
			scrollPane.setVisible(false);
			alianza.setVisible(true);
			menuAlta();
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
	}
	
	public LineaAereaDTO modificarAerolinea() {
		setBounds(700, 300, 469, 372);
		int a = IDAerolineaAModificar;
		IDAerolineaAModificar = -1;
		table.setVisible(true);
		scrollPane.setVisible(true);
		btnAlta.setVisible(false);
		modelo.setRowCount(0);
		return new LineaAereaDTO (a, nombreAerolinea.getText(), new AlianzaDTO (alianza.getSelectedItem().toString()));
	}
	
	public LineaAereaDTO agregarAerolinea() {
		dispose();
		return new LineaAereaDTO (nombreAerolinea.getText(), new AlianzaDTO (alianza.getSelectedItem().toString()));
	}
	
	public void cargarAlianzas() {
		File n = new File (PropertiesUtil.getString("rutaAlianzas"));
		FileReader fr;
		try {
			fr = new FileReader (n);
			BufferedReader b = new BufferedReader (fr);
			String s;
			while ((s = b.readLine()) != null) {
				alianza.addItem(s);
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
}
