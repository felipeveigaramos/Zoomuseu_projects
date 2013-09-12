package br.edu.utfpr.cm.zoomuseu_desktop;

import java.awt.Frame;

import br.edu.utfpr.cm.zoomuseu_data.dao.GenericDao;
import br.edu.utfpr.cm.zoomuseu_desktop.view.MenuPrincipalView;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
GenericDao.prepararBanco();

		MenuPrincipalView menu = new MenuPrincipalView();
		menu.setVisible(true);
		menu.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

}
