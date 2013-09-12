package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceTriboModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class TriboController implements InterfaceTriboController {

	private InterfaceTriboModel itm;

	public TriboController() {
		itm = ModelFactory.getInstance().getInterfaceTriboModel();
	}

	@Override
	public long inserir(TriboBean tb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(tb, verificar, false)) {
			id = itm.inserir(tb);
			if (id != -1) {
				GeneroBean generoNaoConsta = new GeneroBean();
				generoNaoConsta.setNome("Não Consta");
				generoNaoConsta.setTribo(this.pesquisar(id));
				ControllerFactory.getInstance().getInterfaceGeneroController()
						.inserir(generoNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		itm.remover(id);

	}

	@Override
	public void atualizar(TriboBean tb, boolean verificar)
			throws ValidationException {

		if (eValido(tb, verificar, true)) {
			itm.atualizar(tb);
		}

	}

	@Override
	public TriboBean pesquisar(long id) {
		return itm.pesquisar(id);

	}

	@Override
	public List<TriboBean> pesquisar() {
		return itm.pesquisar();

	}

	@Override
	public List<TriboBean> pesquisar(String nome, boolean identico) {
		try {
			return itm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(TriboBean tb, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<TriboBean> ltb = pesquisar(tb.getNome(), true);
		if (ltb != null
				&& ltb.size() == 1
				&& (!atualizar || (atualizar && ltb.get(0).getId() != tb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(tb, verificar);
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
