package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;

public interface InterfaceSubEspecieModel {

	public long inserir(SubEspecieBean seb);

	public void remover(long id);

	public void atualizar(SubEspecieBean seb);

	public SubEspecieBean pesquisar(long id);

	public List<SubEspecieBean> pesquisar();

	public List<SubEspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubEspecieBean seb);
}
