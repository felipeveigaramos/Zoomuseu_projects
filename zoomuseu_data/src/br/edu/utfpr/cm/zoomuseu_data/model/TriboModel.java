package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.TriboDao;

public class TriboModel implements InterfaceTriboModel {
	private TriboDao td;
	private InterfaceSubFamiliaModel isfm;

	public TriboModel() {
		td = new TriboDao();
		isfm = ModelFactory.getInstance().getInterfaceSubFamiliaModel();
	}

	@Override
	public long inserir(TriboBean tb) {
		TriboBean triboInserida = td.persistir(tb);
		isfm.refresh(triboInserida.getSubFamilia());
		return triboInserida.getId() >= 0 ? triboInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		TriboBean tb = td.pesquisar(id);
		SubFamiliaBean sfb = tb.getSubFamilia();
		sfb.getTribos().remove(tb);
		td.remover(tb);
		isfm.refresh(sfb);
	}

	@Override
	public void atualizar(TriboBean tb) {
		TriboBean tba = td.pesquisar(tb.getId());
		SubFamiliaBean sfba = tba.getSubFamilia();
		SubFamiliaBean sfb = tb.getSubFamilia();

		if (sfba.equals(sfb)) {
			td.persistir(tb);
			sfba.getTribos().set(sfba.getTribos().indexOf(tba), tb);
			isfm.refresh(sfba);
		} else {
			remover(tba.getId());
			inserir(tb);
		}

	}

	@Override
	public TriboBean pesquisar(long id) {
		return td.pesquisar(id);
	}

	@Override
	public List<TriboBean> pesquisar() {
		return td.listar();
	}

	public List<TriboBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return td.pesquisar(nome, identico);

	}

	@Override
	public void refresh(TriboBean tb) {
		td.refresh(tb);

	}

}
