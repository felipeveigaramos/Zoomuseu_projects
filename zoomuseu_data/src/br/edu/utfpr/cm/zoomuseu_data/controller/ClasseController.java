package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceClasseModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;


public class ClasseController implements InterfaceClasseController {
	private InterfaceClasseModel icm;

	public ClasseController() {
		icm = ModelFactory.getInstance().getInterfaceClasseModel();
	}

	@Override
	public long inserir(ClasseBean cb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(cb, verificar, false)) {
			id = icm.inserir(cb);
			if (id != -1) {
				SubClasseBean subClasseNaoConsta = new SubClasseBean();
				subClasseNaoConsta.setNome("Não Consta");
				subClasseNaoConsta.setClasse(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSubClasseController()
						.inserir(subClasseNaoConsta, false);
			}
		}
		return id;

	}

	@Override
	public void remover(long id) {
		icm.remover(id);

	}

	@Override
	public void atualizar(ClasseBean cb, boolean verificar)
			throws ValidationException {
		if (eValido(cb, verificar, true)) {
			icm.atualizar(cb);
		}

	}

	@Override
	public ClasseBean pesquisar(long id) {
		return icm.pesquisar(id);

	}

	@Override
	public List<ClasseBean> pesquisar() {
		return icm.pesquisar();

	}

	@Override
	public List<ClasseBean> pesquisar(String nome, boolean identico) {
		try {
			return icm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(ClasseBean cb, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = false;
		List<Report> erros = new ArrayList<Report>();
		List<ClasseBean> lcb = pesquisar(cb.getNome(), true);
		if (lcb != null
				&& lcb.size() == 1
				&& (!atualizar || (atualizar && lcb.get(0).getId() != cb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			throw new ValidationException("Nome inválido", erros);
		}

		try {
			valido = Validator.validar(cb, verificar);
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
