package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceLocalizacaoModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;


public class LocalizacaoController implements InterfaceLocalizacaoController {

	private InterfaceLocalizacaoModel ilm;

	public LocalizacaoController() {
		ilm = ModelFactory.getInstance().getInterfaceLocalizacaoModel();
	}

	@Override
	public long inserir(LocalizacaoBean lb) throws ValidationException {
		long id = -1;
		if (eValido(lb, false)) {
			id = ilm.inserir(lb);
		}
		return id;
	}

	@Override
	public void remover(long id) {
		ilm.remover(id);
	}

	@Override
	public void atualizar(LocalizacaoBean lb) throws ValidationException {
		if (eValido(lb, true)) {
			ilm.atualizar(lb);
		}
	}

	@Override
	public LocalizacaoBean pesquisar(long id) {
		return ilm.pesquisar(id);

	}

	@Override
	public List<LocalizacaoBean> pesquisar() {
		return ilm.pesquisar();

	}

	private boolean eValido(LocalizacaoBean lb, boolean atualizar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();

		if (valido) {
			try {
				valido = Validator.validar(lb, false);
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

	@Override
	public List<LocalizacaoBean> pesquisarMunicipio(String municipio,
			boolean identico) {
		return ilm.pesquisarMunicipio(municipio, identico);
	}

}
