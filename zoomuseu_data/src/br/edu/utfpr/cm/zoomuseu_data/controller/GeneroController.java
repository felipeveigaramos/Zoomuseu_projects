package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceGeneroModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;

public class GeneroController implements InterfaceGeneroController {

	private InterfaceGeneroModel igm;

	public GeneroController() {
		igm = ModelFactory.getInstance().getInterfaceGeneroModel();
	}

	@Override
	public long inserir(GeneroBean gb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(gb, verificar, false)) {
			id = igm.inserir(gb);
			if (id != -1) {
				SubGeneroBean subGeneroNaoConsta = new SubGeneroBean();
				subGeneroNaoConsta.setNome("Não Consta");
				subGeneroNaoConsta.setGenero(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSubGeneroController()
						.inserir(subGeneroNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		igm.remover(id);

	}

	@Override
	public void atualizar(GeneroBean gb, boolean verificar)
			throws ValidationException {

		if (eValido(gb, verificar, true)) {
			igm.atualizar(gb);
		}

	}

	@Override
	public GeneroBean pesquisar(long id) {
		return igm.pesquisar(id);

	}

	@Override
	public List<GeneroBean> pesquisar() {
		return igm.pesquisar();

	}

	@Override
	public List<GeneroBean> pesquisar(String nome, boolean identico) {
		try {
			return igm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(GeneroBean gb, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<GeneroBean> lgb = pesquisar(gb.getNome(), true);
		if (lgb != null
				&& lgb.size() == 1
				&& (!atualizar || (atualizar && lgb.get(0).getId() != gb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(gb, verificar);
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
