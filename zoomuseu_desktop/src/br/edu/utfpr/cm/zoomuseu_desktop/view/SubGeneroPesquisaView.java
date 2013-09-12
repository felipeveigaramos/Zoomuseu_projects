package br.edu.utfpr.cm.zoomuseu_desktop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubGeneroController;

public class SubGeneroPesquisaView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SubGeneroBean SubGenero = new SubGeneroBean();
	private JPanel contentPane;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				SubGeneroPesquisaView dialog = new SubGeneroPesquisaView(
						new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public SubGeneroPesquisaView(java.awt.Frame parent, boolean modal) {
		super(parent, modal);

		setTitle("Pesquisa SubGenero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 515);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		final JComboBox<Object> jCPesquisa = new JComboBox<Object>();
		jCPesquisa.setModel(new DefaultComboBoxModel<Object>(new String[] {
				"Geral", "C\u00F3digo", "Nome" }));

		jTPesquisa = new JTextField();
		jTPesquisa.setColumns(10);

		JButton jBtPesquisar = new JButton("Pesquisar");
		jBtPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (jCPesquisa.getSelectedIndex()) {
				case 0: {
					try {
						InterfaceSubGeneroController ifc = ControllerFactory
								.getInstance()
								.getInterfaceSubGeneroController();
						List<SubGeneroBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (SubGeneroBean filo : lista) {
							dtm.addRow(new Object[] { filo.getId(),
									filo.getNome(), filo.getGenero().getNome() });
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane,
								"Erro na pesquisa !");
					}
					break;
				}

				case 1: {
					if (jTPesquisa.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,
								"Digite um código");
					} else {
						try {
							Long id = Long.parseLong(jTPesquisa.getText());
							InterfaceSubGeneroController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubGeneroController();
							SubGeneroBean elemento = ifc.pesquisar(id);
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);

							dtm.addRow(new Object[] { elemento.getId(),
									elemento.getNome(),
									elemento.getGenero().getNome() });
						} catch (Exception e) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro na pesquisa !");
						}
					}
					break;
				}
				case 2: {
					if (jTPesquisa.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,
								"Digite um nome!");
					} else {
						try {
							String nome = (jTPesquisa.getText());
							InterfaceSubGeneroController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubGeneroController();
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);
							List<SubGeneroBean> lista = ifc.pesquisar(nome,
									true);
							dtm.setRowCount(0);
							for (SubGeneroBean filo : lista) {
								dtm.addRow(new Object[] { filo.getId(),
										filo.getNome() });
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro na pesquisa !");
						}
					}
					break;
				}
				}
			}

		});

		JScrollPane scrollPane = new JScrollPane();

		JButton jBtCancelar = new JButton("Cancelar");
		jBtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubGenero.setId(0l);
				SubGenero.setNome("");
				dispose();
			}
		});

		JButton jBtConfirmar = new JButton("Confirmar");
		jBtConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		jTBPesquisa = new JTable();
		jTBPesquisa.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					InterfaceSubGeneroController ifc = ControllerFactory
							.getInstance().getInterfaceSubGeneroController();

					int index = jTBPesquisa.getSelectedRow();
					if (-1 != index) {
						Long ids = (Long) jTBPesquisa.getValueAt(index, 0);

						SubGeneroBean filos = ifc.pesquisar(ids);
						SubGenero.setId(filos.getId());
						SubGenero.setNome(filos.getNome());
						SubGenero.setGenero(filos.getGenero());

					}
				}
			}
		});
		jTBPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfaceSubGeneroController ifc = ControllerFactory
						.getInstance().getInterfaceSubGeneroController();

				int index = jTBPesquisa.getSelectedRow();
				if (-1 != index) {
					Long ids = (Long) jTBPesquisa.getValueAt(index, 0);

					SubGeneroBean filos = ifc.pesquisar(ids);
					SubGenero.setId(filos.getId());
					SubGenero.setNome(filos.getNome());
					SubGenero.setGenero(filos.getGenero());

				}
			}
		});
		jTBPesquisa
				.setModel(new DefaultTableModel(new Object[][] { { null, null,
						null }, },
						new String[] { "C\u00F3digo", "Nome", "Filo" }) {
					/**
							 * 
							 */
					private static final long serialVersionUID = 1L;
					Class<?>[] columnTypes = new Class<?>[] { Long.class,
							String.class, Object.class };

					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		jTBPesquisa.getColumnModel().getColumn(0).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(1).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(1).setPreferredWidth(247);
		jTBPesquisa.getColumnModel().getColumn(2).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(2).setPreferredWidth(149);
		scrollPane.setColumnHeaderView(jTBPesquisa);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(10)
																.addComponent(
																		jCPesquisa,
																		GroupLayout.PREFERRED_SIZE,
																		82,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		jTPesquisa,
																		GroupLayout.PREFERRED_SIZE,
																		488,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		jBtPesquisar))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(266)
																.addComponent(
																		jBtConfirmar)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		jBtCancelar))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		scrollPane,
																		GroupLayout.DEFAULT_SIZE,
																		686,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(11)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(1)
																.addComponent(
																		jCPesquisa,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(1)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						jTPesquisa,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jBtPesquisar))))
								.addGap(8)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 389,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(jBtConfirmar)
												.addComponent(jBtCancelar))));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 471,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

}
