package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.EspecimeDao;

public class EspecimeModel implements InterfaceEspecimeModel {
	private EspecimeDao ed;

	public EspecimeModel() {
		ed = new EspecimeDao();
	}

	@Override
	public long inserir(EspecimeBean eb) {
		EspecimeBean especimeInserida = ed.persistir(eb);
		return especimeInserida.getId() >= 0 ? especimeInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		ed.remover(ed.pesquisar(id));
	}

	@Override
	public void atualizar(EspecimeBean eb) {
		ed.persistir(eb);
	}

	@Override
	public EspecimeBean pesquisar(long id) {
		return ed.pesquisar(id);
	}

	@Override
	public List<EspecimeBean> pesquisar() {
		return ed.listar();
	}

	@Override
	public List<EspecimeBean> pesquisar(String nomesPopulares, boolean identico) {
return ed.pesquisar(nomesPopulares, identico);
	}

	@Override
	public List<EspecimeBean> pesquisarEspecie(String nomeEspecie,
			boolean identico) {
		return ed.pesquisarEspecie(nomeEspecie, identico);
	}

}
