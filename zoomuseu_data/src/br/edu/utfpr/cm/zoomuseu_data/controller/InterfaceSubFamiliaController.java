package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceSubFamiliaController {

	public long inserir(SubFamiliaBean sfb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(SubFamiliaBean sfb, boolean verificar)
			throws ValidationException;

	public SubFamiliaBean pesquisar(long id);

	public List<SubFamiliaBean> pesquisar();

	public List<SubFamiliaBean> pesquisar(String nome, boolean identico);

}
