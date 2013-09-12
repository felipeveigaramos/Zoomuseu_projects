package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceFiloController {

	public long inserir(FiloBean fb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(FiloBean fb, boolean verificar)
			throws ValidationException;

	public FiloBean pesquisar(long id);

	public List<FiloBean> pesquisar();

	public List<FiloBean> pesquisar(String nome, boolean identico);
}
