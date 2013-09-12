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

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceLocalizacaoController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceTriboController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public class LocalizacaoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTIdLocalizacao;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;
	private JTextField jTDescEstado;
	private JTextField jTDescMunicipio;

	private final JButton jBtNovo;
	private final JButton jBtEditar;
	private final JButton jBtSalvar;
	private final JButton jBtExcluir;
	private final JButton jBtCancelar;
	private JTextField jTDescPais;
	private JTextField jTDescFormacaoVegetal;
	private JTextField jTBioma;
	private JTextField jTLongitude;
	private JTextField jTFLatitude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalizacaoView frame = new LocalizacaoView();
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
	public LocalizacaoView() {
		super();
		final LimparView lv = new LimparView();
		setTitle("Cadastro Localizacao");
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
		final TriboPesquisaView pesquisaView = new TriboPesquisaView(this, true);
		pesquisaView.setVisible(false);

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
		jBtNovo = new JButton("Novo");
		jBtEditar = new JButton("Editar");

		jBtSalvar = new JButton("Salvar");

		jBtExcluir = new JButton("Excluir");

		jBtCancelar = new JButton("Cancelar");

		final JPanel jPCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, jPCadastro, null);

		JLabel label = new JLabel("Id");

		jTIdLocalizacao = new JTextField();
		jTIdLocalizacao.setEnabled(false);
		jTIdLocalizacao.setColumns(10);

		JPanel panel = new JPanel();

		JLabel Estado = new JLabel("Estado");

		jTDescEstado = new JTextField();
		jTDescEstado.setEnabled(false);
		jTDescEstado.setColumns(10);

		JLabel lblIdTribo = new JLabel("Municipo");

		jTDescMunicipio = new JTextField();
		jTDescMunicipio.setEditable(false);
		jTDescMunicipio.setEnabled(false);
		jTDescMunicipio.setColumns(10);

		JLabel lblPais = new JLabel("Pais");

		jTDescPais = new JTextField();
		jTDescPais.setEnabled(false);
		jTDescPais.setColumns(10);

		JLabel lblNewLabel = new JLabel("Forma\u00E7\u00E3o Vegetal");

		jTDescFormacaoVegetal = new JTextField();
		jTDescFormacaoVegetal.setEnabled(false);
		jTDescFormacaoVegetal.setColumns(10);

		jTBioma = new JTextField();
		jTBioma.setEnabled(false);
		jTBioma.setColumns(10);

		JLabel lblBioma = new JLabel("Bioma");

		jTLongitude = new JTextField();
		jTLongitude.setEnabled(false);
		jTLongitude.setColumns(10);

		JLabel lblLongitude = new JLabel("Longitude");

		jTFLatitude = new JTextField();
		jTFLatitude.setEnabled(false);
		jTFLatitude.setColumns(10);

		JLabel jLLatitude = new JLabel("Latitude");
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
																				jTIdLocalizacao,
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
																				Estado)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				410,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblPais,
																				GroupLayout.PREFERRED_SIZE,
																				33,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(215))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPCadastro
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								lblIdTribo)
																						.addComponent(
																								jTDescMunicipio)
																						.addComponent(
																								jTDescEstado,
																								GroupLayout.PREFERRED_SIZE,
																								429,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTDescPais,
																				GroupLayout.PREFERRED_SIZE,
																				173,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(79))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPCadastro
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								jTDescFormacaoVegetal,
																								GroupLayout.PREFERRED_SIZE,
																								429,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_jPCadastro
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_jPCadastro
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblBioma,
																												GroupLayout.PREFERRED_SIZE,
																												33,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jTBioma,
																								GroupLayout.PREFERRED_SIZE,
																								173,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				79,
																				Short.MAX_VALUE))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPCadastro
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jTFLatitude,
																								GroupLayout.PREFERRED_SIZE,
																								173,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTLongitude,
																								GroupLayout.PREFERRED_SIZE,
																								173,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPCadastro
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												jLLatitude,
																												GroupLayout.PREFERRED_SIZE,
																												93,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_jPCadastro
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblLongitude,
																												GroupLayout.PREFERRED_SIZE,
																												126,
																												GroupLayout.PREFERRED_SIZE)))
																		.addContainerGap(
																				518,
																				Short.MAX_VALUE)))));
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
										.addComponent(jTIdLocalizacao,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblIdTribo)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTDescMunicipio,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(Estado)
														.addComponent(lblPais))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTDescEstado,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTDescPais,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				jTDescFormacaoVegetal,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPCadastro
																		.createSequentialGroup()
																		.addComponent(
																				lblBioma)
																		.addGap(6)
																		.addComponent(
																				jTBioma,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(jLLatitude)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTFLatitude,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblLongitude)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTLongitude,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												194, Short.MAX_VALUE)
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

		// Acoes dos botoes

		jBtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBtSalvar.setEnabled(true);
				jBtCancelar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtExcluir.setEnabled(false);
				jBtEditar.setEnabled(false);

				lv.LimparView(jPCadastro);
				jTDescEstado.setEnabled(true);
				jTBioma.setEnabled(true);
				jTDescMunicipio.setEnabled(true);
				jTDescPais.setEnabled(true);
				jTFLatitude.setEnabled(true);
				jTLongitude.setEnabled(true);
				jTDescFormacaoVegetal.setEnabled(true);
				jTDescMunicipio.setEnabled(false);
			
				
			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LocalizacaoBean newLocalizacao = new LocalizacaoBean();
					InterfaceLocalizacaoController ifc = ControllerFactory
							.getInstance().getInterfaceLocalizacaoController();
					if (jTIdLocalizacao.getText().equals("")) {
						long id = ifc.inserir(newLocalizacao);
						if (id == -1) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro ao inserir o registro !");
							return;
						}
						jTIdLocalizacao.setText("" + id);
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Gravado !");

					} else {
						newLocalizacao.setId(Long.parseLong(jTIdLocalizacao
								.getText()));
						InterfaceTriboController ifs = ControllerFactory
								.getInstance().getInterfaceTriboController();
						TriboBean newTribo = ifs.pesquisar((Long
								.parseLong(jTDescMunicipio.getText())));
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						ifc.atualizar(newLocalizacao);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Atualizado !");

						jBtExcluir.setEnabled(false);

					}
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

					jTDescEstado.setEnabled(false);

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

					jTDescEstado.setEnabled(true);
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
				jBtEditar.setEnabled(false);

				jBtCancelar.setEnabled(false);
				jBtNovo.setEnabled(true);

				jTDescEstado.setEnabled(false);

			}
		});

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceLocalizacaoController ifc = ControllerFactory
							.getInstance().getInterfaceLocalizacaoController();

					ifc.remover(Long.parseLong(jTIdLocalizacao.getText()));
					JOptionPane.showMessageDialog(rootPane,
							"Registro Excluido !");

					jBtExcluir.setEnabled(false);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
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
		tabbedPane.addTab("Pesquisa", null, jPPesquisa, null);

		final JComboBox<Object> jCPesquisa = new JComboBox<Object>();
		jCPesquisa.setModel(new DefaultComboBoxModel(new String[] { "Geral",
				"C\u00F3digo" }));

		jTPesquisa = new JTextField();
		jTPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (jCPesquisa.getSelectedIndex()) {
				case 0: {
					try {
						InterfaceLocalizacaoController ifc = ControllerFactory
								.getInstance()
								.getInterfaceLocalizacaoController();
						List<LocalizacaoBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (LocalizacaoBean Localizacao : lista) {
							LocalizacaoBean newLocalizacao = Localizacao;
							dtm.addRow(new Object[] { newLocalizacao.getId(),
									newLocalizacao.getLatitude(),
									newLocalizacao.getLongitude() });
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
							InterfaceLocalizacaoController ifc = ControllerFactory
									.getInstance()
									.getInterfaceLocalizacaoController();
							LocalizacaoBean newLocalizacao = ifc.pesquisar(id);
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);
							dtm.addRow(new Object[] { newLocalizacao.getId(),
									newLocalizacao.getLatitude(),
									newLocalizacao.getLongitude() });

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
					InterfaceLocalizacaoController ifc = ControllerFactory
							.getInstance().getInterfaceLocalizacaoController();

					int index = jTBPesquisa.getSelectedRow();
					Long id = (Long) jTBPesquisa.getValueAt(index, 0);
					LocalizacaoBean Localizacao = ifc.pesquisar(id);
					jTIdLocalizacao.setText("" + Localizacao.getId());
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
				InterfaceLocalizacaoController ifc = ControllerFactory
						.getInstance().getInterfaceLocalizacaoController();
				int index = jTBPesquisa.getSelectedRow();
				Long id = (Long) jTBPesquisa.getValueAt(index, 0);
				LocalizacaoBean Localizacao = ifc.pesquisar(id);
				jTIdLocalizacao.setText("" + Localizacao.getId());
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
}
