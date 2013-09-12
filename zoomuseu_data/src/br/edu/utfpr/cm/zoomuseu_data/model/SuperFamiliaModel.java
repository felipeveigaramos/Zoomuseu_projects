package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SuperFamiliaDao;

public class SuperFamiliaModel implements InterfaceSuperFamiliaModel {

	private SuperFamiliaDao sfd;
	private InterfaceSubOrdemModel isom;

	public SuperFamiliaModel() {
		sfd = new SuperFamiliaDao();
		isom = ModelFactory.getInstance().getInterfaceSubOrdemModel();
	}

	@Override
	public long inserir(SuperFamiliaBean sfb) {
		SuperFamiliaBean superFamiliaInserida = sfd.persistir(sfb);
		isom.refresh(superFamiliaInserida.getSubOrdem());
		return superFamiliaInserida.getId() >= 0 ? superFamiliaInserida.getId()
				: -1;
	}

	@Override
	public void remover(long id) {
		SuperFamiliaBean sfb = sfd.pesquisar(id);
		SubOrdemBean sob = sfb.getSubOrdem();
		sob.getSuperFamilias().remove(sfb);
		sfd.remover(sfb);
		isom.refresh(sob);

	}

	@Override
	public void atualizar(SuperFamiliaBean sfb) {
		SuperFamiliaBean sfba = sfd.pesquisar(sfb.getId());
		SubOrdemBean soba = sfba.getSubOrdem();
		SubOrdemBean sob = sfb.getSubOrdem();

		if (soba.equals(sob)) {
			sfd.persistir(sfb);
			soba.getSuperFamilias().set(soba.getSuperFamilias().indexOf(sfba),
					sfb);
			isom.refresh(soba);
		} else {
			remover(sfba.getId());
			inserir(sfb);
		}

	}

	@Override
	public SuperFamiliaBean pesquisar(long id) {
		return sfd.pesquisar(id);
	}

	@Override
	public List<SuperFamiliaBean> pesquisar() {
		return sfd.listar();
	}

	public List<SuperFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return sfd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(SuperFamiliaBean sfb) {
		sfd.refresh(sfb);

	}
}
