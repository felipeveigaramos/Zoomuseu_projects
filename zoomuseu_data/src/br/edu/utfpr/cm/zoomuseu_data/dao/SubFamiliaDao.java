package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;

public class SubFamiliaDao extends GenericDao<SubFamiliaBean> {
	public SubFamiliaDao() {
		super(SubFamiliaBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubFamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select sfb from SubFamiliaBean sfb where sfb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubFamiliaBean>) q.list();

	}

}
