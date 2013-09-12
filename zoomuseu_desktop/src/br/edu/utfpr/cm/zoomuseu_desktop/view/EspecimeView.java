package br.edu.utfpr.cm.zoomuseu_desktop.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.ClassificacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.ImagemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceEspecieController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceEspecimeController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceFamiliaController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceFiloController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceGeneroController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceInfraClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceLocalizacaoController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceOrdemController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubClasseController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubEspecieController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubFamiliaController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubFiloController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubGeneroController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSubOrdemController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceSuperFamiliaController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceTriboController;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceVariedadeController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_desktop.util.ConstruirJtree;
import br.edu.utfpr.cm.zoomuseu_desktop.util.ConversorImagem;

public class EspecimeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConstruirJtree att;
	private JTextField textField;
	private JTable jTablePesquisa;
	private ClassificacaoBean classificacaoTaxonomica;

	public JTree jTreeClassificacao;
	private JTextField jTiDEspecime;
	private JTextField jTDescColetor;
	private JFormattedTextField jTfDataColeta;
	private JTextField jTEstagioDesenvolvimento;
	private JTextField jTLocalizacaoid;
	private JTextField jTDescLocalizacao;
	private JTextField jTClassificacao;
	JLabel jLImagem;
	JLabel jLQtFotos;
	private JTextField jTPesquisaJtree;
	private JTextField jTHabitat;
	private ArrayList<ImagemBean> GaleriaImagem;
	private JTextField jTDescricaoImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspecimeView frame = new EspecimeView();
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
	public EspecimeView() {
		att = new ConstruirJtree();
		setTitle("Cadastro Esp\u00E9cime");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 618);
		final LimparView lv = new LimparView();
		GaleriaImagem = new ArrayList<ImagemBean>(10);
		contentPane = new JPanel();
		jLImagem = new JLabel();
		jLImagem.setHorizontalAlignment(SwingConstants.CENTER);
		jLImagem.setHorizontalTextPosition(SwingConstants.CENTER);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		final JTabbedPane jTPCadastroEdicao = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Cadastro/Edi\u00E7\u00E3o", null, jTPCadastroEdicao,
				null);
		tabbedPane.setEnabledAt(0, true);

		JPanel jPClassificacao = new JPanel();
		jTPCadastroEdicao.addTab("Classifica\u00E7\u00E3o", null,
				jPClassificacao, null);

		JLabel lblClassificacao = new JLabel("Classifica\u00E7\u00E3o");

		JScrollPane scrollPane = new JScrollPane();

		JButton jBTSelecionarTaxon = new JButton("Usar Sele\u00E7\u00E3o");

		jTPesquisaJtree = new JTextField();

		jTPesquisaJtree.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pesquisa na \u00E1rvore :");
		GroupLayout gl_jPClassificacao = new GroupLayout(jPClassificacao);
		gl_jPClassificacao
				.setHorizontalGroup(gl_jPClassificacao
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_jPClassificacao
										.createSequentialGroup()
										.addGroup(
												gl_jPClassificacao
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPClassificacao
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblClassificacao)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				362,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblNewLabel_1)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				jTPesquisaJtree,
																				GroupLayout.PREFERRED_SIZE,
																				167,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																703,
																Short.MAX_VALUE)
														.addGroup(
																gl_jPClassificacao
																		.createSequentialGroup()
																		.addGap(303)
																		.addComponent(
																				jBTSelecionarTaxon,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(303)))
										.addContainerGap()));
		gl_jPClassificacao
				.setVerticalGroup(gl_jPClassificacao
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPClassificacao
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPClassificacao
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblClassificacao)
														.addComponent(
																jTPesquisaJtree,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 414,
												Short.MAX_VALUE).addGap(11)
										.addComponent(jBTSelecionarTaxon)
										.addContainerGap()));

		jTreeClassificacao = new JTree();

		jTreeClassificacao.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		scrollPane.setViewportView(jTreeClassificacao);

		jTreeClassificacao.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Reino") {
					/**
				 * 
				 */
					private static final long serialVersionUID = 1L;

					{

					}
				}));
		popUp(jTreeClassificacao);
		jPClassificacao.setLayout(gl_jPClassificacao);

		att.atualizarJtree(jTreeClassificacao);

		final JPanel jPCartaoColeta = new JPanel();
		jTPCadastroEdicao.addTab("Cart\u00E3o Coleta", null, jPCartaoColeta,
				null);
		jTPCadastroEdicao.setEnabledAt(1, false);

		JLabel lblId = new JLabel("id");

		jTiDEspecime = new JTextField();
		jTiDEspecime.setEnabled(false);
		jTiDEspecime.setColumns(10);

		JLabel lblColetor = new JLabel("Coletor");

		jTDescColetor = new JTextField();
		jTDescColetor.setEnabled(false);
		jTDescColetor.setColumns(10);

		JLabel lblDataDaColeta = new JLabel("Data da Coleta");

		MaskFormatter mf;

		try {
			mf = new MaskFormatter("##/##/####");
			mf.setValidCharacters("0123456789");
			jTfDataColeta = new JFormattedTextField(mf);
			jTfDataColeta.setEnabled(false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNomesPopulares = new JLabel(
				"Nomes Populares (Separe os nomes por virgula(,))");

		final JTextArea jTANomesPopulares = new JTextArea();
		jTANomesPopulares.setEnabled(false);

		JLabel lblEstgioDeDesenvolvimento = new JLabel(
				"Est\u00E1gio de Desenvolvimento");

		jTEstagioDesenvolvimento = new JTextField();
		jTEstagioDesenvolvimento.setEnabled(false);
		jTEstagioDesenvolvimento.setColumns(10);

		final JTextArea jTAOutros = new JTextArea();
		jTAOutros.setColumns(420);
		jTAOutros.setRows(6);
		jTAOutros.setEnabled(false);

		JLabel lblOutros = new JLabel("Outros");

		JLabel lblClassficao = new JLabel("Taxon");

		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o id");

		jTLocalizacaoid = new JTextField();
		jTLocalizacaoid.setEnabled(false);
		jTLocalizacaoid.setColumns(10);

		JLabel lblDescrio = new JLabel(
				"Descri\u00E7\u00E3o Localiza\u00E7\u00E3o");

		jTDescLocalizacao = new JTextField();
		jTDescLocalizacao.setEnabled(false);
		jTDescLocalizacao.setColumns(10);

		final JButton jBtNovoLocalizacao = new JButton("Novo");
		jBtNovoLocalizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalizacaoView view = new LocalizacaoView();
				view.setVisible(true);
				view.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosed(java.awt.event.WindowEvent evt) {
						tabbedPane.setSelectedComponent(jPCartaoColeta);

					}
				});
			}
		});
		jBtNovoLocalizacao.setEnabled(false);

		final JButton jBtPesquisarLocalizacao = new JButton("Pesquisar");
		jBtPesquisarLocalizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalizacaoView locview = new LocalizacaoView();

			}
		});
		jBtPesquisarLocalizacao.setEnabled(false);

		JPanel panel_1 = new JPanel();

		final JButton jBtNovo = new JButton("Novo");

		jBtNovo.setPreferredSize(new Dimension(73, 23));
		jBtNovo.setEnabled(false);
		panel_1.add(jBtNovo);

		final JButton jBtEditar = new JButton("Editar");
		final JButton jBtExcluir = new JButton("Excluir");
		jBtEditar.setPreferredSize(new Dimension(73, 23));
		jBtEditar.setEnabled(false);
		panel_1.add(jBtEditar);

		final JButton jBtSalvar = new JButton("Salvar");

		jBtSalvar.setPreferredSize(new Dimension(73, 23));
		jBtSalvar.setEnabled(false);
		panel_1.add(jBtSalvar);
		final JButton jBtCancelar = new JButton("Cancelar");
		jBtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lv.LimparView(jPCartaoColeta);
				jBtExcluir.setEnabled(false);
				jBtSalvar.setEnabled(false);
				jBtNovo.setEnabled(true);
				jBtPesquisarLocalizacao.setEnabled(false);
				jBtEditar.setEnabled(false);
				jBtCancelar.setEnabled(false);
				jTPCadastroEdicao.setEnabledAt(2, false);
				jTfDataColeta.setEnabled(false);
				jTDescColetor.setEnabled(false);
				jBtPesquisarLocalizacao.setEnabled(false);
				jBtNovoLocalizacao.setEnabled(false);
				jTEstagioDesenvolvimento.setEnabled(false);
				jTHabitat.setEnabled(false);
				jTEstagioDesenvolvimento.setEnabled(false);
				jTANomesPopulares.setEnabled(false);
				jTAOutros.setEnabled(false);

			}
		});
		jBtCancelar.setEnabled(false);

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceEspecimeController ifc = ControllerFactory
							.getInstance().getInterfaceEspecimeController();

					ifc.remover(Long.parseLong(jTiDEspecime.getText()));
					JOptionPane.showMessageDialog(rootPane,
							"Registro Excluido !");

					jBtExcluir.setEnabled(false);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtPesquisarLocalizacao.setEnabled(false);
					jBtNovoLocalizacao.setEnabled(false);
					jBtEditar.setEnabled(false);
					jBtCancelar.setEnabled(false);
					lv.LimparView(jPCartaoColeta);
					DefaultTableModel dtm = (DefaultTableModel) jTablePesquisa
							.getModel();
					dtm.setRowCount(0);

					jTfDataColeta.setEnabled(false);
					jTDescColetor.setEnabled(false);
					jBtPesquisarLocalizacao.setEnabled(false);
					jBtNovoLocalizacao.setEnabled(false);
					jTEstagioDesenvolvimento.setEnabled(false);
					jTHabitat.setEnabled(false);
					jTEstagioDesenvolvimento.setEnabled(false);
					jTANomesPopulares.setEnabled(false);
					jTAOutros.setEnabled(false);
					jTPCadastroEdicao.setEnabledAt(2, false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane,
							"Erro na exclusão !");
				}

			}
		});
		jBtExcluir.setPreferredSize(new Dimension(73, 23));
		jBtExcluir.setEnabled(false);
		panel_1.add(jBtExcluir);
		panel_1.add(jBtCancelar);
		jBtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBtSalvar.setEnabled(true);
				jBtCancelar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtEditar.setEnabled(false);

				jBtExcluir.setEnabled(false);
				lv.LimparView(jPCartaoColeta);
				jBtNovoLocalizacao.setEnabled(true);
				jBtPesquisarLocalizacao.setEnabled(true);

				// Campos
				jTPCadastroEdicao.setEnabledAt(2, true);

				ConstruirJtree cj = new ConstruirJtree();
				jTClassificacao.setText(cj.construirClassificacao(
						jTreeClassificacao).getUltimaClassificacao());
				jTfDataColeta.setEnabled(true);
				jTDescColetor.setEnabled(true);
				jBtPesquisarLocalizacao.setEnabled(true);
				jBtNovoLocalizacao.setEnabled(true);
				jTEstagioDesenvolvimento.setEnabled(true);
				jTHabitat.setEnabled(true);
				jTEstagioDesenvolvimento.setEnabled(true);
				jTANomesPopulares.setEnabled(true);
				jTAOutros.setEnabled(true);

			}
		});
		jBtEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBtSalvar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtCancelar.setEnabled(true);
				jBtEditar.setEnabled(false);
				jBtNovoLocalizacao.setEnabled(true);
				jBtPesquisarLocalizacao.setEnabled(true);
				jTPCadastroEdicao.setEnabledAt(2, true);

				// Campos

				jTfDataColeta.setEnabled(true);
				jTDescColetor.setEnabled(true);
				jTEstagioDesenvolvimento.setEnabled(true);
				jTANomesPopulares.setEnabled(true);
				jTAOutros.setEnabled(true);
			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EspecimeBean newClasse = new EspecimeBean();
					InterfaceEspecimeController ifc = ControllerFactory
							.getInstance().getInterfaceEspecimeController();
					if (jTiDEspecime.getText().equals("")) {
						newClasse.setNomesPopulares(jTANomesPopulares.getText());
						newClasse.setClassificacao(classificacaoTaxonomica);
						newClasse.setColetor(jTDescColetor.getText());

						if (!jTfDataColeta.getText().equals("")) {
							Date dataColeta = new Date(jTfDataColeta.getText());
							newClasse.setDataColeta(dataColeta);
						}
						newClasse
								.setEstagioDesenvolvimento(jTEstagioDesenvolvimento
										.getText());
						newClasse.setHabitat(jTHabitat.getText());
						// Interface
						LocalizacaoBean loc = new LocalizacaoBean();
						if (!jTLocalizacaoid.getText().equals("")) {
							InterfaceLocalizacaoController ilc = ControllerFactory
									.getInstance()
									.getInterfaceLocalizacaoController();
							loc = ilc.pesquisar(Integer
									.parseInt(jTLocalizacaoid.getText()));
						}
						newClasse.setLocalizacao(loc);
						newClasse.setNomesPopulares(jTANomesPopulares.getText());
						newClasse.setOutros(jTAOutros.getText());
						// Array de imagens
						newClasse.setImagens(GaleriaImagem);

						long id = ifc.inserir(newClasse);
						if (id == -1) {
							JOptionPane.showMessageDialog(rootPane,
									"Erro ao inserir o registro !");
							return;
						}
						jTiDEspecime.setText("" + id);
						DefaultTableModel dtm = (DefaultTableModel) jTablePesquisa
								.getModel();
						dtm.setRowCount(0);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Gravado !");

					} else {
						newClasse.setNomesPopulares(jTANomesPopulares.getText());
						newClasse.setClassificacao(classificacaoTaxonomica);
						newClasse.setColetor(jTDescColetor.getText());
						Date dataColeta = new Date(jTfDataColeta.getText());
						newClasse.setDataColeta(dataColeta);
						newClasse
								.setEstagioDesenvolvimento(jTEstagioDesenvolvimento
										.getText());
						newClasse.setHabitat(jTHabitat.getText());
						// Interface
						LocalizacaoBean loc = new LocalizacaoBean();
						if (jTLocalizacaoid.getText() != "") {
							InterfaceLocalizacaoController ilc = ControllerFactory
									.getInstance()
									.getInterfaceLocalizacaoController();
							loc = ilc.pesquisar(Integer
									.parseInt(jTLocalizacaoid.getText()));
						}

						newClasse.setLocalizacao(loc);
						newClasse.setNomesPopulares(jTANomesPopulares.getText());
						newClasse.setOutros(jTAOutros.getText());
						// Array de imagens
						newClasse.setImagens(GaleriaImagem);

						DefaultTableModel dtm = (DefaultTableModel) jTablePesquisa
								.getModel();
						dtm.setRowCount(0);
						ifc.atualizar(newClasse);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Atualizado !");

					}
					jTPCadastroEdicao.setEnabledAt(2, false);
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

				} catch (ValidationException em) {
					java.util.List<Report> erros = em.getErros();
					String report = "Seguintes erros foram encontrados : \n";
					for (Report r : erros) {
						report += r.getCampo() + " " + r.getErro() + "; \n";
					}
					JOptionPane.showMessageDialog(rootPane,
							report.toUpperCase());

				}
			}
		});

		jTClassificacao = new JTextField();
		jTClassificacao.setEditable(false);
		jTClassificacao.setEnabled(false);
		jTClassificacao.setColumns(10);
		final JLabel jLbIndexFoto = new JLabel("0");

		JLabel lblHabitat = new JLabel("Habitat");

		jTHabitat = new JTextField();
		jTHabitat.setEnabled(false);
		jTHabitat.setColumns(10);
		GroupLayout gl_jPCartaoColeta = new GroupLayout(jPCartaoColeta);
		gl_jPCartaoColeta
				.setHorizontalGroup(gl_jPCartaoColeta
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPCartaoColeta
										.createSequentialGroup()
										.addGroup(
												gl_jPCartaoColeta
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addGap(159)
																		.addComponent(
																				panel_1,
																				GroupLayout.PREFERRED_SIZE,
																				412,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_jPCartaoColeta
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblColetor)
																						.addComponent(
																								lblId)
																						.addComponent(
																								jTiDEspecime,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPCartaoColeta
																										.createSequentialGroup()
																										.addGroup(
																												gl_jPCartaoColeta
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																jTEstagioDesenvolvimento)
																														.addComponent(
																																jTDescColetor,
																																GroupLayout.DEFAULT_SIZE,
																																532,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPCartaoColeta
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblDataDaColeta)
																														.addComponent(
																																jTfDataColeta,
																																GroupLayout.PREFERRED_SIZE,
																																158,
																																GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								gl_jPCartaoColeta
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblEstgioDeDesenvolvimento))
																						.addGroup(
																								gl_jPCartaoColeta
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblNomesPopulares))
																						.addComponent(
																								lblOutros,
																								GroupLayout.PREFERRED_SIZE,
																								241,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPCartaoColeta
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												jTANomesPopulares,
																												GroupLayout.PREFERRED_SIZE,
																												676,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								lblClassficao)
																						.addGroup(
																								gl_jPCartaoColeta
																										.createSequentialGroup()
																										.addGroup(
																												gl_jPCartaoColeta
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																jTLocalizacaoid,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblLocalizao))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												jBtNovoLocalizacao,
																												GroupLayout.PREFERRED_SIZE,
																												73,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												jBtPesquisarLocalizacao)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPCartaoColeta
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																jTDescLocalizacao,
																																GroupLayout.PREFERRED_SIZE,
																																409,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblDescrio)))))
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jTClassificacao,
																				GroupLayout.PREFERRED_SIZE,
																				531,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jTAOutros,
																				GroupLayout.PREFERRED_SIZE,
																				678,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblHabitat))
														.addGroup(
																gl_jPCartaoColeta
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jTHabitat,
																				GroupLayout.DEFAULT_SIZE,
																				667,
																				Short.MAX_VALUE)))
										.addGap(14)));
		gl_jPCartaoColeta
				.setVerticalGroup(gl_jPCartaoColeta
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPCartaoColeta
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblId)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTiDEspecime,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCartaoColeta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblColetor)
														.addComponent(
																lblDataDaColeta))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCartaoColeta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTDescColetor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTfDataColeta,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(
												lblEstgioDeDesenvolvimento)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTEstagioDesenvolvimento,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblClassficao)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTClassificacao,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jPCartaoColeta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblLocalizao)
														.addComponent(
																lblDescrio))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_jPCartaoColeta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTLocalizacaoid,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBtNovoLocalizacao)
														.addComponent(
																jBtPesquisarLocalizacao)
														.addComponent(
																jTDescLocalizacao,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblHabitat)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTHabitat,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNomesPopulares)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTANomesPopulares,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblOutros)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jTAOutros,
												GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_1,
												GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20)));
		jPCartaoColeta.setLayout(gl_jPCartaoColeta);

		final JPanel jPGaleriaFotos = new JPanel();
		jTPCadastroEdicao.addTab("Imagens", null, jPGaleriaFotos, null);
		jTPCadastroEdicao.setEnabledAt(2, false);
		jLQtFotos = new JLabel("Capacidade de Fotos :  0/10");
		jLQtFotos.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblFotoN = new JLabel("Foto n :");
		lblFotoN.setHorizontalAlignment(SwingConstants.RIGHT);

		jBTSelecionarTaxon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Criacao do bean Classificacao
				jTreeClassificacao.getSelectionPath();
				classificacaoTaxonomica = null;
				ConstruirJtree cJtree = new ConstruirJtree();
				classificacaoTaxonomica = cJtree
						.construirClassificacao(jTreeClassificacao);
				if (classificacaoTaxonomica != null) {
					jTClassificacao.setText(classificacaoTaxonomica
							.getUltimaClassificacao());

					jPCartaoColeta.setEnabled(true);
					jTPCadastroEdicao.setEnabledAt(1, true);
					jPGaleriaFotos.setEnabled(true);
					jBtNovo.setEnabled(true);
				} else {
					JOptionPane
							.showMessageDialog(rootPane,
									"Selecione um taxon pelo menos até o nivel de Classe!");
				}
			}
		});
		final JPopupMenu popupImg = new JPopupMenu();
		JMenuItem mi = new JMenuItem("Inserir nova...");
		final ConversorImagem cI = new ConversorImagem();
		/* *Implementaçao popup nova Foto* */
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Implementar
				if (GaleriaImagem.size() == 10) {
					JOptionPane.showMessageDialog(rootPane,
							"São permitidas apenas 10 fotos!");
				} else {
					// Create a file chooser
					final JFileChooser fc = new JFileChooser();
					fc.setFileFilter(cI.getFilter());
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int res = fc.showOpenDialog(null);
					ImagemBean img = new ImagemBean();
					if (res == JFileChooser.APPROVE_OPTION) {

						File f = fc.getSelectedFile();
						String path = f.getAbsolutePath();
						try {

							img.setImagem(cI.imageToByte(path));

						} catch (IOException e) {

						}
						jTDescricaoImagem.setEnabled(true);
						img.setId(GaleriaImagem.size() + 1);
						GaleriaImagem.add(img);
						try {
							System.out.print("size " + GaleriaImagem.size());
							jLQtFotos.setText("Capacidade de Fotos :  "
									+ GaleriaImagem.size() + "/10");
							jLbIndexFoto.setText("" + (GaleriaImagem.size()));
							jLImagem.setIcon(cI.ByteToImage(img.getImagem()));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}
		});
		popupImg.add(mi);
		mi = new JMenuItem("Excluir");

		/* *Implementaçao popup excluir Foto* */

		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = Integer.parseInt(jLbIndexFoto.getText()) - 1;
				GaleriaImagem.remove(index);

				JOptionPane.showMessageDialog(rootPane, "Foto removida!");
				if (GaleriaImagem.size() > 0) {
					try {
						jLImagem.setIcon(cI.ByteToImage(GaleriaImagem.get(
								index - 1).getImagem()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
					jLbIndexFoto.setText("" + GaleriaImagem.size());
				} else {
					jLImagem.setIcon(null);
				}
				jLQtFotos.setText("Capacidade de Fotos :  "
						+ GaleriaImagem.size() + "/10");

			}

		});
		popupImg.add(mi);

		JButton btnNewButton = new JButton("<--");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setMnemonic(KeyEvent.VK_LEFT);

		JButton button = new JButton("-->");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setMnemonic(KeyEvent.VK_RIGHT);

		JButton button_5 = new JButton("?");
		button_5.setHorizontalAlignment(SwingConstants.LEFT);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								rootPane,
								"Para navegar entre as fotos use \n alt + seta para a direita ou esquerda,\n"
										+ "para inserir/excluir fotos clique com o botão direito sobre o painel.");

			}
		});

		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio_1.setHorizontalAlignment(SwingConstants.LEFT);

		jTDescricaoImagem = new JTextField();
		jTDescricaoImagem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				GaleriaImagem.get(Integer.parseInt(jLbIndexFoto.getText()) - 1)
						.setDescricao(jTDescricaoImagem.getText());
			}
		});
		jTDescricaoImagem.setHorizontalAlignment(SwingConstants.LEFT);
		jTDescricaoImagem.setEnabled(false);
		jTDescricaoImagem.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_jPGaleriaFotos = new GroupLayout(jPGaleriaFotos);
		gl_jPGaleriaFotos
				.setHorizontalGroup(gl_jPGaleriaFotos
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPGaleriaFotos
										.createSequentialGroup()
										.addGroup(
												gl_jPGaleriaFotos
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				lblDescrio_1)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				jTDescricaoImagem,
																				GroupLayout.DEFAULT_SIZE,
																				635,
																				Short.MAX_VALUE))
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				button_5)
																		.addGap(219)
																		.addComponent(
																				btnNewButton,
																				GroupLayout.DEFAULT_SIZE,
																				51,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				button,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(190)
																		.addComponent(
																				jLQtFotos))
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addGap(631)
																		.addComponent(
																				lblFotoN)
																		.addGap(18)
																		.addComponent(
																				jLbIndexFoto,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scrollPane_2,
																				GroupLayout.DEFAULT_SIZE,
																				701,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gl_jPGaleriaFotos
				.setVerticalGroup(gl_jPGaleriaFotos
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPGaleriaFotos
										.createSequentialGroup()
										.addGroup(
												gl_jPGaleriaFotos
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLbIndexFoto,
																GroupLayout.PREFERRED_SIZE,
																14,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblFotoN))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane_2,
												GroupLayout.DEFAULT_SIZE, 410,
												Short.MAX_VALUE)
										.addGap(18)
										.addGroup(
												gl_jPGaleriaFotos
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTDescricaoImagem,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDescrio_1))
										.addGap(11)
										.addGroup(
												gl_jPGaleriaFotos
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_jPGaleriaFotos
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								button_5)
																						.addComponent(
																								button)
																						.addComponent(
																								btnNewButton)))
														.addGroup(
																gl_jPGaleriaFotos
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLQtFotos)))
										.addContainerGap()));
		jLImagem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		scrollPane_2.setViewportView(jLImagem);
		jPGaleriaFotos.setLayout(gl_jPGaleriaFotos);

		JPanel jPPesquisaEspecime = new JPanel();
		jPPesquisaEspecime.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				if (jBtSalvar.isEnabled()) {
					JOptionPane.showMessageDialog(rootPane,
							"Cadastro em andamento!");
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		tabbedPane.addTab("Pesquisa", null, jPPesquisaEspecime, null);

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Codigo" }));

		textField = new JTextField();
		textField.setColumns(10);

		JButton jBtPesquisar = new JButton("Pesquisar");

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_jPPesquisaEspecime = new GroupLayout(jPPesquisaEspecime);
		gl_jPPesquisaEspecime
				.setHorizontalGroup(gl_jPPesquisaEspecime
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPPesquisaEspecime
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPPesquisaEspecime
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane_1,
																GroupLayout.DEFAULT_SIZE,
																681,
																Short.MAX_VALUE)
														.addGroup(
																gl_jPPesquisaEspecime
																		.createSequentialGroup()
																		.addComponent(
																				comboBox,
																				GroupLayout.PREFERRED_SIZE,
																				83,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				textField,
																				GroupLayout.DEFAULT_SIZE,
																				503,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				jBtPesquisar)))
										.addContainerGap()));
		gl_jPPesquisaEspecime
				.setVerticalGroup(gl_jPPesquisaEspecime
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPPesquisaEspecime
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPPesquisaEspecime
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBtPesquisar))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane_1,
												GroupLayout.DEFAULT_SIZE, 379,
												Short.MAX_VALUE)
										.addContainerGap()));

		jTablePesquisa = new JTable();
		scrollPane_1.setViewportView(jTablePesquisa);
		jPPesquisaEspecime.setLayout(gl_jPPesquisaEspecime);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING,
				GroupLayout.PREFERRED_SIZE, 717, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = Integer.parseInt(jLbIndexFoto.getText());
				if (GaleriaImagem.size() != 1) {
					if (index == GaleriaImagem.size()) {
						try {
							jLImagem.setIcon(cI.ByteToImage(GaleriaImagem
									.get(0).getImagem()));
							index = 0;
							jTDescricaoImagem.setText(GaleriaImagem.get(0)
									.getDescricao());

						} catch (Exception e) {
						}

					} else {
						try {
							jTDescricaoImagem.setText(GaleriaImagem.get(index)
									.getDescricao());
							jLImagem.setIcon(cI.ByteToImage(GaleriaImagem.get(
									index).getImagem()));
						} catch (Exception e) {
						}

					}
					jLbIndexFoto.setText("" + (index + 1));
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.parseInt(jLbIndexFoto.getText());
				if (GaleriaImagem.size() != 1) {
					if (index == 1) {
						try {
							jLImagem.setIcon(cI.ByteToImage(GaleriaImagem.get(
									GaleriaImagem.size() - 1).getImagem()));
							jTDescricaoImagem.setText(GaleriaImagem.get(
									GaleriaImagem.size() - 1).getDescricao());
							index = GaleriaImagem.size() + 1;
						} catch (Exception e) {
						}

					} else {
						try {
							jTDescricaoImagem.setText(GaleriaImagem.get(
									GaleriaImagem.size() - 2).getDescricao());

							jLImagem.setIcon(cI.ByteToImage(GaleriaImagem.get(
									index - 2).getImagem()));
						} catch (Exception e) {
						}

					}
					jLbIndexFoto.setText("" + (index - 1));
				}
			}
		});
		jLImagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupImg.show((JComponent) e.getSource(), e.getX(),
							e.getY());
				}
			}
		});
	}

	private void popUp(final JTree aTree) {

		final JPopupMenu popup = new JPopupMenu();
		JMenuItem mi = new JMenuItem("Inserir novo...");
		final FiloView filoV = new FiloView(this, false);
		filoV.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent e) {
				att.atualizarJtree(aTree);
			}
		});
		/* *Implementaçao popup novo* */

		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) aTree
						.getLastSelectedPathComponent();
				String nome = node.toString();

				if (nome.equals("Filos") || (node.isRoot())) {

					filoV.setVisible(true);
				} else if (nome.equals("SubFilos")
						|| node.getParent().toString().equals("Filos")) {
					SubFiloView subfiloV = new SubFiloView();
					subfiloV.setVisible(true);
					subfiloV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("Classes")
						|| node.getParent().toString().equals("SubFilos")) {
					ClasseView classeV = new ClasseView();
					classeV.setVisible(true);
					classeV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("SubClasses")
						|| node.getParent().toString().equals("Classes")) {
					SubClasseView subclasseV = new SubClasseView();
					subclasseV.setVisible(true);
					subclasseV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});

				} else if (nome.equals("InfraClasses")
						|| node.getParent().toString().equals("SubClasses")) {
					InfraClasseView InfraclasseV = new InfraClasseView();
					InfraclasseV.setVisible(true);
					InfraclasseV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("Ordens")
						|| node.getParent().toString().equals("InfraClasses")) {
					OrdemView ordemV = new OrdemView();
					ordemV.setVisible(true);
					ordemV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("SubOrdens")
						|| node.getParent().toString().equals("Ordens")) {
					SubOrdemView subordemV = new SubOrdemView();
					subordemV.setVisible(true);
					subordemV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("SuperFamilias")
						|| node.getParent().toString().equals("SubOrdens")) {
					SuperFamiliaView SuperFamiliaV = new SuperFamiliaView();
					SuperFamiliaV.setVisible(true);
					SuperFamiliaV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("Familias")
						|| node.getParent().toString().equals("SuperFamilias")) {
					FamiliaView FamiliaV = new FamiliaView();
					FamiliaV.setVisible(true);
					FamiliaV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("SubFamilias")
						|| node.getParent().toString().equals("Familias")) {
					SubFamiliaView SubFamiliaV = new SubFamiliaView();
					SubFamiliaV.setVisible(true);
					SubFamiliaV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("Tribos")
						|| node.getParent().toString().equals("SubFamilias")) {
					TriboView TriboV = new TriboView();
					TriboV.setVisible(true);
					TriboV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("Generos")
						|| node.getParent().toString().equals("Tribos")) {
					GeneroView GeneroV = new GeneroView();
					GeneroV.setVisible(true);
					GeneroV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("SubGeneros")
						|| node.getParent().toString().equals("Generos")) {
					SubGeneroView SubGeneroV = new SubGeneroView();
					SubGeneroV.setVisible(true);
					SubGeneroV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("Especies")
						|| node.getParent().toString().equals("SubGeneros")) {
					EspecieView EspecieV = new EspecieView();
					EspecieV.setVisible(true);
					EspecieV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (nome.equals("SubEspecies")
						|| node.getParent().toString().equals("Especies")) {
					SubEspecieView SubEspecieV = new SubEspecieView();
					SubEspecieV.setVisible(true);
					SubEspecieV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (nome.equals("Variedades")
						|| node.getParent().toString().equals("SubEspecies")) {
					VariedadeView VariedadeV = new VariedadeView();
					VariedadeV.setVisible(true);
					VariedadeV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				}
				att.atualizarJtree(aTree);

			}
		});

		popup.add(mi);
		mi = new JMenuItem("Editar");
		/* Implementaçao popup Editar* */
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) aTree
						.getLastSelectedPathComponent();
				String nome = node.toString();
				if (node.isRoot()) {
					return;
				} else if (node.getParent().toString().equals("Filos")) {
					InterfaceFiloController ifc = ControllerFactory
							.getInstance().getInterfaceFiloController();
					FiloBean obj = ifc.pesquisar(nome, true).get(0);
					filoV.editar(obj);
					filoV.setVisible(true);
				} else if (node.getParent().toString().equals("SubFilos")) {
					InterfaceSubFiloController ifc = ControllerFactory
							.getInstance().getInterfaceSubFiloController();
					SubFiloBean obj = ifc.pesquisar(nome, true).get(0);
					SubFiloView subFiloV = new SubFiloView();
					subFiloV.editar(obj);
					subFiloV.setVisible(true);
					subFiloV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("Classes")) {
					InterfaceClasseController ifc = ControllerFactory
							.getInstance().getInterfaceClasseController();
					ClasseBean obj = ifc.pesquisar(nome, true).get(0);
					ClasseView ClasseV = new ClasseView();
					ClasseV.editar(obj);
					ClasseV.setVisible(true);
					ClasseV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("SubClasses")) {
					InterfaceSubClasseController ifc = ControllerFactory
							.getInstance().getInterfaceSubClasseController();
					SubClasseBean obj = ifc.pesquisar(nome, true).get(0);
					SubClasseView SubClasseV = new SubClasseView();
					SubClasseV.editar(obj);
					SubClasseV.setVisible(true);
					SubClasseV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("InfraClasses")) {
					InterfaceInfraClasseController ifc = ControllerFactory
							.getInstance().getInterfaceInfraClasseController();
					InfraClasseBean obj = ifc.pesquisar(nome, true).get(0);
					InfraClasseView InfraClasseV = new InfraClasseView();
					InfraClasseV.editar(obj);
					InfraClasseV.setVisible(true);
					InfraClasseV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("Ordens")) {
					InterfaceOrdemController ifc = ControllerFactory
							.getInstance().getInterfaceOrdemController();
					OrdemBean obj = ifc.pesquisar(nome, true).get(0);
					OrdemView OrdemV = new OrdemView();
					OrdemV.editar(obj);
					OrdemV.setVisible(true);
					OrdemV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("SubOrdens")) {
					InterfaceSubOrdemController ifc = ControllerFactory
							.getInstance().getInterfaceSubOrdemController();
					SubOrdemBean obj = ifc.pesquisar(nome, true).get(0);
					SubOrdemView SubOrdemV = new SubOrdemView();
					SubOrdemV.editar(obj);
					SubOrdemV.setVisible(true);
					SubOrdemV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("SuperFamilias")) {
					InterfaceSuperFamiliaController ifc = ControllerFactory
							.getInstance().getInterfaceSuperFamiliaController();
					SuperFamiliaBean obj = ifc.pesquisar(nome, true).get(0);
					SuperFamiliaView SuperFamiliaV = new SuperFamiliaView();
					SuperFamiliaV.editar(obj);
					SuperFamiliaV.setVisible(true);
					SuperFamiliaV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("Familias")) {
					InterfaceFamiliaController ifc = ControllerFactory
							.getInstance().getInterfaceFamiliaController();
					FamiliaBean obj = ifc.pesquisar(nome, true).get(0);
					FamiliaView FamiliaV = new FamiliaView();
					FamiliaV.editar(obj);
					FamiliaV.setVisible(true);
					FamiliaV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("SubFamilias")) {
					InterfaceSubFamiliaController ifc = ControllerFactory
							.getInstance().getInterfaceSubFamiliaController();
					SubFamiliaBean obj = ifc.pesquisar(nome, true).get(0);
					SubFamiliaView SubFamiliaV = new SubFamiliaView();
					SubFamiliaV.editar(obj);
					SubFamiliaV.setVisible(true);
					SubFamiliaV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("Tribos")) {
					InterfaceTriboController ifc = ControllerFactory
							.getInstance().getInterfaceTriboController();
					TriboBean obj = ifc.pesquisar(nome, true).get(0);
					TriboView TriboV = new TriboView();
					TriboV.editar(obj);
					TriboV.setVisible(true);
					TriboV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("Generos")) {
					InterfaceGeneroController ifc = ControllerFactory
							.getInstance().getInterfaceGeneroController();
					GeneroBean obj = ifc.pesquisar(nome, true).get(0);
					GeneroView GeneroV = new GeneroView();
					GeneroV.editar(obj);
					GeneroV.setVisible(true);
					GeneroV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				} else if (node.getParent().toString().equals("SubGeneros")) {
					InterfaceSubGeneroController ifc = ControllerFactory
							.getInstance().getInterfaceSubGeneroController();
					SubGeneroBean obj = ifc.pesquisar(nome, true).get(0);
					SubGeneroView SubGeneroV = new SubGeneroView();
					SubGeneroV.editar(obj);
					SubGeneroV.setVisible(true);
					SubGeneroV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				} else if (node.getParent().toString().equals("Especies")) {
					InterfaceEspecieController ifc = ControllerFactory
							.getInstance().getInterfaceEspecieController();
					EspecieBean obj = ifc.pesquisar(nome, true).get(0);
					EspecieView EspecieV = new EspecieView();
					EspecieV.editar(obj);
					EspecieV.setVisible(true);
					EspecieV.addWindowListener(new java.awt.event.WindowAdapter() {

						public void windowClosing(java.awt.event.WindowEvent e) {
							att.atualizarJtree(aTree);
						}
					});
				}

				else if (node.getParent().toString().equals("SubEspecies")) {
					InterfaceSubEspecieController ifc = ControllerFactory
							.getInstance().getInterfaceSubEspecieController();
					SubEspecieBean obj = ifc.pesquisar(nome, true).get(0);
					SubEspecieView SubEspecieV = new SubEspecieView();
					SubEspecieV.editar(obj);
					SubEspecieV.setVisible(true);
					SubEspecieV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				}

				else if (node.getParent().toString().equals("Variedades")) {
					InterfaceVariedadeController ifc = ControllerFactory
							.getInstance().getInterfaceVariedadeController();
					VariedadeBean obj = ifc.pesquisar(nome, true).get(0);
					VariedadeView VariedadeV = new VariedadeView();
					VariedadeV.editar(obj);
					VariedadeV.setVisible(true);
					VariedadeV
							.addWindowListener(new java.awt.event.WindowAdapter() {

								public void windowClosing(
										java.awt.event.WindowEvent e) {
									att.atualizarJtree(aTree);
								}
							});
				}
			}
		});
		popup.add(mi);
		/* *Implementaçao popup Remover* */

		mi = new JMenuItem("Remover");
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) aTree
						.getLastSelectedPathComponent();
				if (node.isRoot()) {
					return;
				}
				int op = JOptionPane.showConfirmDialog(rootPane,
						"Deseja mesmo excluir este registro?",
						"Confirmar exclusão", JOptionPane.YES_NO_OPTION);
				if (op == 0) {
					if (!node.isLeaf()) {
						JOptionPane
								.showMessageDialog(rootPane,
										"Não é permitida a exclusão de registros com outros atrelados à ele!");
						return;
					} else {
						if (node.getParent().toString().equals("Filos")) {
							InterfaceFiloController ifc = ControllerFactory
									.getInstance().getInterfaceFiloController();
							ifc.remover(((FiloBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SubFilos")) {
							InterfaceSubFiloController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubFiloController();
							ifc.remover(((SubFiloBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("Classes")) {
							InterfaceClasseController ifc = ControllerFactory
									.getInstance()
									.getInterfaceClasseController();
							ifc.remover(((ClasseBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SubClasses")) {
							InterfaceSubClasseController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubClasseController();
							ifc.remover(((SubClasseBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("InfraClasses")) {
							InterfaceInfraClasseController ifc = ControllerFactory
									.getInstance()
									.getInterfaceInfraClasseController();
							ifc.remover(((InfraClasseBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString().equals("Ordens")) {
							InterfaceOrdemController ifc = ControllerFactory
									.getInstance()
									.getInterfaceOrdemController();
							ifc.remover(((OrdemBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SubOrdens")) {
							InterfaceSubOrdemController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubOrdemController();
							ifc.remover(((SubOrdemBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SuperFamilias")) {
							InterfaceSuperFamiliaController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSuperFamiliaController();
							ifc.remover(((SuperFamiliaBean) node
									.getUserObject()).getId());
						} else if (node.getParent().toString()
								.equals("Familias")) {
							InterfaceFamiliaController ifc = ControllerFactory
									.getInstance()
									.getInterfaceFamiliaController();
							ifc.remover(((FamiliaBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SubFamilias")) {
							InterfaceSubFamiliaController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubFamiliaController();
							ifc.remover(((SubFamiliaBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString().equals("Tribos")) {
							InterfaceTriboController ifc = ControllerFactory
									.getInstance()
									.getInterfaceTriboController();
							ifc.remover(((TriboBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("Generos")) {
							InterfaceGeneroController ifc = ControllerFactory
									.getInstance()
									.getInterfaceGeneroController();
							ifc.remover(((GeneroBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("SubGeneros")) {
							InterfaceSubGeneroController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubGeneroController();
							ifc.remover(((SubGeneroBean) node.getUserObject())
									.getId());
						} else if (node.getParent().toString()
								.equals("Especies")) {
							InterfaceEspecieController ifc = ControllerFactory
									.getInstance()
									.getInterfaceEspecieController();
							ifc.remover(((EspecieBean) node.getUserObject())
									.getId());
						}

						else if (node.getParent().toString()
								.equals("SubEspecies")) {
							InterfaceSubEspecieController ifc = ControllerFactory
									.getInstance()
									.getInterfaceSubEspecieController();
							ifc.remover(((SubEspecieBean) node.getUserObject())
									.getId());
						}

						else if (node.getParent().toString()
								.equals("Variedades")) {
							InterfaceVariedadeController ifc = ControllerFactory
									.getInstance()
									.getInterfaceVariedadeController();
							ifc.remover(((VariedadeBean) node.getUserObject())
									.getId());
						}

						att.atualizarJtree(jTreeClassificacao);
					}

				}
			}
		});
		popup.add(mi);
		popup.setOpaque(true);
		popup.setLightWeightPopupEnabled(true);
		aTree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					popup.show((JComponent) e.getComponent(), 0, 0);
				}
			}

		});
		aTree.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int row = aTree.getRowForLocation(e.getX(), e.getY());
				if (row == -1)
					return;
				aTree.setSelectionRow(row);
				if (e.isPopupTrigger()) {
					popup.show((JComponent) e.getSource(), e.getX(), e.getY());
				}
			}

		});
		jTPesquisaJtree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String[] tax = new String[] { "Filos", "SubFilos", "Classes",
						"SubClasses", "InfraClasses", "Ordens", "SubOrdens",
						"SuperFamilias", "Familias", "SubFamilias", "Tribos",
						"Generos", "SubGeneros", "Especies", "SubEspecies",
						"Variedades" };
				ArrayList<String> taxons = new ArrayList<String>(Arrays
						.asList(tax));
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !jTPesquisaJtree.getText().equals("Não Consta")
						&& !taxons.contains(jTPesquisaJtree.getText())) {
					att.pesquisarTermo(jTPesquisaJtree.getText(),
							jTreeClassificacao);

					{

						DefaultMutableTreeNode node = att.pesquisarTermo(
								jTPesquisaJtree.getText(), jTreeClassificacao);

						if (node != null) {
							// make the node visible by scroll to it
							TreeNode[] nodes = ((DefaultTreeModel) jTreeClassificacao
									.getModel()).getPathToRoot(node);
							TreePath path = new TreePath(nodes);
							jTreeClassificacao.scrollPathToVisible(path);
							jTreeClassificacao.setSelectionPath(path);
						} else {
							// node with string not found show message
							JOptionPane.showMessageDialog(rootPane, "Taxon : "
									+ jTPesquisaJtree.getText()
									+ " não encontrado",
									"Taxon não encontrado",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}
				}
			};
		});
	}
}
