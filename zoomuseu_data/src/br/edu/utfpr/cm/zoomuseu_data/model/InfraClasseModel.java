package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.InfraClasseDao;

public class InfraClasseModel implements InterfaceInfraClasseModel {
	private InfraClasseDao icd;
	private InterfaceSubClasseModel iscm;

	public InfraClasseModel() {
		icd = new InfraClasseDao();
		iscm = ModelFactory.getInstance().getInterfaceSubClasseModel();
	}

	@Override
	public long inserir(InfraClasseBean icb) {
		InfraClasseBean infraClasseInserida = icd.persistir(icb);
		iscm.refresh(infraClasseInserida.getSubClasse());
		return infraClasseInserida.getId() >= 0 ? infraClasseInserida.getId()
				: -1;
	}

	@Override
	public void remover(long id) {
		InfraClasseBean icb = icd.pesquisar(id);
		SubClasseBean scb = icb.getSubClasse();
		scb.getInfraClasses().remove(icb);
		icd.remover(icb);
		iscm.refresh(scb);
	}

	@Override
	public void atualizar(InfraClasseBean icb) {
		InfraClasseBean icba = icd.pesquisar(icb.getId());
		SubClasseBean scba = icba.getSubClasse();
		SubClasseBean scb = icb.getSubClasse();
		icd.persistir(icb);

		if (scba.equals(scb)) {
			scba.getInfraClasses().set(scba.getInfraClasses().indexOf(icba),
					icb);
			iscm.refresh(scba);
		} else {
			remover(icba.getId());
			inserir(icb);
		}
	}

	@Override
	public InfraClasseBean pesquisar(long id) {
		return icd.pesquisar(id);
	}

	@Override
	public List<InfraClasseBean> pesquisar() {
		return icd.listar();
	}

	@Override
	public List<InfraClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		return icd.pesquisar(nome, identico);
	}

	@Override
	public void refresh(InfraClasseBean icb) {
		icd.refresh(icb);

	}

}
