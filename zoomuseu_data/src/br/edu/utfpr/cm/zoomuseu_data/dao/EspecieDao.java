package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;

public class EspecieDao extends GenericDao<EspecieBean> {

	public EspecieDao() {
		super(EspecieBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<EspecieBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select eb from EspecieBean eb where eb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<EspecieBean>) q.list();
	}

}
