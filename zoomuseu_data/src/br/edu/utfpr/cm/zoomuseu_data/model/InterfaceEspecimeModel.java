package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;

public interface InterfaceEspecimeModel {
	public long inserir(EspecimeBean eb);

	public void remover(long id);

	public void atualizar(EspecimeBean eb);

	public EspecimeBean pesquisar(long id);

	public List<EspecimeBean> pesquisar();

	public List<EspecimeBean> pesquisar(String nomesPopulares, boolean identico);

	public List<EspecimeBean> pesquisarEspecie(String nomeEspecie,
			boolean identico);

}
