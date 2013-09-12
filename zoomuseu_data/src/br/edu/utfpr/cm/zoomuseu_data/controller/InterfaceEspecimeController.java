package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceEspecimeController {
	public long inserir(EspecimeBean eb) throws ValidationException;

	public void remover(long id);

	public void atualizar(EspecimeBean eb) throws ValidationException;

	public EspecimeBean pesquisar(long id);

	public List<EspecimeBean> pesquisar();

	public List<EspecimeBean> pesquisarEspecie(String nomeEspecie, boolean identico);

	List<EspecimeBean> pesquisar(String nomesPopulares, boolean identico);


}
