package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;

public interface InterfaceFiloModel {

public long inserir(FiloBean fb);

public void remover(long id);

public void atualizar(FiloBean fb);

public FiloBean pesquisar(long id);

public List<FiloBean> listar();

public List<FiloBean> pesquisar(String nome, boolean identico)
throws ClassCastException;

public void refresh(FiloBean fb);
}
