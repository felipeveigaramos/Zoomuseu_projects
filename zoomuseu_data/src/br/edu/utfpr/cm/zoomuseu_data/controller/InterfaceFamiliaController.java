package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceFamiliaController {

	public long inserir(FamiliaBean fb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(FamiliaBean fb, boolean verificar)
			throws ValidationException;

	public FamiliaBean pesquisar(long id);

	public List<FamiliaBean> pesquisar();

	public List<FamiliaBean> pesquisar(String nome, boolean identico);

}
