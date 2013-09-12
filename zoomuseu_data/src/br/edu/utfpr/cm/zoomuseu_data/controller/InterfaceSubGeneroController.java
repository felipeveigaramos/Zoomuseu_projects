package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubGeneroController {

	public long inserir(SubGeneroBean sgb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubGeneroBean sgb, boolean verificar)
			throws ValidationException;

	public SubGeneroBean pesquisar(long id);

	public List<SubGeneroBean> pesquisar();

	public List<SubGeneroBean> pesquisar(String nome, boolean identico);

}
