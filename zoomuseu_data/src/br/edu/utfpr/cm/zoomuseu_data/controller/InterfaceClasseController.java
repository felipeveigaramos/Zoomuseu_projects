package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceClasseController {
	public long inserir(ClasseBean cb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(ClasseBean cb, boolean verificar)
			throws ValidationException;

	public ClasseBean pesquisar(long id);

	public List<ClasseBean> pesquisar();

	public List<ClasseBean> pesquisar(String nome, boolean identico);
}
