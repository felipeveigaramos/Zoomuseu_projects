package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceGeneroController {

	public long inserir(GeneroBean gb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(GeneroBean gb, boolean verificar)
			throws ValidationException;

	public GeneroBean pesquisar(long id);

	public List<GeneroBean> pesquisar();

	public List<GeneroBean> pesquisar(String nome, boolean identico);

}
