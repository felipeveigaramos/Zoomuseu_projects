package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.GeneroDao;

public class GeneroModel implements InterfaceGeneroModel {

	private GeneroDao gd;
	private InterfaceTriboModel itm;

	public GeneroModel() {
		gd = new GeneroDao();
		itm = ModelFactory.getInstance().getInterfaceTriboModel();
	}

	@Override
	public long inserir(GeneroBean gb) {
		GeneroBean generoInserido = gd.persistir(gb);
		itm.refresh(generoInserido.getTribo());
		return generoInserido.getId() >= 0 ? generoInserido.getId() : -1;
	}

	@Override
	public void remover(long id) {
		GeneroBean gb = gd.pesquisar(id);
		TriboBean tb = gb.getTribo();
		tb.getGeneros().remove(gb);
		gd.remover(gb);
		itm.refresh(tb);
	}

	@Override
	public void atualizar(GeneroBean gb) {
		GeneroBean gba = gd.pesquisar(gb.getId());
		TriboBean tba = gba.getTribo();
		TriboBean tb = gb.getTribo();

		if (tba.equals(tb)) {
			gd.persistir(gb);
			tba.getGeneros().set(tba.getGeneros().indexOf(gba), gb);
			itm.refresh(tba);
		} else {
			remover(gba.getId());
			inserir(gb);
		}
	}

	@Override
	public GeneroBean pesquisar(long id) {
		return gd.pesquisar(id);
	}

	@Override
	public List<GeneroBean> pesquisar() {
		return gd.listar();
	}

	public List<GeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return gd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(GeneroBean gb) {
		gd.refresh(gb);
	}

}
