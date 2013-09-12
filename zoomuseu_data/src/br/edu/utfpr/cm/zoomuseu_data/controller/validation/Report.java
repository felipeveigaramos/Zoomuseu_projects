/**
 * 
 */
package br.edu.utfpr.cm.zoomuseu_data.controller.validation;

/**
 * * Guarda campo e erro gerado para validação.
 */
public class Report {
	private String campo;
	private String erro;

	/**
	 * @return the campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * @param campo
	 *            the campo to set
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}

	/**
	 * @return the erro
	 */
	public String getErro() {
		return erro;
	}

	/**
	 * @param erro
	 *            the erro to set
	 */
	public void setErro(String erro) {
		this.erro = erro;
	}

	/**
	 * @param campo
	 * @param erro
	 */
	public Report(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
}
