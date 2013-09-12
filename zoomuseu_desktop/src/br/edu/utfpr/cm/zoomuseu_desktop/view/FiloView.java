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
import javax.swing.JDialog;
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
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceFiloController;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public class FiloView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTId;
	private JTextField jTPesquisa;
	private JTable jTBPesquisa;
	private JTextField jTNome;
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
					FiloView frame = new FiloView(null, true);
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
	public FiloView(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setResizable(false);
		jBtNovo = new JButton("Novo");
		jBtEditar = new JButton("Editar");

		jBtSalvar = new JButton("Salvar");

		jBtExcluir = new JButton("Excluir");

		jBtCancelar = new JButton("Cancelar");

		final LimparView lv = new LimparView();
		setTitle("Cadastro Filo");
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

		jTId = new JTextField();
		jTId.setEnabled(false);
		jTId.setColumns(10);

		JPanel panel = new JPanel();

		JLabel lblNome = new JLabel("Nome");

		jTNome = new JTextField();
		jTNome.setEnabled(false);
		jTNome.setColumns(10);
		GroupLayout gl_jPCadastro = new GroupLayout(jPCadastro);
		gl_jPCadastro
				.setHorizontalGroup(gl_jPCadastro
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_jPCadastro.createSequentialGroup()
										.addContainerGap().addComponent(label)
										.addGap(681))
						.addGroup(
								gl_jPCadastro
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jTId,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(605, Short.MAX_VALUE))
						.addGroup(
								Alignment.LEADING,
								gl_jPCadastro.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNome)
										.addContainerGap(645, Short.MAX_VALUE))
						.addGroup(
								gl_jPCadastro
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPCadastro
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																jTNome,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																554,
																Short.MAX_VALUE)
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																412,
																GroupLayout.PREFERRED_SIZE))
										.addGap(137)));
		gl_jPCadastro.setVerticalGroup(gl_jPCadastro.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_jPCadastro
						.createSequentialGroup()
						.addGap(17)
						.addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTId, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTNome, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 267,
								Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGap(32)));

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
				"Geral", "C\u00F3digo", "Nome" }));

		// Acoes dos botoes

		jBtNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBtSalvar.setEnabled(true);
				jBtCancelar.setEnabled(true);
				jBtNovo.setEnabled(false);
				jBtEditar.setEnabled(false);
				jBtExcluir.setEnabled(false);
				lv.LimparView(jPCadastro);
				jTNome.setEnabled(true);
				jTNome.requestFocus(true);

			}
		});
		jBtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FiloBean newFilo = new FiloBean();
					InterfaceFiloController ifc = ControllerFactory
							.getInstance().getInterfaceFiloController();
					if (jTId.getText().equals("")) {
						newFilo.setNome(jTNome.getText());
						long id = ifc.inserir(newFilo, true);

						if (id != -1) {

							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);
							jTId.setText("" + id);
							JOptionPane.showMessageDialog(rootPane,
									"Registro Gravado !");
						}
					} else {
						newFilo.setNome(jTNome.getText());
						newFilo.setId(Long.parseLong(jTId.getText()));
						// Setar alteracoes

						ifc.atualizar(newFilo, true);
						JOptionPane.showMessageDialog(rootPane,
								"Registro Atualizado !");
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);

					}
					jBtEditar.setEnabled(true);
					jBtExcluir.setEnabled(true);
					jBtSalvar.setEnabled(false);
					jBtNovo.setEnabled(true);
					jBtCancelar.setEnabled(false);

					jTNome.setEnabled(false);

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

					jTNome.setEnabled(true);
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
				jBtCancelar.setEnabled(false);
				jBtNovo.setEnabled(true);
				jBtEditar.setEnabled(false);

				jTNome.setEnabled(false);

			}
		});

		jBtExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					InterfaceFiloController ifc = ControllerFactory
							.getInstance().getInterfaceFiloController();

					ifc.remover(Long.parseLong(jTId.getText()));
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

		jTPesquisa = new JTextField();
		jTPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (jCPesquisa.getSelectedIndex()) {
				case 0: {
					try {
						InterfaceFiloController ifc = ControllerFactory
								.getInstance().getInterfaceFiloController();
						List<FiloBean> lista = ifc.pesquisar();
						DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
								.getModel();
						dtm.setRowCount(0);
						for (FiloBean filo : lista) {
							dtm.addRow(new Object[] { filo.getId(),
									filo.getNome() });
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
							InterfaceFiloController ifc = ControllerFactory
									.getInstance().getInterfaceFiloController();
							FiloBean elemento = ifc.pesquisar(id);
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);

							dtm.addRow(new Object[] { elemento.getId(),
									elemento.getNome() });
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
							InterfaceFiloController ifc = ControllerFactory
									.getInstance().getInterfaceFiloController();
							DefaultTableModel dtm = (DefaultTableModel) jTBPesquisa
									.getModel();
							dtm.setRowCount(0);
							List<FiloBean> lista = ifc.pesquisar(nome, false);
							dtm.setRowCount(0);
							for (FiloBean filo : lista) {
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
					InterfaceFiloController ifc = ControllerFactory
							.getInstance().getInterfaceFiloController();

					int index = jTBPesquisa.getSelectedRow();
					Long id = (Long) jTBPesquisa.getValueAt(index, 0);
					FiloBean filo = ifc.pesquisar(id);
					jTId.setText("" + filo.getId());
					jTNome.setText(filo.getNome());
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
				InterfaceFiloController ifc = ControllerFactory.getInstance()
						.getInterfaceFiloController();

				int index = jTBPesquisa.getSelectedRow();
				Long id = (Long) jTBPesquisa.getValueAt(index, 0);
				FiloBean filo = ifc.pesquisar(id);
				jTId.setText("" + filo.getId());
				jTNome.setText(filo.getNome());
				tabbedPane.setSelectedIndex(0);
				jBtEditar.setEnabled(true);
				jBtExcluir.setEnabled(true);
				jBtSalvar.setEnabled(false);
				jBtNovo.setEnabled(true);
				jBtCancelar.setEnabled(false);

			}
		});
		jTBPesquisa.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Descri\u00E7\u00E3o" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTBPesquisa.getColumnModel().getColumn(0).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(0).setPreferredWidth(59);
		jTBPesquisa.getColumnModel().getColumn(1).setResizable(false);
		jTBPesquisa.getColumnModel().getColumn(1).setPreferredWidth(387);
		scrollPane.setColumnHeaderView(jTBPesquisa);
		jPPesquisa.setLayout(gl_jPPesquisa);
		contentPane.setLayout(gl_contentPane);

	}

	public void editar(FiloBean aFilo) {
		jTId.setText("" + aFilo.getId());
		jTNome.setText(aFilo.getNome());
		jBtEditar.setEnabled(true);
		jBtExcluir.setEnabled(true);
		jBtSalvar.setEnabled(false);
		jBtNovo.setEnabled(true);
		jBtCancelar.setEnabled(false);
	}
}
