package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSubOrdemModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class SubOrdemController implements InterfaceSubOrdemController {

	private InterfaceSubOrdemModel isom;

	public SubOrdemController() {
		isom = ModelFactory.getInstance().getInterfaceSubOrdemModel();
	}

	@Override
	public long inserir(SubOrdemBean sob, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(sob, verificar, false)) {
			id = isom.inserir(sob);
			if (id != -1) {
				SuperFamiliaBean superFamiliaNaoConsta = new SuperFamiliaBean();
				superFamiliaNaoConsta.setNome("Não Consta");
				superFamiliaNaoConsta.setSubOrdem(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSuperFamiliaController()
						.inserir(superFamiliaNaoConsta, false);
			}
		}
		return id;

	}

	@Override
	public void remover(long id) {
		isom.remover(id);

	}

	@Override
	public void atualizar(SubOrdemBean sob, boolean verificar)
			throws ValidationException {

		if (eValido(sob, verificar, true)) {
			isom.atualizar(sob);
		}

	}

	@Override
	public SubOrdemBean pesquisar(long id) {
		return isom.pesquisar(id);

	}

	@Override
	public List<SubOrdemBean> pesquisar() {
		return isom.pesquisar();

	}

	@Override
	public List<SubOrdemBean> pesquisar(String nome, boolean identico) {
		try {
			return isom.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SubOrdemBean sob, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<SubOrdemBean> lsob = pesquisar(sob.getNome(), true);
		if (lsob != null
				&& lsob.size() == 1
				&& (!atualizar || (atualizar && lsob.get(0).getId() != sob
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(sob, verificar);
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
