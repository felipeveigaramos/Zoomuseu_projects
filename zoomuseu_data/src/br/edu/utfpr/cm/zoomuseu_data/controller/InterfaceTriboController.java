package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceTriboController {

	public long inserir(TriboBean tb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(TriboBean tb, boolean verificar)
			throws ValidationException;

	public TriboBean pesquisar(long id);

	public List<TriboBean> pesquisar();

	public List<TriboBean> pesquisar(String nome, boolean identico);

}
