package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.FiloDao;

public class FiloModel implements InterfaceFiloModel {
	private FiloDao fd;

	public FiloModel() {
		fd = new FiloDao();
	}

	@Override
	public long inserir(FiloBean fb) {
		FiloBean filoInserido = fd.persistir(fb);
		return filoInserido.getId() >= 0 ? filoInserido.getId() : -1;
	}

	@Override
	public void remover(long id) {
		fd.remover(fd.pesquisar(id));
	}

	@Override
	public void atualizar(FiloBean fb) {
		fd.persistir(fb);
	}

	@Override
	public FiloBean pesquisar(long id) {
		return fd.pesquisar(id);
	}

	@Override
	public List<FiloBean> listar() {
		return fd.listar();
	}

	public List<FiloBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return fd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(FiloBean fb) {
		fd.refresh(fb);

	}
}
