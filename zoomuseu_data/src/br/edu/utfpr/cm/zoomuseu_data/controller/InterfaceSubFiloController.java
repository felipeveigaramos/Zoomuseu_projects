package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubFiloController {

	public long inserir(SubFiloBean sfb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubFiloBean sfb, boolean verificar)
			throws ValidationException;

	public SubFiloBean pesquisar(long id);

	public List<SubFiloBean> pesquisar();

	public List<SubFiloBean> pesquisar(String nome, boolean identico);
}
