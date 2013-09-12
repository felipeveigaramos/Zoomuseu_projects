package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceVariedadeModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;


public class VariedadeController implements InterfaceVariedadeController {
	private InterfaceVariedadeModel ivm;

	public VariedadeController() {
		ivm = ModelFactory.getInstance().getInterfaceVariedadeModel();
	}

	@Override
	public long inserir(VariedadeBean vb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(vb, verificar, false)) {
			id = ivm.inserir(vb);
		}
		return id;

	}

	@Override
	public void remover(long id) {
		ivm.remover(id);

	}

	@Override
	public void atualizar(VariedadeBean vb, boolean verificar)
			throws ValidationException {

		if (eValido(vb, verificar, true)) {
			ivm.atualizar(vb);
		}

	}

	@Override
	public VariedadeBean pesquisar(long id) {
		return ivm.pesquisar(id);

	}

	@Override
	public List<VariedadeBean> pesquisar() {
		return ivm.pesquisar();

	}

	@Override
	public List<VariedadeBean> pesquisar(String nome, boolean identico) {
		try {
			return ivm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(VariedadeBean vb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<VariedadeBean> lvb = pesquisar(vb.getNome(), true);
		if (lvb != null
				&& lvb.size() == 1
				&& (!atualizar || (atualizar && lvb.get(0).getId() != vb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(vb, verificar);
			} catch (ValidationException ve) {
				if (erros != null && erros.size() > 0) {
					ve.addErros(erros);
				}
				throw ve;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return valido;
	}
}
