package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceEspecieController {

	public long inserir(EspecieBean eb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(EspecieBean eb, boolean verificar)
			throws ValidationException;

	public EspecieBean pesquisar(long id);

	public List<EspecieBean> pesquisar();

	public List<EspecieBean> pesquisar(String nome, boolean identico);

}
