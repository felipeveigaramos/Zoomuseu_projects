package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.VariedadeDao;

public class VariedadeModel implements InterfaceVariedadeModel {
	private VariedadeDao vd;
	private InterfaceSubEspecieModel isem;

	public VariedadeModel() {
		vd = new VariedadeDao();
		isem = ModelFactory.getInstance().getInterfaceSubEspecieModel();
	}

	@Override
	public long inserir(VariedadeBean vb) {
		VariedadeBean variedadeInserida = vd.persistir(vb);
		isem.refresh(variedadeInserida.getSubEspecie());
		return variedadeInserida.getId() >= 0 ? variedadeInserida.getId() : -1;
	}

	@Override
	public void remover(long id) {
		VariedadeBean vb = vd.pesquisar(id);
		SubEspecieBean seb = vb.getSubEspecie();
		seb.getVariedades().remove(vb);
		vd.remover(vb);
		isem.refresh(seb);

	}

	@Override
	public void atualizar(VariedadeBean vb) {
		VariedadeBean vba = vd.pesquisar(vb.getId());
		SubEspecieBean seba = vba.getSubEspecie();
		SubEspecieBean seb = vb.getSubEspecie();

		if (seba.equals(seb)) {
			vd.persistir(vb);
			seba.getVariedades().set(seba.getVariedades().indexOf(vba), vb);
			isem.refresh(seba);
		} else {
			remover(vba.getId());
			inserir(vb);
		}

	}

	@Override
	public VariedadeBean pesquisar(long id) {
		return vd.pesquisar(id);
	}

	@Override
	public List<VariedadeBean> pesquisar() {
		return vd.listar();
	}

	public List<VariedadeBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return vd.pesquisar(nome, identico);

	}

	@Override
	public void refresh(VariedadeBean vb) {
		vd.refresh(vb);

	}

}
