package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;

public class SubEspecieDao extends GenericDao<SubEspecieBean> {
	public SubEspecieDao() {
		super(SubEspecieBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubEspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select seb from SubEspecieBean seb where seb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubEspecieBean>) q.list();

	}

}
