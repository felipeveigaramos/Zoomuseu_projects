package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;

public interface InterfaceClasseModel {

	public long inserir(ClasseBean cb);

	public void remover(long id);

	public void atualizar(ClasseBean cb);

	public ClasseBean pesquisar(long id);

	public List<ClasseBean> pesquisar();

	public List<ClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException;

	public void refresh(ClasseBean cb);
}
