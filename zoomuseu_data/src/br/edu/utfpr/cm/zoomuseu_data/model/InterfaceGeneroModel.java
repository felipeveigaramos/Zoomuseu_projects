package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;

public interface InterfaceGeneroModel {
	public long inserir(GeneroBean gb);

	public void remover(long id);

	public void atualizar(GeneroBean gb);

	public GeneroBean pesquisar(long id);

	public List<GeneroBean> pesquisar();

	public List<GeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(GeneroBean gb);
}
