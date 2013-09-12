package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;

public interface InterfaceVariedadeModel {

	public long inserir(VariedadeBean vb);

	public void remover(long id);

	public void atualizar(VariedadeBean vb);

	public VariedadeBean pesquisar(long id);

	public List<VariedadeBean> pesquisar();

	public List<VariedadeBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(VariedadeBean vb);
}
