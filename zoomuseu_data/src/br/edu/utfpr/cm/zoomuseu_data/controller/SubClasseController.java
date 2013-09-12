package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSubClasseModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class SubClasseController implements InterfaceSubClasseController {

	private InterfaceSubClasseModel iscm;

	public SubClasseController() {
		iscm = ModelFactory.getInstance().getInterfaceSubClasseModel();
	}

	@Override
	public long inserir(SubClasseBean scb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(scb, verificar, false)) {
			id = iscm.inserir(scb);
			if (id != -1) {
				InfraClasseBean infraClasseNaoConsta = new InfraClasseBean();
				infraClasseNaoConsta.setNome("Não Consta");
				infraClasseNaoConsta.setSubClasse(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceInfraClasseController()
						.inserir(infraClasseNaoConsta, false);
			}
		}
		return id;

	}

	@Override
	public void remover(long id) {
		iscm.remover(id);

	}

	@Override
	public void atualizar(SubClasseBean scb, boolean verificar)
			throws ValidationException {
		if (eValido(scb, verificar, true)) {
			iscm.atualizar(scb);
		}

	}

	@Override
	public SubClasseBean pesquisar(long id) {
		return iscm.pesquisar(id);

	}

	@Override
	public List<SubClasseBean> pesquisar() {
		return iscm.pesquisar();
	}

	@Override
	public List<SubClasseBean> pesquisar(String nome, boolean identico) {
		try {
			return iscm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SubClasseBean scb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = false;
		List<Report> erros = new ArrayList<Report>();
		List<SubClasseBean> lscb = pesquisar(scb.getNome(), true);
		if (lscb != null
				&& lscb.size() == 1
				&& (!atualizar || (atualizar && lscb.get(0).getId() != scb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			throw new ValidationException("Nome inválido", erros);
		}

		try {
			valido = Validator.validar(scb, verificar);
		} catch (ValidationException ve) {
			if (erros != null && erros.size() > 0) {
				ve.addErros(erros);
			}
			throw ve;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valido;
	}
}
