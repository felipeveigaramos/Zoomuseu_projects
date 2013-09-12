package br.edu.utfpr.cm.zoomuseu_desktop.view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuPrincipalView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalView frame = new MenuPrincipalView();
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
	public MenuPrincipalView() {

		setTitle("Sistema Zoomuseu");
		setState(MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 539);
		final FiloView filo = new FiloView(this, false);
		final FiloPesquisaView filopesquisa = new FiloPesquisaView(this, false);
		final SubFiloPesquisaView subfilopesq = new SubFiloPesquisaView(this,
				false);
		final ClassePesquisaView classePesquisa = new ClassePesquisaView(this,
				false);
		final SubClassePesquisaView subClassePesquisa = new SubClassePesquisaView(
				this, false);
		final OrdemPesquisaView ordempesq = new OrdemPesquisaView(this, false);
		final SubOrdemPesquisaView subOrdemPesq = new SubOrdemPesquisaView(
				this, false);
		final SuperFamiliaPesquisaView superFamiliaPesq = new SuperFamiliaPesquisaView(
				this, false);
		final FamiliaPesquisaView familiaPesq = new FamiliaPesquisaView(this,
				false);
		final SubFamiliaPesquisaView subFamiliaPesq = new SubFamiliaPesquisaView(
				this, false);
		final TriboPesquisaView subTriboPesq = new TriboPesquisaView(this,
				false);
		final InfraClassePesquisaView infraClassePesq = new InfraClassePesquisaView(this,
				false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		final GeneroPesquisaView generoPesq = new GeneroPesquisaView(this,
				false);
		final SubGeneroPesquisaView subGeneroPesq = new SubGeneroPesquisaView(
				this, false);
		final EspeciePesquisaView especiePesq = new EspeciePesquisaView(this,
				false);
		final SubEspeciePesquisaView subEspeciePesq = new SubEspeciePesquisaView(
				this, false);
		final VariedadePesquisaView variedadePesq = new VariedadePesquisaView(
				this, false);
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);

		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);

		menuBar.setRequestFocusEnabled(false);

		final JMenu mnCadastros = new JMenu("Cadastros           ");
		mnCadastros.setRequestFocusEnabled(false);
		mnCadastros.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnCadastros.setMnemonic('M');
		mnCadastros.setMnemonic(KeyEvent.VK_ENTER);
		menuBar.add(mnCadastros);

		JMenu mnNewMenu = new JMenu("Filo");
		mnCadastros.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filo.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmPesquisa = new JMenuItem("Pesquisa");
		mntmPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filopesquisa.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPesquisa);

		JMenu mnSubfilo = new JMenu("SubFilo");
		mnCadastros.add(mnSubfilo);

		JMenuItem menuItem = new JMenuItem("Cadastro");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubFiloView subfilo = new SubFiloView();
				subfilo.setVisible(true);
			}
		});
		mnSubfilo.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("Pesquisa");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subfilopesq.setVisible(true);
			}
		});

		mnSubfilo.add(menuItem_1);

		JMenu mnClassefilo = new JMenu("Classe");

		mnCadastros.add(mnClassefilo);

		JMenuItem menuItem_2 = new JMenuItem("Cadastro");

		mnClassefilo.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Pesquisa");
		mnClassefilo.add(menuItem_3);

		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClasseView classe = new ClasseView();
				classe.setVisible(true);
			}
		});

		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classePesquisa.setVisible(true);
			}
		});

		JMenu mnSubclass = new JMenu("SubClasse");
		mnCadastros.add(mnSubclass);

		JMenuItem menuItem_4 = new JMenuItem("Cadastro");
		mnSubclass.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("Pesquisa");
		mnSubclass.add(menuItem_5);
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubClasseView subfilo = new SubClasseView();
				subfilo.setVisible(true);
			}
		});
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subClassePesquisa.setVisible(true);
			}
		});
		
		JMenu mnInfraclasse = new JMenu("InfraClasse");
		mnCadastros.add(mnInfraclasse);
		
		JMenuItem menuItem_18 = new JMenuItem("Cadastro");
		mnInfraclasse.add(menuItem_18);
		
		JMenuItem menuItem_19 = new JMenuItem("Pesquisa");
		mnInfraclasse.add(menuItem_19);
		
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfraClasseView infraclasse = new InfraClasseView();
				infraclasse.setVisible(true);
			}
		});
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infraClassePesq.setVisible(true);
			}
		});
		JMenu mnOrdem = new JMenu("Ordem");
		mnCadastros.add(mnOrdem);

		JMenuItem menuItem_6 = new JMenuItem("Cadastro");
		mnOrdem.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("Pesquisa");
		mnOrdem.add(menuItem_7);

		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdemView ordem = new OrdemView();
				ordem.setVisible(true);
			}
		});
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordempesq.setVisible(true);
			}
		});

		JMenu mnSubordem = new JMenu("SubOrdem");
		mnCadastros.add(mnSubordem);

		JMenuItem menuItem_8 = new JMenuItem("Cadastro");
		
		mnSubordem.add(menuItem_8);

		JMenuItem menuItem_9 = new JMenuItem("Pesquisa");
		mnSubordem.add(menuItem_9);
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubOrdemView subordem = new SubOrdemView();
				subordem.setVisible(true);
			}
		});
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subOrdemPesq.setVisible(true);
			}
		});
		JMenu mnSuperfamilia = new JMenu("SuperFamilia");
		mnCadastros.add(mnSuperfamilia);

		JMenuItem menuItem_10 = new JMenuItem("Cadastro");
		mnSuperfamilia.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("Pesquisa");
		mnSuperfamilia.add(menuItem_11);

		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuperFamiliaView superFamilia = new SuperFamiliaView();
				superFamilia.setVisible(true);
			}
		});
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				superFamiliaPesq.setVisible(true);
			}
		});

		JMenu mnFamilia = new JMenu("Familia");
		mnCadastros.add(mnFamilia);

		JMenuItem menuItem_12 = new JMenuItem("Cadastro");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FamiliaView familiaView = new FamiliaView();
				familiaView.setVisible(true);
			}
		});
		mnFamilia.add(menuItem_12);
		JMenuItem menuItem_13 = new JMenuItem("Pesquisa");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				familiaPesq.setVisible(true);
			}
		});
		mnFamilia.add(menuItem_13);

		JMenu mnSubfamilia = new JMenu("SubFamilia");
		mnCadastros.add(mnSubfamilia);

		JMenuItem menuItem_14 = new JMenuItem("Cadastro");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubFamiliaView subFamiliaView = new SubFamiliaView();
				subFamiliaView.setVisible(true);
			}
		});
		mnSubfamilia.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("Pesquisa");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subFamiliaPesq.setVisible(true);
			}
		});
		mnSubfamilia.add(menuItem_15);

		JMenu mnTribo = new JMenu("Tribo");
		mnCadastros.add(mnTribo);

		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TriboView tribo = new TriboView();
				tribo.setVisible(true);
			}
		});
		mnTribo.add(mntmCadastro);

		JMenuItem mntmPesquisa_1 = new JMenuItem("Pesquisa");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subTriboPesq.setVisible(true);
			}
		});
		mnTribo.add(mntmPesquisa_1);

		JMenu mnNewMenu_1 = new JMenu("Genero");
		mnCadastros.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cadastro");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneroView genero = new GeneroView();
				genero.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmPesquisa_2 = new JMenuItem("Pesquisa");

		mntmPesquisa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generoPesq.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmPesquisa_2);

		JMenu mnSubgenero = new JMenu("SubGenero");
		mnCadastros.add(mnSubgenero);

		JMenuItem menuItem_16 = new JMenuItem("Cadastro");
		menuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubGeneroView subGenero = new SubGeneroView();
				subGenero.setVisible(true);
			}
		});
		mnSubgenero.add(menuItem_16);
		JMenuItem menuItem_17 = new JMenuItem("Pesquisa");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				subGeneroPesq.setVisible(true);
			}
		});
		mnSubgenero.add(menuItem_17);

		JMenu mnNewMenu_2 = new JMenu("Especie");
		mnCadastros.add(mnNewMenu_2);

		JMenuItem mntmCadastro_1 = new JMenuItem("Cadastro");
		mntmCadastro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EspecieView especie = new EspecieView();
				especie.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmCadastro_1);

		JMenuItem mntmPesquisa_3 = new JMenuItem("Pesquisa");
		mntmPesquisa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				especiePesq.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmPesquisa_3);

		JMenu mnSubespecie = new JMenu("SubEspecie");
		mnCadastros.add(mnSubespecie);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cadastro");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubEspecieView subEspecie = new SubEspecieView();
				subEspecie.setVisible(true);
			}
		});
		mnSubespecie.add(mntmNewMenuItem_3);
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Pesquisa");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subEspeciePesq.setVisible(true);
			}
		});
		mnSubespecie.add(mntmNewMenuItem_4);

		JMenu mnVariedade = new JMenu("Variedade");
		mnCadastros.add(mnVariedade);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastro");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VariedadeView variedade = new VariedadeView();
				variedade.setVisible(true);
			}
		});
		mnVariedade.add(mntmNewMenuItem_2);

		JMenuItem mntmPesquisa_4 = new JMenuItem("Pesquisa");
		mntmPesquisa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				variedadePesq.setVisible(true);
			}
		});
		mnVariedade.add(mntmPesquisa_4);

		JMenu mnColeta = new JMenu("Coleta            ");
		menuBar.add(mnColeta);

		JMenu mnEspecime = new JMenu("Especime");
		mnColeta.add(mnEspecime);

		JMenuItem mntmEspecime = new JMenuItem("Cadastro");
		mntmEspecime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EspecimeView especime = new EspecimeView();
				especime.setVisible(true);
			}
		});
		mnEspecime.add(mntmEspecime);

		JLabel label = new JLabel("Sistema Zoomuseu");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Old English Text MT", Font.PLAIN, 38));
		label.setDisplayedMnemonic(KeyEvent.VK_M);
		label.setAlignmentX(0.5f);
		panel.add(label, BorderLayout.CENTER);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					mnCadastros.doClick();
				}
			}
		});
	}

}
