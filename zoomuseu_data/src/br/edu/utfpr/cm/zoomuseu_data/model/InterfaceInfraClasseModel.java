package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;

public interface InterfaceInfraClasseModel {
	public long inserir(InfraClasseBean icb);

	public void remover(long id);

	public void atualizar(InfraClasseBean icb);

	public InfraClasseBean pesquisar(long id);

	public List<InfraClasseBean> pesquisar();

	public List<InfraClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(InfraClasseBean icb);
}
