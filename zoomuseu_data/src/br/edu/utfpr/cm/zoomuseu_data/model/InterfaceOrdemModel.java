package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;

public interface InterfaceOrdemModel {

	public long inserir(OrdemBean ob);

	public void remover(long id);

	public void atualizar(OrdemBean ob);

	public OrdemBean pesquisar(long id);

	public List<OrdemBean> pesquisar();

	public List<OrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(OrdemBean ob);
}
