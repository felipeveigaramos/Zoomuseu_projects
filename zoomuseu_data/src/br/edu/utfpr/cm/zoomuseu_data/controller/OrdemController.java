package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceOrdemModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class OrdemController implements InterfaceOrdemController {

	private InterfaceOrdemModel iom;

	public OrdemController() {
		iom = ModelFactory.getInstance().getInterfaceOrdemModel();
	}

	@Override
	public long inserir(OrdemBean ob, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(ob, verificar, false)) {
			id = iom.inserir(ob);
			if (id != -1) {
				SubOrdemBean subOrdemNaoConsta = new SubOrdemBean();
				subOrdemNaoConsta.setNome("Não Consta");
				subOrdemNaoConsta.setOrdem(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSubOrdemController()
						.inserir(subOrdemNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		iom.remover(id);

	}

	@Override
	public void atualizar(OrdemBean ob, boolean verificar)
			throws ValidationException {
		if (eValido(ob, verificar, true)) {
			iom.atualizar(ob);
		}

	}

	@Override
	public OrdemBean pesquisar(long id) {
		return iom.pesquisar(id);

	}

	@Override
	public List<OrdemBean> pesquisar() {
		return iom.pesquisar();

	}

	@Override
	public List<OrdemBean> pesquisar(String nome, boolean identico) {
		try {
			return iom.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(OrdemBean ob, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<OrdemBean> lob = pesquisar(ob.getNome(), true);
		if (lob != null
				&& lob.size() == 1
				&& (!atualizar || (atualizar && lob.get(0).getId() != ob
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(ob, verificar);
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
