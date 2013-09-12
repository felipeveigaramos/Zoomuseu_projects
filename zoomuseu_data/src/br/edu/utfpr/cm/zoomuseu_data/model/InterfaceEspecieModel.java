package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;

public interface InterfaceEspecieModel {

	public long inserir(EspecieBean eb);

	public void remover(long id);

	public void atualizar(EspecieBean eb);

	public EspecieBean pesquisar(long id);

	public List<EspecieBean> pesquisar();

	public List<EspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(EspecieBean eb);
}
