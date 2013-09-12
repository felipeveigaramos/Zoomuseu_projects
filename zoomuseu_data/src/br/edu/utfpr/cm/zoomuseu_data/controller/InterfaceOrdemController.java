package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceOrdemController {

	public long inserir(OrdemBean ob, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(OrdemBean ob, boolean verificar)
			throws ValidationException;

	public OrdemBean pesquisar(long id);

	public List<OrdemBean> pesquisar();

	public List<OrdemBean> pesquisar(String nome, boolean identico);

}