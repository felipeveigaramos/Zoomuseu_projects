package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;

public interface InterfaceTriboModel {

	public long inserir(TriboBean tb);

	public void remover(long id);

	public void atualizar(TriboBean tb);

	public TriboBean pesquisar(long id);

	public List<TriboBean> pesquisar();

	public List<TriboBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(TriboBean tb);
}
