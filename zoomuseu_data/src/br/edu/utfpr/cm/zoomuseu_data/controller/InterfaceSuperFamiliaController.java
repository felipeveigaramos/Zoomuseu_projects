package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSuperFamiliaController {

	public long inserir(SuperFamiliaBean sfb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SuperFamiliaBean sfb, boolean verificar)
			throws ValidationException;

	public SuperFamiliaBean pesquisar(long id);

	public List<SuperFamiliaBean> pesquisar();

	public List<SuperFamiliaBean> pesquisar(String nome, boolean identico);

}
