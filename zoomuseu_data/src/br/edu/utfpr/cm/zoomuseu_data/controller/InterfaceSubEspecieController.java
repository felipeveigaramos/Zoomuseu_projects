package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubEspecieController {

	public long inserir(SubEspecieBean seb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubEspecieBean seb, boolean verificar)
			throws ValidationException;

	public SubEspecieBean pesquisar(long id);

	public List<SubEspecieBean> pesquisar();

	public List<SubEspecieBean> pesquisar(String nome, boolean identico);

}
