package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;

public class VariedadeDao extends GenericDao<VariedadeBean> {

	public VariedadeDao() {
		super(VariedadeBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<VariedadeBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select vb from VariedadeBean vb where vb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<VariedadeBean>) q.list();
	}

}
