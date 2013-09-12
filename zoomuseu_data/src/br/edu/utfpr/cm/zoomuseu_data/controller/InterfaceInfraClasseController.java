package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;

public interface InterfaceInfraClasseController {
	public long inserir(InfraClasseBean icb, boolean verificar)
			throws ValidationException;

	public void remover(long id);

	public void atualizar(InfraClasseBean icb, boolean verificar)
			throws ValidationException;

	public InfraClasseBean pesquisar(long id);

	public List<InfraClasseBean> pesquisar();

	public List<InfraClasseBean> pesquisar(String nome, boolean identico);

}
