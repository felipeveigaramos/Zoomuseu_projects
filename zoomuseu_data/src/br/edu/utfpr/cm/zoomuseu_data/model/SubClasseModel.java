package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubClasseDao;

public class SubClasseModel implements InterfaceSubClasseModel {

	private SubClasseDao scd;
	InterfaceClasseModel icm;

	public SubClasseModel() {
		scd = new SubClasseDao();
		icm = ModelFactory.getInstance().getInterfaceClasseModel();
	}

	@Override
	public long inserir(SubClasseBean scb) {
		SubClasseBean subClasseInserida = scd.persistir(scb);
		icm.refresh(subClasseInserida.getClasse());
		return subClasseInserida.getId() >= 0 ? subClasseInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		SubClasseBean scb = scd.pesquisar(id);
		ClasseBean cb = scb.getClasse();
		cb.getSubClasses().remove(scb);
		scd.remover(scb);
		icm.refresh(cb);
	}

	@Override
	public void atualizar(SubClasseBean scb) {
		SubClasseBean scba = scd.pesquisar(scb.getId());
		ClasseBean cba = scba.getClasse();
		ClasseBean cb = scb.getClasse();

		if (cba.equals(cb)) {
			scd.persistir(scb);
			cba.getSubClasses().set(cba.getSubClasses().indexOf(scba), scb);
			icm.refresh(cba);
		} else {
			remover(scba.getId());
			inserir(scb);
		}

	}

	@Override
	public SubClasseBean pesquisar(long id) {
		return scd.pesquisar(id);
	}

	@Override
	public List<SubClasseBean> pesquisar() {
		return scd.listar();
	}

	@Override
	public List<SubClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return scd.pesquisar(nome, identico);
	}

	@Override
	public void refresh(SubClasseBean scb) {
		scd.refresh(scb);

	}

}
