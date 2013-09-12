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
import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceEspecieController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubGeneroController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public class EspecieView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTIdEspecie;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;
	private JTextField jTNomeEspecie;
	private JTextField jTIdSubGenero;
	private JTextField jTDescSubGenero;

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
					EspecieView frame = new EspecieView();
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
	public EspecieView() {
		super();
		jBtNovo = new JButton("Novo");
		jBtEditar = new JButton("Editar");

		jBtSalvar = new JButton("Salvar");

		jBtExcluir = new JButton("Excluir");

		jBtCancelar = new JButton("Cancelar");
		final LimparView lv = new LimparView();
		setTitle("Cadastro Especie");
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

		jTIdEspecie = new JTextField();
		jTIdEspecie.setEnabled(false);
		jTIdEspecie.setColumns(10);

		JPanel panel = new JPanel();

		JLabel lblNome = new JLabel("Nome");

		jTNomeEspecie = new JTextField();
		jTNomeEspecie.setEnabled(false);
		jTNomeEspecie.setColumns(10);

		JLabel lblIdSubGenero = new JLabel("Id SubGenero");

		jTIdSubGenero = new JTextField();
		jTIdSubGenero.setEditable(false);
		jTIdSubGenero.setEnabled(false);
		jTIdSubGenero.setColumns(10);
		final SubGeneroPesquisaView pesquisaView = new SubGeneroPesquisaView(
				this, true);
		pesquisaView.setVisible(false);

		final JButton jBtPesquisarSubGenero = new JButton("Pesquisar");
		jBtPesquisarSubGenero.setEnabled(false);
		jBtPesquisarSubGenero.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final SubGeneroBean SubGenero = pesquisaView.SubGenero;
				pesquisaView.setVisible(true);
				pesquisaView
						.addWindowListener(new java.awt.event.WindowAdapter() {

							public void windowClosed(
									java.awt.event.WindowEvent evt) {
								if ((SubGenero.getNome() == null)
										|| (SubGenero.getId() == 0)) {
									jTIdSubGenero.setText("");
									jTDescSubGenero.setText("");
								} else {
									jTIdSubGenero.setText(SubGenero.getId()
											+ "");
									jTDescSubGenero.setText(SubGenero.getNome());

								}

							}
						});

			}
		});

		jTDescSubGenero = new JTextField();
		jTDescSubGenero.setEditable(false);
		jTDescSubGenero.setEnabled(false);
		jTDescSubGenero.setColumns(10);

		JLabel lblIdFilo_1 = new JLabel("Nome SubGenero");

		final JButton jBTCadSubGenero = new JButton("Cadastrar");
		jBTCadSubGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubGeneroView view = new SubGeneroView();
				view.setVisible(true);
				view.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosed(java.awt.event.WindowEvent evt) {
						tabbedPane.setSelectedIndex(0);

					}
				});
			}
		});
		jBTCadSubGenero.setEnabled(false);
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
																				jTIdEspecie,
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
																								jTNomeEspecie,
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
																																				jTIdSubGenero,
																																				GroupLayout.PREFERRED_SIZE,
																																				86,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBTCadSubGenero)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				jBtPesquisarSubGenero))
																														.addComponent(
																																lblIdSubGenero))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPCadastro
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblIdFilo_1)
																														.addComponent(
																																jTDescSubGenero))))
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
										.addComponent(jTIdEspecie,
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
																lblIdSubGenero)
														.addComponent(
																lblIdFilo_1))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTIdSubGenero,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBtPesquisarSubGenero)
														.addComponent(
																jBTCadSubGenero)
														.addComponent(
																jTDescSubGenero,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(9)
										.addComponent(lblNome)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTNomeEspecie,
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
				jBtPesquisarSubGenero.setEnabled(true);
				jBTCadSubGenero.setEnabled(true);
				lv.LimparView(jPCadastro);
				jTNomeEspecie.setEnabled(true);

			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EspecieBean newClasse = new EspecieBean();
					InterfaceEspecieController ifc = ControllerFactory
							.getInstance().getInterfaceEspecieController();
					if (jTIdEspecie.getText().equals("")) {
						newClasse.setNome(jTNomeEspecie.getText());
						InterfaceSubGeneroController ifs = ControllerFactory
								.getInstance()
								.getInterfaceSubGeneroController();
						SubGeneroBean newSubGenero = ifs.pesquisar((Long
								.parseLong(jTIdSubGenero.getText())));
						newClasse.setSubGenero(newSubGenero);
						long id = ifc.inserir(newClasse, true);
						if (id == -1) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro ao inserir o registro !");
							return;
						}
						jTIdEspecie.setText("" + id);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Gravado !");

					} else {
						newClasse.setNome(jTNomeEspecie.getText());
						newClasse.setId(Long.parseLong(jTIdEspecie.getText()));
						InterfaceSubGeneroController ifs = ControllerFactory
								.getInstance()
								.getInterfaceSubGeneroController();
						SubGeneroBean newSubGenero = ifs.pesquisar((Long
								.parseLong(jTIdSubGenero.getText())));
						newClasse.setSubGenero(newSubGenero);
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
					jBtPesquisarSubGenero.setEnabled(false);
					jBTCadSubGenero.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

					jTNomeEspecie.setEnabled(false);

				} catch (ValidationException e) {
					List<Report> erros = e.getErros();
					String report = "Seguintes erros foram encontrados : \n";
					for (Report r : erros) {
						report += r.getCampo() + " " + r.getErro() + "; \n";
					}
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
					jBtPesquisarSubGenero.setEnabled(true);
					jBTCadSubGenero.setEnabled(true);

					jTNomeEspecie.setEnabled(true);
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
				jBtPesquisarSubGenero.setEnabled(false);
				jBtEditar.setEnabled(false);

				jBTCadSubGenero.setEnabled(false);
				jBtCancelar.setEnabled(false);
				jBtNovo.setEnabled(true);

				jTNomeEspecie.setEnabled(false);

			}
		});

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceEspecieController ifc = ControllerFactory
							.getInstance().getInterfaceEspecieController();

					ifc.remover(Long.parseLong(jTIdEspecie.getText()));
					JOptionPane.showMessageDialog(rootPane,
							"Registro Excluido !");

					jBtExcluir.setEnabled(false);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtPesquisarSubGenero.setEnabled(false);
					jBTCadSubGenero.setEnabled(false);
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
						InterfaceEspecieController ifc = ControllerFactory
								.getInstance().getInterfaceEspecieController();
						List<EspecieBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (EspecieBean Especie : lista) {
							EspecieBean newEspecie = new EspecieBean();
							newEspecie.setId(Especie.getId());
							newEspecie.setNome(Especie.getNome());
							newEspecie.setSubGenero(Especie.getSubGenero());
							dtm.addRow(new Object[] { newEspecie.getId(),
									newEspecie.getNome(),
									newEspecie.getSubGenero().getNome() });
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
								"Digite um código");
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
						InterfaceEspecieController ifc = ControllerFactory
								.getInstance().getInterfaceEspecieController();
						List<EspecieBean> lista = ifc.pesquisar(
								jTPesquisa.getText(), true);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (EspecieBean classe : lista) {
							dtm.addRow(new Object[] { classe.getId(),
									classe.getNome(),
									classe.getSubGenero().getNome() });
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
					InterfaceEspecieController ifc = ControllerFactory
							.getInstance().getInterfaceEspecieController();

					int index = jTBPesquisa.getSelectedRow();
					Long id = (Long) jTBPesquisa.getValueAt(index, 0);
					EspecieBean classe = ifc.pesquisar(id);
					jTIdEspecie.setText("" + classe.getId());
					jTNomeEspecie.setText(classe.getNome());
					jTIdSubGenero.setText(classe.getSubGenero().getId() + "");
					jTDescSubGenero.setText(classe.getSubGenero().getNome());
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
				InterfaceEspecieController ifc = ControllerFactory
						.getInstance().getInterfaceEspecieController();
				int index = jTBPesquisa.getSelectedRow();
				Long id = (Long) jTBPesquisa.getValueAt(index, 0);
				EspecieBean classe = ifc.pesquisar(id);
				jTIdEspecie.setText("" + classe.getId());
				jTNomeEspecie.setText(classe.getNome());
				jTIdSubGenero.setText(classe.getSubGenero().getId() + "");
				jTDescSubGenero.setText(classe.getSubGenero().getNome());
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

	public void editar(EspecieBean aEspecie) {
		jTIdEspecie.setText("" + aEspecie.getId());
		jTNomeEspecie.setText(aEspecie.getNome());
		jTIdSubGenero.setText("" + aEspecie.getSubGenero().getId());
		jTDescSubGenero.setText(aEspecie.getSubGenero().getNome());
		jBtEditar.setEnabled(true);
		jBtExcluir.setEnabled(true);
		jBtSalvar.setEnabled(false);
		jBtNovo.setEnabled(true);
		jBtCancelar.setEnabled(false);

	}
}
