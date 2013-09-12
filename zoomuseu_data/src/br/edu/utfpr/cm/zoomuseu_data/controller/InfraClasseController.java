package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceInfraClasseModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class InfraClasseController implements InterfaceInfraClasseController {
	private InterfaceInfraClasseModel iicm;

	public InfraClasseController() {
		iicm = ModelFactory.getInstance().getInterfaceInfraClasseModel();
	}

	@Override
	public long inserir(InfraClasseBean icb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(icb, verificar, false)) {
			id = iicm.inserir(icb);
		}
		return id;

	}

	@Override
	public void remover(long id) {
		iicm.remover(id);

	}

	@Override
	public void atualizar(InfraClasseBean icb, boolean verificar)
			throws ValidationException {
		if (eValido(icb, verificar, true)) {
			iicm.atualizar(icb);
		}

	}

	@Override
	public InfraClasseBean pesquisar(long id) {
		return iicm.pesquisar(id);

	}

	@Override
	public List<InfraClasseBean> pesquisar() {
		return iicm.pesquisar();
	}

	@Override
	public List<InfraClasseBean> pesquisar(String nome, boolean identico) {
		try {
			return iicm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(InfraClasseBean icb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = false;
		List<Report> erros = new ArrayList<Report>();
		List<InfraClasseBean> licb = pesquisar(icb.getNome(), true);
		if (licb != null
				&& licb.size() == 1
				&& (!atualizar || (atualizar && licb.get(0).getId() != icb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			throw new ValidationException("Nome inválido", erros);
		}

		try {
			valido = Validator.validar(icb, verificar);
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
