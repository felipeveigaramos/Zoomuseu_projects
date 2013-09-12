package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.LocalizacaoDao;

public class LocalizacaoModel implements InterfaceLocalizacaoModel {
	private LocalizacaoDao ld;

	public LocalizacaoModel() {
		ld = new LocalizacaoDao();
	}

	@Override
	public long inserir(LocalizacaoBean lb) {
		LocalizacaoBean localizacaoInserida = ld.persistir(lb);
		return localizacaoInserida.getId() >= 0 ? localizacaoInserida.getId()
				: -1;
	}

	@Override
	public void remover(long id) {
		ld.remover(ld.pesquisar(id));
	}

	@Override
	public void atualizar(LocalizacaoBean lb) {
		ld.persistir(lb);
	}

	@Override
	public LocalizacaoBean pesquisar(long id) {
		return ld.pesquisar(id);
	}

	@Override
	public List<LocalizacaoBean> pesquisar() {
		return ld.listar();
	}

	@Override
	public void refresh(LocalizacaoBean lb) {
		ld.refresh(lb);

	}

	@Override
	public List<LocalizacaoBean> pesquisarMunicipio(String municipio,
			boolean identico) {
		return ld.pesquisarMunicipio(municipio, identico);
	}

}
