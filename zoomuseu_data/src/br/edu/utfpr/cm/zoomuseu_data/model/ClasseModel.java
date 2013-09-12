package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.ClasseDao;

public class ClasseModel implements InterfaceClasseModel {

	private ClasseDao cd;
	InterfaceSubFiloModel isfm;

	public ClasseModel() {
		cd = new ClasseDao();
		isfm = ModelFactory.getInstance().getInterfaceSubFiloModel();
	}

	@Override
	public long inserir(ClasseBean cb) {

		ClasseBean classeInserida = cd.persistir(cb);
		isfm.refresh(classeInserida.getSubFilo());
		return classeInserida.getId() >= 0 ? classeInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		ClasseBean cb = cd.pesquisar(id);
		SubFiloBean sfb = cb.getSubFilo();
		sfb.getClasses().remove(cb);
		cd.remover(cb);
		isfm.refresh(sfb);

	}

	@Override
	public void atualizar(ClasseBean cb) {
		ClasseBean cba = cd.pesquisar(cb.getId());
		SubFiloBean sfba = cba.getSubFilo();
		SubFiloBean sfb = cb.getSubFilo();

		if (sfba.equals(sfb)) {
			cd.persistir(cb);
			sfba.getClasses().set(sfba.getClasses().indexOf(cba), cb);
			isfm.refresh(sfba);
		} else {
			remover(cba.getId());
			inserir(cb);
		}

	}

	@Override
	public ClasseBean pesquisar(long id) {
		return cd.pesquisar(id);
	}

	@Override
	public List<ClasseBean> pesquisar() {
		return cd.listar();
	}

	@Override
	public List<ClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return cd.pesquisar(nome, identico);
	}

	@Override
	public void refresh(ClasseBean cb) {
		cd.refresh(cb);

	}

}
