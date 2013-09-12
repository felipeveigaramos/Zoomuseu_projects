package br.edu.utfpr.cm.zoomuseu_desktop.util;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DrawImage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image imgFoto;

	public DrawImage(Image img) {
		imgFoto = img;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(imgFoto, 0, 0, this);

	}
}
