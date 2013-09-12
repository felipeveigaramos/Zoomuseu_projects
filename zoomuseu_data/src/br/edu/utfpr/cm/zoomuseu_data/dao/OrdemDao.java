package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;

public class OrdemDao extends GenericDao<OrdemBean> {
	public OrdemDao() {
		super(OrdemBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<OrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select ob from OrdemBean ob where ob.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<OrdemBean>) q.list();

	}
}
