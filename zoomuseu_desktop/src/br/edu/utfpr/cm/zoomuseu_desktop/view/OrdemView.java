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

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceInfraClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceOrdemController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public class OrdemView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTIdOrdem;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;
	private JTextField jTNomeOrdem;
	private JTextField jTIdInfraClasse;
	private JTextField jTDescInfraClasse;
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
					OrdemView frame = new OrdemView();
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
	public OrdemView() {
		super();
		jBtNovo = new JButton("Novo");
		jBtEditar = new JButton("Editar");

		jBtSalvar = new JButton("Salvar");

		jBtExcluir = new JButton("Excluir");

		jBtCancelar = new JButton("Cancelar");

		final LimparView lv = new LimparView();
		setTitle("Cadastro Ordem");
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

		jTIdOrdem = new JTextField();
		jTIdOrdem.setEnabled(false);
		jTIdOrdem.setColumns(10);

		JPanel panel = new JPanel();

		JLabel lblNome = new JLabel("Nome");

		jTNomeOrdem = new JTextField();
		jTNomeOrdem.setEnabled(false);
		jTNomeOrdem.setColumns(10);

		JLabel lblIdInfraClasse = new JLabel("Id InfraClasse");

		jTIdInfraClasse = new JTextField();
		jTIdInfraClasse.setEditable(false);
		jTIdInfraClasse.setEnabled(false);
		jTIdInfraClasse.setColumns(10);
		final InfraClassePesquisaView pesquisaView = new InfraClassePesquisaView(
				this, true);
		pesquisaView.setVisible(false);

		final JButton jBtPesquisarInfraClasse = new JButton("Pesquisar");
		jBtPesquisarInfraClasse.setEnabled(false);
		jBtPesquisarInfraClasse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final InfraClasseBean InfraClasse = pesquisaView.InfraClasse;
				pesquisaView.setVisible(true);
				pesquisaView
						.addWindowListener(new java.awt.event.WindowAdapter() {

							public void windowClosed(
									java.awt.event.WindowEvent evt) {
								if ((InfraClasse.getNome() == null)
										|| (InfraClasse.getId() == 0)) {
									jTIdInfraClasse.setText("");
									jTDescInfraClasse.setText("");
								} else {
									jTIdInfraClasse.setText(InfraClasse.getId()
											+ "");
									jTDescInfraClasse.setText(InfraClasse.getNome());

								}

							}
						});

			}
		});

		jTDescInfraClasse = new JTextField();
		jTDescInfraClasse.setEditable(false);
		jTDescInfraClasse.setEnabled(false);
		jTDescInfraClasse.setColumns(10);

		JLabel lblIdFilo_1 = new JLabel("Nome InfraClasse");

		final JButton jBTCadInfraClasse = new JButton("Cadastrar");
		jBTCadInfraClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfraClasseView view = new InfraClasseView();
				view.setVisible(true);
				view.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosed(java.awt.event.WindowEvent evt) {
						tabbedPane.setSelectedIndex(0);

					}
				});
			}
		});
		jBTCadInfraClasse.setEnabled(false);
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
																				jTIdOrdem,
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
																								jTNomeOrdem,
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
																																				jTIdInfraClasse,
																																				GroupLayout.PREFERRED_SIZE,
																																				86,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBTCadInfraClasse)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBtPesquisarInfraClasse))
																														.addComponent(
																																lblIdInfraClasse))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPCadastro
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblIdFilo_1)
																														.addComponent(
																																jTDescInfraClasse))))
																		.addContainerGap()))));
		gl_jPCadastro
				.setVerticalGroup(gl_jPCadastro
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPCadastro
										.createSequentialGroup()
										.addGap(17)
										.addComponent(label)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTIdOrdem,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblIdInfraClasse)
														.addComponent(
																lblIdFilo_1))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTIdInfraClasse,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBtPesquisarInfraClasse)
														.addComponent(
																jBTCadInfraClasse)
														.addComponent(
																jTDescInfraClasse,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(9)
										.addComponent(lblNome)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTNomeOrdem,
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
				"Geral", "C\u00F3digo", "Descrica\u00E7\u00E3o" }));

		// Acoes dos botoes

		jBtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBtSalvar.setEnabled(true);
				jBtCancelar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtEditar.setEnabled(false);

				jBtExcluir.setEnabled(false);
				jBtPesquisarInfraClasse.setEnabled(true);
				jBTCadInfraClasse.setEnabled(true);
				lv.LimparView(jPCadastro);
				jTNomeOrdem.setEnabled(true);

			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					OrdemBean newClasse = new OrdemBean();
					InterfaceOrdemController ifc = ControllerFactory
							.getInstance().getInterfaceOrdemController();
					if (jTIdOrdem.getText().equals("")) {
						newClasse.setNome(jTNomeOrdem.getText());
						InterfaceInfraClasseController ifs = ControllerFactory
								.getInstance()
								.getInterfaceInfraClasseController();
						InfraClasseBean newInfraClasse = ifs.pesquisar((Long
								.parseLong(jTIdInfraClasse.getText())));
						newClasse.setInfraClasse(newInfraClasse);
						long id = ifc.inserir(newClasse, true);
						if (id == -1) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro ao inserir o registro !");
							return;
						}
						jTIdOrdem.setText("" + id);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Gravado !");

					} else {
						newClasse.setNome(jTNomeOrdem.getText());
						newClasse.setId(Long.parseLong(jTIdOrdem.getText()));
						InterfaceInfraClasseController ifs = ControllerFactory
								.getInstance()
								.getInterfaceInfraClasseController();
						InfraClasseBean newInfraClasse = ifs.pesquisar((Long
								.parseLong(jTIdInfraClasse.getText())));
						newClasse.setInfraClasse(newInfraClasse);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						ifc.atualizar(newClasse, true);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Atualizado !");

						jBtExcluir.setEnabled(false);

					}
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtPesquisarInfraClasse.setEnabled(false);
					jBTCadInfraClasse.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

					jTNomeOrdem.setEnabled(false);

				} catch (ValidationException e) {
					List<Report> erros = e.getErros();
					String report = "Seguintes erros foram encontrados : \n";
					for (Report r : erros) {
						report += r.getCampo() + " " + r.getErro() + "; \n";
					}
					e.printStackTrace();
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
					jBtPesquisarInfraClasse.setEnabled(true);
					jBTCadInfraClasse.setEnabled(true);

					jTNomeOrdem.setEnabled(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane,
							"Erro na grava��o !");
				}

			}
		});
		jBtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lv.LimparView(jPCadastro);
				jBtSalvar.setEnabled(false);
				jBtEditar.setEnabled(false);

				jBtPesquisarInfraClasse.setEnabled(false);
				jBTCadInfraClasse.setEnabled(false);
				jBtCancelar.setEnabled(false);
				jBtNovo.setEnabled(true);

				jTNomeOrdem.setEnabled(false);

			}
		});

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceOrdemController ifc = ControllerFactory
							.getInstance().getInterfaceOrdemController();

					ifc.remover(Long.parseLong(jTIdOrdem.getText()));
					JOptionPane.showMessageDialog(rootPane,
							"Registro Excluido !");

					jBtExcluir.setEnabled(false);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtPesquisarInfraClasse.setEnabled(false);
					jBTCadInfraClasse.setEnabled(false);
					jBtEditar.setEnabled(false);
					jBtCancelar.setEnabled(false);
					lv.LimparView(jPCadastro);
					DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
							.getModel();
					dtm.setRowCount(0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane,
							"Erro na exclus�o !");
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
						InterfaceOrdemController ifc = ControllerFactory
								.getInstance().getInterfaceOrdemController();
						List<OrdemBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (OrdemBean ordem : lista) {
							OrdemBean newOrdem = new OrdemBean();
							newOrdem.setId(ordem.getId());
							newOrdem.setNome(ordem.getNome());
							newOrdem.setInfraClasse(ordem.getInfraClasse());
							dtm.addRow(new Object[] { newOrdem.getId(),
									newOrdem.getNome(),
									newOrdem.getInfraClasse().getNome() });
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane,
								"Erro na pesquisa !");
						System.out.println(e);
					}
					break;
				}

				case 1: {
					if (jTPesquisa.getText().equals("")) {
						JOptionPane.showMessageDialog(rootPane,
								"Digite um c�digo");
					} else {
						try {
							Long id = Long.parseLong(jTPesquisa.getText());
							InterfaceClasseController ifc = ControllerFactory
									.getInstance()
									.getInterfaceClasseController();
							ClasseBean classe = ifc.pesquisar(id);
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);

							dtm.addRow(new Object[] { classe.getId(),
									classe.getNome(),
									classe.getSubFilo().getNome() });
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
						InterfaceOrdemController ifc = ControllerFactory
								.getInstance().getInterfaceOrdemController();
						List<OrdemBean> lista = ifc.pesquisar(
								jTPesquisa.getText(), true);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (OrdemBean classe : lista) {
							dtm.addRow(new Object[] { classe.getId(),
									classe.getNome(),
									classe.getInfraClasse().getNome() });
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
		jTBPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					InterfaceOrdemController ifc = ControllerFactory
							.getInstance().getInterfaceOrdemController();

					int index = jTBPesquisa.getSelectedRow();
					Long id = (Long) jTBPesquisa.getValueAt(index, 0);
					OrdemBean classe = ifc.pesquisar(id);
					jTIdOrdem.setText("" + classe.getId());
					jTNomeOrdem.setText(classe.getNome());
					jTIdInfraClasse.setText(classe.getInfraClasse().getId() + "");
					jTDescInfraClasse.setText(classe.getInfraClasse().getNome());
					tabbedPane.setSelectedIndex(0);
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

				}
			}
		});
		jTBPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfaceOrdemController ifc = ControllerFactory.getInstance()
						.getInterfaceOrdemController();
				int index = jTBPesquisa.getSelectedRow();
				Long id = (Long) jTBPesquisa.getValueAt(index, 0);
				OrdemBean classe = ifc.pesquisar(id);
				jTIdOrdem.setText("" + classe.getId());
				jTNomeOrdem.setText(classe.getNome());
				jTIdInfraClasse.setText(classe.getInfraClasse().getId() + "");
				jTDescInfraClasse.setText(classe.getInfraClasse().getNome());
				tabbedPane.setSelectedIndex(0);
				jBtEditar.setEnabled(true);
				jBtExcluir.setEnabled(true);
				jBtSalvar.setEnabled(false);
				jBtNovo.setEnabled(true);
				jBtCancelar.setEnabled(false);

			}
		});
		jTBPesquisa.setModel(new DefaultTableModel(new Object[][] { { "", null,
				null }, }, new String[] { "C\u00F3digo", "Descri\u00E7\u00E3o",
				"SubFilo" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTBPesquisa.getColumnModel().getColumn(0).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(0).setPreferredWidth(64);
		jTBPesquisa.getColumnModel().getColumn(1).setPreferredWidth(249);
		jTBPesquisa.getColumnModel().getColumn(2).setPreferredWidth(208);
		scrollPane.setColumnHeaderView(jTBPesquisa);
		jPPesquisa.setLayout(gl_jPPesquisa);
		contentPane.setLayout(gl_contentPane);

	}

	public void editar(OrdemBean aOrdem) {
		jTIdOrdem.setText("" + aOrdem.getId());
		jTNomeOrdem.setText(aOrdem.getNome());
		jTIdInfraClasse.setText("" + aOrdem.getInfraClasse().getId());
		jTDescInfraClasse.setText(aOrdem.getInfraClasse().getNome());
		jBtEditar.setEnabled(true);
		jBtExcluir.setEnabled(true);
		jBtSalvar.setEnabled(false);
		jBtNovo.setEnabled(true);
		jBtCancelar.setEnabled(false);

	}
}
