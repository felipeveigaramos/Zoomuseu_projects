package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;

public interface InterfaceLocalizacaoModel {
	public long inserir(LocalizacaoBean fb);

	public void remover(long id);

	public void atualizar(LocalizacaoBean fb);

	public LocalizacaoBean pesquisar(long id);

	public List<LocalizacaoBean> pesquisar();

	public void refresh(LocalizacaoBean fb);

	public List<LocalizacaoBean> pesquisarMunicipio(String municipio,
			boolean identico);

}
