package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;

public interface InterfaceFamiliaModel {

	public long inserir(FamiliaBean fb);

	public void remover(long id);

	public void atualizar(FamiliaBean fb);

	public FamiliaBean pesquisar(long id);

	public List<FamiliaBean> pesquisar();

	public List<FamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(FamiliaBean fb);
}
