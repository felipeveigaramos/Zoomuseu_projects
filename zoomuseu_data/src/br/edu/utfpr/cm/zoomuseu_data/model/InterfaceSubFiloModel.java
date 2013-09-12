package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;

public interface InterfaceSubFiloModel {

	public long inserir(SubFiloBean sfb);

	public void remover(long id);

	public void atualizar(SubFiloBean sfb);

	public SubFiloBean pesquisar(long id);

	public List<SubFiloBean> listar();

	public List<SubFiloBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubFiloBean sfb);
}
