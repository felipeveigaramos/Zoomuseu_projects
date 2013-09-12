package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.FamiliaDao;

public class FamiliaModel implements InterfaceFamiliaModel {
	private FamiliaDao fd;
	private InterfaceSuperFamiliaModel isfm;

	public FamiliaModel() {
		fd = new FamiliaDao();
		isfm = ModelFactory.getInstance().getInterfaceSuperFamiliaModel();
	}

	@Override
	public long inserir(FamiliaBean fb) {
		FamiliaBean familiaInserida = fd.persistir(fb);
		isfm.refresh(familiaInserida.getSuperFamilia());
		return familiaInserida.getId() >= 0 ? familiaInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		FamiliaBean fb = fd.pesquisar(id);
		SuperFamiliaBean sfb = fb.getSuperFamilia();
		sfb.getFamilias().remove(fb);
		fd.remover(fb);
		isfm.refresh(sfb);

	}

	@Override
	public void atualizar(FamiliaBean fb) {
		FamiliaBean fba = fd.pesquisar(fb.getId());
		SuperFamiliaBean sfba = fba.getSuperFamilia();
		SuperFamiliaBean sfb = fb.getSuperFamilia();

		if (sfba.equals(sfb)) {
			fd.persistir(fb);
			sfba.getFamilias().set(sfba.getFamilias().indexOf(fba), fb);
			isfm.refresh(sfba);
		} else {
			remover(fba.getId());
			inserir(fb);
		}

	}

	@Override
	public FamiliaBean pesquisar(long id) {
		return fd.pesquisar(id);
	}

	@Override
	public List<FamiliaBean> pesquisar() {
		return fd.listar();
	}

	public List<FamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return fd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(FamiliaBean fb) {
		fd.refresh(fb);

	}

}
