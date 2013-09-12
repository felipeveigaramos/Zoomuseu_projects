package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubFamiliaDao;

public class SubFamiliaModel implements InterfaceSubFamiliaModel {
	private SubFamiliaDao sfd;
	private InterfaceFamiliaModel ifm;

	public SubFamiliaModel() {
		sfd = new SubFamiliaDao();
		ifm = ModelFactory.getInstance().getInterfaceFamiliaModel();
	}

	@Override
	public long inserir(SubFamiliaBean sfb) {
		SubFamiliaBean subFamiliaInserida = sfd.persistir(sfb);
		ifm.refresh(subFamiliaInserida.getFamilia());
		return subFamiliaInserida.getId() >= 0 ? subFamiliaInserida.getId()
				: -1;
	}

	@Override
	public void remover(long id) {
		SubFamiliaBean sfb = sfd.pesquisar(id);
		FamiliaBean fb = sfb.getFamilia();
		fb.getSubFamilias().remove(sfb);
		sfd.remover(sfb);
		ifm.refresh(fb);

	}

	@Override
	public void atualizar(SubFamiliaBean sfb) {
		SubFamiliaBean sfba = sfd.pesquisar(sfb.getId());
		FamiliaBean fba = sfba.getFamilia();
		FamiliaBean fb = sfb.getFamilia();

		if (fba.equals(fb)) {
			sfd.persistir(sfb);
			fba.getSubFamilias().set(fba.getSubFamilias().indexOf(sfba), sfb);
			ifm.refresh(fba);
		} else {
			remover(sfba.getId());
			inserir(sfb);
		}

	}

	@Override
	public SubFamiliaBean pesquisar(long id) {
		return sfd.pesquisar(id);
	}

	@Override
	public List<SubFamiliaBean> pesquisar() {
		return sfd.listar();
	}

	public List<SubFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return sfd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(SubFamiliaBean sfb) {
		sfd.refresh(sfb);

	}

}
