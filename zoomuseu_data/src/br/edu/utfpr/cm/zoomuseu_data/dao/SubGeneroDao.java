package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;

public class SubGeneroDao extends GenericDao<SubGeneroBean> {
	public SubGeneroDao() {
		super(SubGeneroBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubGeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select sgb from SubGeneroBean sgb where sgb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubGeneroBean>) q.list();
	}

}
