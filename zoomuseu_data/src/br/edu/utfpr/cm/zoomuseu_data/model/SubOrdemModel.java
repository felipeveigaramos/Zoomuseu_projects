package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubOrdemDao;

public class SubOrdemModel implements InterfaceSubOrdemModel {
	private SubOrdemDao sod;
	private InterfaceOrdemModel iom;

	public SubOrdemModel() {
		sod = new SubOrdemDao();
		iom = ModelFactory.getInstance().getInterfaceOrdemModel();
	}

	@Override
	public long inserir(SubOrdemBean sob) {
		SubOrdemBean subOrdemInserida = sod.persistir(sob);
		iom.refresh(subOrdemInserida.getOrdem());
		return subOrdemInserida.getId() >= 0 ? subOrdemInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		SubOrdemBean sob = sod.pesquisar(id);
		OrdemBean ob = sob.getOrdem();
		ob.getSubOrdens().remove(sob);
		sod.remover(sob);
		iom.refresh(ob);

	}

	@Override
	public void atualizar(SubOrdemBean sob) {
		SubOrdemBean soba = sod.pesquisar(sob.getId());
		OrdemBean oba = soba.getOrdem();
		OrdemBean ob = sob.getOrdem();

		if (oba.equals(ob)) {
			sod.persistir(sob);
			oba.getSubOrdens().set(oba.getSubOrdens().indexOf(soba), sob);
			iom.refresh(oba);
		} else {
			remover(soba.getId());
			inserir(sob);
		}

	}

	@Override
	public SubOrdemBean pesquisar(long id) {
		return sod.pesquisar(id);
	}

	@Override
	public List<SubOrdemBean> pesquisar() {
		return sod.listar();
	}

	public List<SubOrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return sod.pesquisar(nome, identico);

	}

	@Override
	public void refresh(SubOrdemBean sob) {
		sod.refresh(sob);

	}

}
