package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;

public class TriboDao extends GenericDao<TriboBean> {

	public TriboDao() {
		super(TriboBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<TriboBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select tb from TriboBean tb where tb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<TriboBean>) q.list();
	}

}
