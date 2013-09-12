package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubClasseController {
	public long inserir(SubClasseBean scb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubClasseBean scb, boolean verificar)
			throws ValidationException;

	public SubClasseBean pesquisar(long id);

	public List<SubClasseBean> pesquisar();

	public List<SubClasseBean> pesquisar(String nome, boolean identico);
}
