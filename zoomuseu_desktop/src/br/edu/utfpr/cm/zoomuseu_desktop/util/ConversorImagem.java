package br.edu.utfpr.cm.zoomuseu_desktop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;

public class ConversorImagem {
	public ConversorImagem() {
	}

	public byte[] imageToByte(String image) throws IOException {

		InputStream is = null;

		byte[] buffer = null;

		is = new FileInputStream(image);

		buffer = new byte[is.available()];

		is.read(buffer);

		is.close();

		return buffer;

	}

	public ImageIcon ByteToImage(byte[] bytes) throws Exception {
		byte[] imgBytes = bytes;
		ImageIcon img;
		try {
			img = new ImageIcon(imgBytes);
		} catch (Exception e) {
			throw new Exception(
					"Erro ao converter os bytes recebidos para imagem");
		}
		return img;
	}

	public FileFilter getFilter() {
		FileFilter ff = new FileFilter() {

			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}

				String extension = getExtension(f);
				if (extension != null) {
					if (extension.equals(".gif") || extension.equals(".jpg")
							|| extension.equals(".jpeg")
							|| extension.equals(".png")) {
						return true;
					} else {
						return false;
					}
				}
				return false;
			}

			private String getExtension(File f) {
				String ext = null;
				String s = f.getName();
				int i = s.lastIndexOf('.');

				if (i > 0 && i < s.length() - 1) {
					ext = s.substring(i).toLowerCase();
				}
				return ext;
			}

			public String getDescription() {
				return "Arquivos de Imagens (.gif, .jpg, .jpeg, .png)";
			}
		};

		return ff;

	}
}
