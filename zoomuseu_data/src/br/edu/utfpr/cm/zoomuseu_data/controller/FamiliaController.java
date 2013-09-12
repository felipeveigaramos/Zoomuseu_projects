package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceFamiliaModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;

public class FamiliaController implements InterfaceFamiliaController {

	private InterfaceFamiliaModel ifm;

	public FamiliaController() {
		ifm = ModelFactory.getInstance().getInterfaceFamiliaModel();
	}

	@Override
	public long inserir(FamiliaBean fb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(fb, verificar, false)) {
			id = ifm.inserir(fb);
			if (id != -1) {
				SubFamiliaBean subFamiliaNaoConsta = new SubFamiliaBean();
				subFamiliaNaoConsta.setNome("Não Consta");
				subFamiliaNaoConsta.setFamilia(this.pesquisar(id));
				ControllerFactory.getInstance()
						.getInterfaceSubFamiliaController()
						.inserir(subFamiliaNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		ifm.remover(id);

	}

	@Override
	public void atualizar(FamiliaBean fb, boolean verificar)
			throws ValidationException {
		if (eValido(fb, verificar, true)) {
			ifm.atualizar(fb);
		}
	}

	@Override
	public FamiliaBean pesquisar(long id) {
		return ifm.pesquisar(id);

	}

	@Override
	public List<FamiliaBean> pesquisar() {
		return ifm.pesquisar();

	}

	@Override
	public List<FamiliaBean> pesquisar(String nome, boolean identico) {
		try {
			return ifm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(FamiliaBean fb, boolean verificar, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<FamiliaBean> lfb = pesquisar(fb.getNome(), true);
		if (lfb != null
				&& lfb.size() == 1
				&& (!atualizar || (atualizar && lfb.get(0).getId() != fb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(fb, verificar);
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
