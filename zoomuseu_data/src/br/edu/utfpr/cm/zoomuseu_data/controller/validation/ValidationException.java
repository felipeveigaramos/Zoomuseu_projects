package br.edu.utfpr.cm.zoomuseu_data.controller.validation;

import java.util.List;

public class ValidationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Report> erros;

	public ValidationException(String message, List<Report> erros) {
		super(message);
		this.erros = erros;
	}

	/**
	 * @return the erros
	 */
	public List<Report> getErros() {
		return erros;
	}

	/**
	 * @param erros
	 *            the erros to set
	 */
	public void setErros(List<Report> erros) {
		this.erros = erros;
	}

	public void addErros(List<Report> maisErros) {
		this.erros.addAll(maisErros);
	}
}
