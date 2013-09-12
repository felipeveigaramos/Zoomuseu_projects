package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceSubFamiliaModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class SubFamiliaController implements InterfaceSubFamiliaController {

	private InterfaceSubFamiliaModel isfm;

	public SubFamiliaController() {
		isfm = ModelFactory.getInstance().getInterfaceSubFamiliaModel();
	}

	@Override
	public long inserir(SubFamiliaBean sfb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(sfb, verificar, false)) {
			id = isfm.inserir(sfb);
			if (id != -1) {
				TriboBean triboNaoConsta = new TriboBean();
				triboNaoConsta.setNome("Não Consta");
				triboNaoConsta.setSubFamilia(this.pesquisar(id));
				ControllerFactory.getInstance().getInterfaceTriboController()
						.inserir(triboNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		isfm.remover(id);

	}

	@Override
	public void atualizar(SubFamiliaBean sfb, boolean verificar)
			throws ValidationException {
		if (eValido(sfb, verificar, true)) {
			isfm.atualizar(sfb);
		}

	}

	@Override
	public SubFamiliaBean pesquisar(long id) {
		return isfm.pesquisar(id);

	}

	@Override
	public List<SubFamiliaBean> pesquisar() {
		return isfm.pesquisar();

	}

	@Override
	public List<SubFamiliaBean> pesquisar(String nome, boolean identico) {
		try {
			return isfm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(SubFamiliaBean sfb, boolean verificar,
			boolean atualizar) throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<SubFamiliaBean> lsfb = pesquisar(sfb.getNome(), true);
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
