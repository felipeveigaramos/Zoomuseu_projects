package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.OrdemDao;

public class OrdemModel implements InterfaceOrdemModel {

	private OrdemDao od;
	private InterfaceInfraClasseModel iicm;

	public OrdemModel() {
		od = new OrdemDao();
		iicm = ModelFactory.getInstance().getInterfaceInfraClasseModel();
	}

	@Override
	public long inserir(OrdemBean ob) {
		OrdemBean ordemInserida = od.persistir(ob);
		iicm.refresh(ordemInserida.getInfraClasse());
		return ordemInserida.getId() >= 0 ? ordemInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		OrdemBean ob = od.pesquisar(id);
		InfraClasseBean icb = ob.getInfraClasse();
		icb.getOrdens().remove(ob);
		od.remover(ob);
		iicm.refresh(icb);

	}

	@Override
	public void atualizar(OrdemBean ob) {
		OrdemBean oba = od.pesquisar(ob.getId());
		InfraClasseBean icba = oba.getInfraClasse();
		InfraClasseBean icb = ob.getInfraClasse();

		if (icba.equals(icb)) {
			od.persistir(ob);
			icba.getOrdens().set(icba.getOrdens().indexOf(oba), ob);
			iicm.refresh(icba);
		} else {
			remover(oba.getId());
			inserir(ob);
		}

	}

	@Override
	public OrdemBean pesquisar(long id) {
		return od.pesquisar(id);
	}

	@Override
	public List<OrdemBean> pesquisar() {
		return od.listar();
	}

	@Override
	public List<OrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return od.pesquisar(nome, identico);
	}

	@Override
	public void refresh(OrdemBean ob) {
		od.refresh(ob);

	}

}