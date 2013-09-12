package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubEspecieDao;

public class SubEspecieModel implements InterfaceSubEspecieModel {
	private SubEspecieDao sed;
	private InterfaceEspecieModel iem;

	public SubEspecieModel() {
		sed = new SubEspecieDao();
		iem = ModelFactory.getInstance().getInterfaceEspecieModel();
	}

	@Override
	public long inserir(SubEspecieBean seb) {
		SubEspecieBean subEspecieInserida = sed.persistir(seb);
		iem.refresh(subEspecieInserida.getEspecie());
		return subEspecieInserida.getId() >= 0 ? subEspecieInserida.getId()
				: -1;
	}

	@Override
	public void remover(long id) {
		SubEspecieBean seb = sed.pesquisar(id);
		EspecieBean eb = seb.getEspecie();
		eb.getSubEspecies().remove(seb);
		sed.remover(seb);
		iem.refresh(eb);

	}

	@Override
	public void atualizar(SubEspecieBean seb) {
		SubEspecieBean seba = sed.pesquisar(seb.getId());
		EspecieBean eba = seba.getEspecie();
		EspecieBean eb = seb.getEspecie();

		if (eba.equals(eb)) {
			sed.persistir(seb);
			eba.getSubEspecies().set(eba.getSubEspecies().indexOf(seba), seb);
			iem.refresh(eba);
		} else {
			remover(seba.getId());
			inserir(seb);
		}

	}

	@Override
	public SubEspecieBean pesquisar(long id) {
		return sed.pesquisar(id);
	}

	@Override
	public List<SubEspecieBean> pesquisar() {
		return sed.listar();
	}

	public List<SubEspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return sed.pesquisar(nome, identico);

	}

	@Override
	public void refresh(SubEspecieBean seb) {
		sed.refresh(seb);

	}

}
