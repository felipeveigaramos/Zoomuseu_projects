		package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceFiloModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class FiloController implements InterfaceFiloController {

	private InterfaceFiloModel ifm;

	public FiloController() {
		ifm = ModelFactory.getInstance().getInterfaceFiloModel();
	}

	@Override
	public long inserir(FiloBean fb, boolean verificar)
			throws ValidationException {
		long id = -1;
		if (eValido(fb, verificar)) {
			id = ifm.inserir(fb);
			if (id != -1) {
				SubFiloBean subFiloNaoConsta = new SubFiloBean();
				subFiloNaoConsta.setNome("Não Consta");
				subFiloNaoConsta.setFilo(this.pesquisar(id));
				ControllerFactory.getInstance().getInterfaceSubFiloController()
						.inserir(subFiloNaoConsta, false);
			}
		}
		return id;
	}

	@Override
	public void remover(long id) {
		ifm.remover(id);
		// pegar o model do filo
		// chmar o metodo removerSubFiloBean
	}

	@Override
	public void atualizar(FiloBean fb, boolean verificar)
			throws ValidationException {
		if (eValido(fb, verificar)) {
			ifm.atualizar(fb);
		}
	}

	@Override
	public FiloBean pesquisar(long id) {
		return ifm.pesquisar(id);

	}

	@Override
	public List<FiloBean> pesquisar() {
		return ifm.listar();

	}

	@Override
	public List<FiloBean> pesquisar(String nome, boolean identico) {
		try {
			return ifm.pesquisar(nome, identico);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean eValido(FiloBean fb, boolean verificar)
			throws ValidationException {
		boolean valido = true;
		List<Report> erros = new ArrayList<Report>();
		List<FiloBean> lfb = pesquisar(fb.getNome(), true);
		if (lfb != null && lfb.size() == 1 && lfb.get(0).getId() != fb.getId()) {
			erros.add(new Report("nome",
					"Não pode ser igual a outro já existente"));
			valido = false;
			throw new ValidationException("Nome repetido", erros);
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
