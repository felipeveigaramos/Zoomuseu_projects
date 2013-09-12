package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceEspecieModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;

public class EspecieController implements InterfaceEspecieController {
	private InterfaceEspecieModel iem;

	public EspecieController() {
		iem = ModelFactory.getInstance().getInterfaceEspecieModel();
	}

	@Override
	public long inserir(EspecieBean eb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(eb, verificar, false)) {
			id = iem.inserir(eb);
			if (id != -1) {
				SubEspecieBean subEspecieNaoConsta = new SubEspecieBean();
				subEspecieNaoConsta.setNome("Não Consta");
				subEspecieNaoConsta.setEspecie(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSubEspecieController()
						.inserir(subEspecieNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		iem.remover(id);

	}

	@Override
	public void atualizar(EspecieBean eb, boolean verificar)
			throws ValidationException {

		if (eValido(eb, verificar, true)) {
			iem.atualizar(eb);
		}

	}

	@Override
	public EspecieBean pesquisar(long id) {
		return iem.pesquisar(id);

	}

	@Override
	public List<EspecieBean> pesquisar() {
		return iem.pesquisar();

	}

	@Override
	public List<EspecieBean> pesquisar(String nome, boolean identico) {
		try {
			return iem.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(EspecieBean eb, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<EspecieBean> leb = pesquisar(eb.getNome(), true);
		if (leb != null
				&& leb.size() == 1
				&& (!atualizar || (atualizar && leb.get(0).getId() != eb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(eb, verificar);
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
