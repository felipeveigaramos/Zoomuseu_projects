package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;

public class SuperFamiliaDao extends GenericDao<SuperFamiliaBean> {
	public SuperFamiliaDao() {
		super(SuperFamiliaBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SuperFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select sfb from SuperFamiliaBean sfb where sfb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SuperFamiliaBean>) q.list();
	}

}
