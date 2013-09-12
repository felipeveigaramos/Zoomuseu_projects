package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubGeneroDao;

public class SubGeneroModel implements InterfaceSubGeneroModel {
	private SubGeneroDao sgd;
	private InterfaceGeneroModel igm;

	public SubGeneroModel() {
		sgd = new SubGeneroDao();
		igm = ModelFactory.getInstance().getInterfaceGeneroModel();
	}

	@Override
	public long inserir(SubGeneroBean sgb) {
		SubGeneroBean subGeneroInserido = sgd.persistir(sgb);
		igm.refresh(subGeneroInserido.getGenero());
		return subGeneroInserido.getId() >= 0 ? subGeneroInserido.getId() : -1;
	}

	@Override
	public void remover(long id) {
		SubGeneroBean sgb = sgd.pesquisar(id);
		GeneroBean gb = sgb.getGenero();
		gb.getSubGeneros().remove(sgb);
		sgd.remover(sgb);
		igm.refresh(gb);

	}

	@Override
	public void atualizar(SubGeneroBean sgb) {
		SubGeneroBean sgba = sgd.pesquisar(sgb.getId());
		GeneroBean gba = sgba.getGenero();
		GeneroBean gb = sgb.getGenero();

		if (gba.equals(gb)) {
			sgd.persistir(sgb);
			gba.getSubGeneros().set(gba.getSubGeneros().indexOf(sgba), sgb);
			igm.refresh(gba);
		} else {
			remover(sgba.getId());
			inserir(sgb);
		}

	}

	@Override
	public SubGeneroBean pesquisar(long id) {
		return sgd.pesquisar(id);
	}

	@Override
	public List<SubGeneroBean> pesquisar() {
		return sgd.listar();
	}

	public List<SubGeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return sgd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(SubGeneroBean sgb) {
		sgd.refresh(sgb);

	}

}
