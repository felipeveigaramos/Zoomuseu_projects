package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;

public interface InterfaceSubFamiliaModel {

	public long inserir(SubFamiliaBean sfb);

	public void remover(long id);

	public void atualizar(SubFamiliaBean sfb);

	public SubFamiliaBean pesquisar(long id);

	public List<SubFamiliaBean> pesquisar();

	public List<SubFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(SubFamiliaBean sfb);
}
