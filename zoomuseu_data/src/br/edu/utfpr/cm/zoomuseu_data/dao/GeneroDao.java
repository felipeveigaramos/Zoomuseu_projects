package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;

public class GeneroDao extends GenericDao<GeneroBean> {
	public GeneroDao() {
		super(GeneroBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<GeneroBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {

		Query q = session
				.createQuery("select gb from GeneroBean gb where gb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<GeneroBean>) q.list();
	}

}
