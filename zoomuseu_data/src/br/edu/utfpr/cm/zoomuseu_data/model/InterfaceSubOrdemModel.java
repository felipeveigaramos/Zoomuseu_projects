package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;

public interface InterfaceSubOrdemModel {

	public long inserir(SubOrdemBean fb);

	public void remover(long id);

	public void atualizar(SubOrdemBean fb);

	public SubOrdemBean pesquisar(long id);

	public List<SubOrdemBean> pesquisar();

	public List<SubOrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubOrdemBean sob);
}
