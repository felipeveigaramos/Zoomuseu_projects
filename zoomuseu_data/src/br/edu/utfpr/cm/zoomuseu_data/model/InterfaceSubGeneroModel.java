package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;

public interface InterfaceSubGeneroModel {
	public long inserir(SubGeneroBean sgb);

	public void remover(long id);

	public void atualizar(SubGeneroBean sgb);

	public SubGeneroBean pesquisar(long id);

	public List<SubGeneroBean> pesquisar();

	public List<SubGeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubGeneroBean sgb);
}
