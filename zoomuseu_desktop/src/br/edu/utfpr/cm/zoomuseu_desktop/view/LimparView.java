package br.edu.utfpr.cm.zoomuseu_desktop.view;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

public class LimparView {

	public void LimparView(JPanel panel) {
		for (Component cp : panel.getComponents()) {
			if (cp instanceof JTextField) {
				((JTextField) cp).setText("");
			} else if (cp instanceof JTree) {
				((JTree) cp).clearSelection();
			} else if (cp instanceof JComboBox) {
				((JComboBox<?>) cp).setSelectedIndex(-1);
			} else if (cp instanceof JTextArea) {
				((JTextArea) cp).setText("");
			}
		}
	}
}
