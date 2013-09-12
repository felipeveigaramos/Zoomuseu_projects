package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;

public class SubFiloDao extends GenericDao<SubFiloBean> {

	public SubFiloDao() {
		super(SubFiloBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubFiloBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select sfb from SubFiloBean sfb where sfb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubFiloBean>) q.list();

	}
}
