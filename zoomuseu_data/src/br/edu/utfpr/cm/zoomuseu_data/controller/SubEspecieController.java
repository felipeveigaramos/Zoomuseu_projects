package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSubEspecieModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class SubEspecieController implements InterfaceSubEspecieController {

	private InterfaceSubEspecieModel isem;

	public SubEspecieController() {
		isem = ModelFactory.getInstance().getInterfaceSubEspecieModel();
	}

	@Override
	public long inserir(SubEspecieBean seb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(seb, verificar, false)) {
			id = isem.inserir(seb);
		}
		return id;
	}

	@Override
	public void remover(long id) {
		isem.remover(id);

	}

	@Override
	public void atualizar(SubEspecieBean seb, boolean verificar)
			throws ValidationException {

		if (eValido(seb, verificar, true)) {
			isem.atualizar(seb);
		}

	}

	@Override
	public SubEspecieBean pesquisar(long id) {
		return isem.pesquisar(id);

	}

	@Override
	public List<SubEspecieBean> pesquisar() {
		return isem.pesquisar();

	}

	@Override
	public List<SubEspecieBean> pesquisar(String nome, boolean identico) {
		try {
			return isem.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SubEspecieBean seb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<SubEspecieBean> lseb = pesquisar(seb.getNome(), true);
		if (lseb != null
				&& lseb.size() == 1
				&& (!atualizar || (atualizar && lseb.get(0).getId() != seb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(seb, verificar);
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
