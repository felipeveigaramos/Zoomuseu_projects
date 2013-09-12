package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;

public class SubClasseDao extends GenericDao<SubClasseBean> {
	public SubClasseDao() {
		super(SubClasseBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select scb from SubClasseBean scb where scb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubClasseBean>) q.list();

	}
}
