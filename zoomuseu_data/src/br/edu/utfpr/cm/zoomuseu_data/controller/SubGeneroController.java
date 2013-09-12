package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSubGeneroModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class SubGeneroController implements InterfaceSubGeneroController {
	private InterfaceSubGeneroModel isgm;

	public SubGeneroController() {
		isgm = ModelFactory.getInstance().getInterfaceSubGeneroModel();
	}

	@Override
	public long inserir(SubGeneroBean sgb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(sgb, verificar, false)) {
			id = isgm.inserir(sgb);
		}
		return id;

	}

	@Override
	public void remover(long id) {
		isgm.remover(id);

	}

	@Override
	public void atualizar(SubGeneroBean sgb, boolean verificar)
			throws ValidationException {

		if (eValido(sgb, verificar, true)) {
			isgm.atualizar(sgb);
		}

	}

	@Override
	public SubGeneroBean pesquisar(long id) {
		return isgm.pesquisar(id);

	}

	@Override
	public List<SubGeneroBean> pesquisar() {
		return isgm.pesquisar();

	}

	@Override
	public List<SubGeneroBean> pesquisar(String nome, boolean identico) {
		try {
			return isgm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SubGeneroBean sgb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<SubGeneroBean> lsgb = pesquisar(sgb.getNome(), true);
		if (lsgb != null
				&& lsgb.size() == 1
				&& (!atualizar || (atualizar && lsgb.get(0).getId() != sgb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(sgb, verificar);
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
