package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;

public interface InterfaceSubClasseModel {
	public long inserir(SubClasseBean fb);

	public void remover(long id);

	public void atualizar(SubClasseBean fb);

	public SubClasseBean pesquisar(long id);

	public List<SubClasseBean> pesquisar();

	public List<SubClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubClasseBean scb);
}
