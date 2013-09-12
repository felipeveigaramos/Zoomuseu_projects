package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.EspecieDao;

public class EspecieModel implements InterfaceEspecieModel {
	private EspecieDao ed;
	private InterfaceSubGeneroModel isgm;

	public EspecieModel() {
		ed = new EspecieDao();
		isgm = ModelFactory.getInstance().getInterfaceSubGeneroModel();
	}

	@Override
	public long inserir(EspecieBean eb) {
		EspecieBean especieInserida = ed.persistir(eb);
		isgm.refresh(especieInserida.getSubGenero());
		return especieInserida.getId() >= 0 ? especieInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		EspecieBean eb = ed.pesquisar(id);
		SubGeneroBean sgb = eb.getSubGenero();
		sgb.getEspecies().remove(eb);
		ed.remover(eb);
		isgm.refresh(sgb);

	}

	@Override
	public void atualizar(EspecieBean eb) {
		EspecieBean eba = ed.pesquisar(eb.getId());
		SubGeneroBean sgba = eba.getSubGenero();
		SubGeneroBean sgb = eb.getSubGenero();

		if (sgba.equals(sgb)) {
			ed.persistir(eb);
			sgba.getEspecies().set(sgba.getEspecies().indexOf(eba), eb);
			isgm.refresh(sgba);
		} else {
			remover(eba.getId());
			inserir(eb);
		}

	}

	@Override
	public EspecieBean pesquisar(long id) {
		return ed.pesquisar(id);
	}

	@Override
	public List<EspecieBean> pesquisar() {
		return ed.listar();
	}

	public List<EspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return ed.pesquisar(nome, identico);

	}

	@Override
	public void refresh(EspecieBean eb) {
		ed.refresh(eb);

	}

}
