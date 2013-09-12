package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubOrdemController {

	public long inserir(SubOrdemBean fb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubOrdemBean fb, boolean verificar)
			throws ValidationException;

	public SubOrdemBean pesquisar(long id);

	public List<SubOrdemBean> pesquisar();

	public List<SubOrdemBean> pesquisar(String nome, boolean identico);

}
