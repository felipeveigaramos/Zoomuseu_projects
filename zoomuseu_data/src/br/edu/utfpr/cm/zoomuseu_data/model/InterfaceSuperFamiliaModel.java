package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;

public interface InterfaceSuperFamiliaModel {

	public long inserir(SuperFamiliaBean sfb);

	public void remover(long id);

	public void atualizar(SuperFamiliaBean sfb);

	public SuperFamiliaBean pesquisar(long id);

	public List<SuperFamiliaBean> pesquisar();

	public List<SuperFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SuperFamiliaBean sfb);
}
