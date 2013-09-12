package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceVariedadeController {

	public long inserir(VariedadeBean vb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(VariedadeBean vb, boolean verificar)
			throws ValidationException;

	public VariedadeBean pesquisar(long id);

	public List<VariedadeBean> pesquisar();

	public List<VariedadeBean> pesquisar(String nome, boolean identico);

}
