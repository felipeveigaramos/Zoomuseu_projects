package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSuperFamiliaModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;


public class SuperFamiliaController implements InterfaceSuperFamiliaController {

	private InterfaceSuperFamiliaModel isfm;

	public SuperFamiliaController() {
		isfm = ModelFactory.getInstance().getInterfaceSuperFamiliaModel();
	}

	@Override
	public long inserir(SuperFamiliaBean sfb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(sfb, verificar, false)) {
			id = isfm.inserir(sfb);
		}
		return id;
	}

	@Override
	public void remover(long id) {
		isfm.remover(id);

	}

	@Override
	public void atualizar(SuperFamiliaBean sfb, boolean verificar)
			throws ValidationException {
		if (eValido(sfb, verificar, true)) {
			isfm.atualizar(sfb);
		}

	}

	@Override
	public SuperFamiliaBean pesquisar(long id) {
		return isfm.pesquisar(id);

	}

	@Override
	public List<SuperFamiliaBean> pesquisar() {
		return isfm.pesquisar();

	}

	@Override
	public List<SuperFamiliaBean> pesquisar(String nome, boolean identico) {
		try {
			return isfm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SuperFamiliaBean sfb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<SuperFamiliaBean> lsfb = pesquisar(sfb.getNome(), true);
		if (lsfb != null
				&& lsfb.size() == 1
				&& (!atualizar || (atualizar && lsfb.get(0).getId() != sfb
						.getId()))) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome inválido", erros);
		}

		if (valido) {
			try {
				valido = Validator.validar(sfb, verificar);
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
