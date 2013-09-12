
package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceLocalizacaoController {
	public long inserir(LocalizacaoBean lb) throws ValidationException;

	public void remover(long id);

	public void atualizar(LocalizacaoBean lb) throws ValidationException;

	public LocalizacaoBean pesquisar(long id);

	public List<LocalizacaoBean> pesquisar();

	public List<LocalizacaoBean> pesquisarMunicipio(String municipio, boolean identico);
}
