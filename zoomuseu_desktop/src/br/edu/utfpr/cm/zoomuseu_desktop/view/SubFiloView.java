package br.edu.utfpr.cm.zoomuseu_desktop.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceFiloController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubFiloController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public class SubFiloView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField jTIdSubFilo;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;
	private JTextField jTNomeSubFilo;
	private JTextField jTIdFilo;
	private JTextField jTDescFilo;

	private final JButton jBtNovo;
	private final JButton jBtEditar;
	private final JButton jBtSalvar;
	private final JButton jBtExcluir;
	private final JButton jBtCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubFiloView frame = new SubFiloView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SubFiloView() {
		super();

		jBtNovo = new JButton("Novo");
		jBtEditar = new JButton("Editar");

		jBtSalvar = new JButton("Salvar");

		jBtExcluir = new JButton("Excluir");

		jBtCancelar = new JButton("Cancelar");

		final LimparView lv = new LimparView();
		setTitle("Cadastro SubFilo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addComponent(tabbedPane, Alignment.LEADING,
				GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE));

		final JPanel jPCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, jPCadastro, null);

		JLabel label = new JLabel("Id");

		jTIdSubFilo = new JTextField();
		jTIdSubFilo.setEnabled(false);
		jTIdSubFilo.setColumns(10);

		JPanel panel = new JPanel();

		JLabel lblNome = new JLabel("Nome");

		jTNomeSubFilo = new JTextField();
		jTNomeSubFilo.setEnabled(false);
		jTNomeSubFilo.setColumns(10);

		JLabel lblIdFilo = new JLabel("Id Filo");

		jTIdFilo = new JTextField();
		jTIdFilo.setEditable(false);
		jTIdFilo.setEnabled(false);
		jTIdFilo.setColumns(10);
		final FiloPesquisaView pesquisaView = new FiloPesquisaView(this, true);
		pesquisaView.setVisible(false);

		final JButton jBtPesquisarFilo = new JButton("Pesquisar");
		jBtPesquisarFilo.setEnabled(false);
		jBtPesquisarFilo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final FiloBean filo = pesquisaView.filo;
				pesquisaView.setVisible(true);
				pesquisaView
						.addWindowListener(new java.awt.event.WindowAdapter() {

							public void windowClosed(
									java.awt.event.WindowEvent evt) {
								if ((filo.getNome().equals(""))
										|| (filo.getId() == null)) {
									jTIdFilo.setText("");
									jTDescFilo.setText("");
								} else {
									jTIdFilo.setText(filo.getId() + "");
									jTDescFilo.setText(filo.getNome());

								}
							}
						});

			}
		});

		jTDescFilo = new JTextField();
		jTDescFilo.setEditable(false);
		jTDescFilo.setEnabled(false);
		jTDescFilo.setColumns(10);

		JLabel lblIdFilo_1 = new JLabel("Nome Filo");
		final FiloView view = new FiloView(this, false);
		final JButton jBTCadFilo = new JButton("Cadastrar");
		jBTCadFilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				view.setVisible(true);
				view.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosed(java.awt.event.WindowEvent evt) {
						tabbedPane.setSelectedIndex(0);
					}
				});
			}
		});

		jBTCadFilo.setEnabled(false);
		GroupLayout gl_jPCadastro = new GroupLayout(jPCadastro);
		gl_jPCadastro
				.setHorizontalGroup(gl_jPCadastro
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPCadastro
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				label)
																		.addGap(681))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				jTIdSubFilo,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				605,
																				Short.MAX_VALUE))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				142,
																				Short.MAX_VALUE)
																		.addComponent(
																				panel,
																				GroupLayout.PREFERRED_SIZE,
																				412,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(137))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				lblNome)
																		.addContainerGap(
																				664,
																				Short.MAX_VALUE))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPCadastro
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								jTNomeSubFilo,
																								GroupLayout.PREFERRED_SIZE,
																								568,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPCadastro
																										.createSequentialGroup()
																										.addGroup(
																												gl_jPCadastro
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_jPCadastro
																																		.createSequentialGroup()
																																		.addComponent(
																																				jTIdFilo,
																																				GroupLayout.PREFERRED_SIZE,
																																				86,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBTCadFilo)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBtPesquisarFilo))
																														.addComponent(
																																lblIdFilo))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPCadastro
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblIdFilo_1)
																														.addComponent(
																																jTDescFilo))))
																		.addContainerGap()))));
		gl_jPCadastro
				.setVerticalGroup(gl_jPCadastro
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPCadastro
										.createSequentialGroup()
										.addGap(17)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				label)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				jTIdSubFilo,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				lblIdFilo))
														.addComponent(
																lblIdFilo_1))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTIdFilo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBtPesquisarFilo)
														.addComponent(
																jBTCadFilo)
														.addComponent(
																jTDescFilo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(9)
										.addComponent(lblNome)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTNomeSubFilo,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												215, Short.MAX_VALUE)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32)));

		jBtNovo.setPreferredSize(new Dimension(73, 23));
		panel.add(jBtNovo);

		jBtEditar.setEnabled(false);
		jBtEditar.setPreferredSize(new Dimension(73, 23));
		panel.add(jBtEditar);

		jBtSalvar.setEnabled(false);
		jBtSalvar.setPreferredSize(new Dimension(73, 23));
		panel.add(jBtSalvar);

		jBtExcluir.setEnabled(false);
		jBtExcluir.setPreferredSize(new Dimension(73, 23));
		panel.add(jBtExcluir);

		jBtCancelar.setEnabled(false);
		panel.add(jBtCancelar);
		jPCadastro.setLayout(gl_jPCadastro);

		JPanel jPPesquisa = new JPanel();
		jPPesquisa.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				if (jBtSalvar.isEnabled()) {
					JOptionPane.showMessageDialog(rootPane,
							"Cadastro em andamento!");
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		tabbedPane.addTab("Pesquisa", null, jPPesquisa, null);

		final JComboBox<Object> jCPesquisa = new JComboBox<Object>();
		jCPesquisa.setModel(new DefaultComboBoxModel<Object>(new String[] {
				"Geral", "C\u00F3digo" }));

		// Acoes dos botoes

		jBtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBtSalvar.setEnabled(true);
				jBtCancelar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtExcluir.setEnabled(false);
				jBtPesquisarFilo.setEnabled(true);
				jBTCadFilo.setEnabled(true);
				lv.LimparView(jPCadastro);
				jBtEditar.setEnabled(false);

				jTNomeSubFilo.setEnabled(true);

			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SubFiloBean newSubFilo = new SubFiloBean();
					InterfaceSubFiloController ifc = ControllerFactory
							.getInstance().getInterfaceSubFiloController();
					if (jTIdSubFilo.getText().equals("")) {
						newSubFilo.setNome(jTNomeSubFilo.getText());
						FiloBean newFilo = new FiloBean();

						newFilo.setId(Long.parseLong(jTIdFilo.getText()));
						newFilo.setNome(jTDescFilo.getText());
						newSubFilo.setFilo(newFilo);
						long id = ifc.inserir(newSubFilo, true);
						if (id == -1) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro ao inserir o registro !");
							return;
						}
						jTIdSubFilo.setText("" + id);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Gravado !");

					} else {
						newSubFilo.setNome(jTNomeSubFilo.getText());
						newSubFilo.setId(Long.parseLong(jTIdSubFilo.getText()));
						FiloBean newFilo = new FiloBean();
						newFilo.setId(Long.parseLong(jTIdFilo.getText()));
						newFilo.setNome(jTDescFilo.getText());
						newSubFilo.setFilo(newFilo);

						// Setar alteracoes

						ifc.atualizar(newSubFilo, true);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Atualizado !");

						jBtExcluir.setEnabled(false);

					}
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtPesquisarFilo.setEnabled(false);
					jBTCadFilo.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

					jTNomeSubFilo.setEnabled(false);

				} catch (ValidationException e) {
					List<Report> erros = e.getErros();
					String report = "Seguintes erros foram encontrados : \n";
					for (Report r : erros) {
						report += r.getCampo() + " " + r.getErro() + "; \n";
					}
					// e.printStackTrace();
					JOptionPane.showMessageDialog(rootPane,
							report.toUpperCase());

				}
			}
		});
		jBtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					jBtSalvar.setEnabled(true);
					jBtNovo.setEnabled(false);
					jBtCancelar.setEnabled(true);
					jBtEditar.setEnabled(false);
					jBtPesquisarFilo.setEnabled(true);
					jBTCadFilo.setEnabled(true);

					jTNomeSubFilo.setEnabled(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane,
							"Erro na gravação !");
				}

			}
		});
		jBtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lv.LimparView(jPCadastro);
				jBtSalvar.setEnabled(false);
				jBtPesquisarFilo.setEnabled(false);
				jBTCadFilo.setEnabled(false);
				jBtEditar.setEnabled(false);

				jBtCancelar.setEnabled(false);
				jBtNovo.setEnabled(true);

				jTNomeSubFilo.setEnabled(false);

			}
		});

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceFiloController ifc = ControllerFactory
							.getInstance().getInterfaceFiloController();

					ifc.remover(Long.parseLong(jTIdSubFilo.getText()));
					JOptionPane.showMessageDialog(rootPane,
							"Registro Excluido !");

					jBtExcluir.setEnabled(false);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtPesquisarFilo.setEnabled(false);
					jBTCadFilo.setEnabled(false);
					jBtEditar.setEnabled(false);
					jBtCancelar.setEnabled(false);
					lv.LimparView(jPCadastro);
					DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
							.getModel();
					dtm.setRowCount(0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane,
							"Erro na exclusão !");
				}

			}
		});

		jTPesquisa = new JTextField();
		jTPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (jCPesquisa.getSelectedIndex()) {
				case 0: {
					try {
						InterfaceSubFiloController ifc = ControllerFactory
								.getInstance().getInterfaceSubFiloController();
						List<SubFiloBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (SubFiloBean Subfilo : lista) {
							dtm.addRow(new Object[] { Subfilo.getId(),
									Subfilo.getNome(),
									Subfilo.getFilo().getNome() });
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
							InterfaceSubFiloController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubFiloController();
							SubFiloBean Subfilo = ifc.pesquisar(id);
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);

							dtm.addRow(new Object[] { Subfilo.getId(),
									Subfilo.getNome(),
									Subfilo.getFilo().getNome() });

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
					}
					try {
						InterfaceSubFiloController ifc = ControllerFactory
								.getInstance().getInterfaceSubFiloController();
						List<SubFiloBean> lista = ifc.pesquisar(
								jTPesquisa.getText(), false);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (SubFiloBean Subfilo : lista) {
							dtm.addRow(new Object[] { Subfilo.getId(),
									Subfilo.getNome(),
									Subfilo.getFilo().getNome() });
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane,
								"Erro na pesquisa !");
					}
				}
					break;
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_jPPesquisa = new GroupLayout(jPPesquisa);
		gl_jPPesquisa
				.setHorizontalGroup(gl_jPPesquisa
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPPesquisa
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPPesquisa
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPPesquisa
																		.createSequentialGroup()
																		.addComponent(
																				jCPesquisa,
																				GroupLayout.PREFERRED_SIZE,
																				82,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				jTPesquisa,
																				GroupLayout.DEFAULT_SIZE,
																				504,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnPesquisar))
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																681,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_jPPesquisa
				.setVerticalGroup(gl_jPPesquisa
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPPesquisa
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPPesquisa
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jCPesquisa,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTPesquisa,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnPesquisar))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												379, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(16, Short.MAX_VALUE)));

		jTBPesquisa = new JTable();
		jTBPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfaceSubFiloController ifc = ControllerFactory
						.getInstance().getInterfaceSubFiloController();

				int index = jTBPesquisa.getSelectedRow();
				Long id = (Long) jTBPesquisa.getValueAt(index, 0);
				SubFiloBean Subfilo = ifc.pesquisar(id);
				jTIdSubFilo.setText("" + Subfilo.getId());
				jTNomeSubFilo.setText(Subfilo.getNome());
				jTIdFilo.setText("" + Subfilo.getFilo().getId());
				jTDescFilo.setText(Subfilo.getFilo().getNome());

				tabbedPane.setSelectedIndex(0);
				jBtEditar.setEnabled(true);
				jBtExcluir.setEnabled(true);
				jBtSalvar.setEnabled(false);
				jBtNovo.setEnabled(true);
				jBtCancelar.setEnabled(false);

			}
		});
		jTBPesquisa.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					InterfaceSubFiloController ifc = ControllerFactory
							.getInstance().getInterfaceSubFiloController();

					int index = jTBPesquisa.getSelectedRow();
					Long id = (Long) jTBPesquisa.getValueAt(index, 0);
					SubFiloBean Subfilo = ifc.pesquisar(id);
					jTIdSubFilo.setText("" + Subfilo.getId());
					jTNomeSubFilo.setText(Subfilo.getNome());
					jTIdFilo.setText("" + Subfilo.getFilo().getId());
					jTDescFilo.setText(Subfilo.getFilo().getNome());

					tabbedPane.setSelectedIndex(0);
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

				}
			}

		});
		setResizable(false);
		jTBPesquisa.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Filo", "C\u00F3digo", "Descri\u00E7\u00E3o" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

		});
		jTBPesquisa.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Filo", "C\u00F3digo", "Descri\u00E7\u00E3o" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { true, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTBPesquisa.getColumnModel().getColumn(2).setPreferredWidth(387);
		scrollPane.setColumnHeaderView(jTBPesquisa);
		jPPesquisa.setLayout(gl_jPPesquisa);
		contentPane.setLayout(gl_contentPane);

	}

	public void editar(SubFiloBean aSubFilo) {
		jTIdSubFilo.setText("" + aSubFilo.getId());
		jTNomeSubFilo.setText(aSubFilo.getNome());
		jTIdFilo.setText("" + aSubFilo.getFilo().getId());
		jTDescFilo.setText(aSubFilo.getFilo().getNome());
		jBtEditar.setEnabled(true);
		jBtExcluir.setEnabled(true);
		jBtSalvar.setEnabled(false);
		jBtNovo.setEnabled(true);
		jBtCancelar.setEnabled(false);

	}
}
