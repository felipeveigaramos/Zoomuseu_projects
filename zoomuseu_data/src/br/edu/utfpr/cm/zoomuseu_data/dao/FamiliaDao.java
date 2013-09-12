package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;

public class FamiliaDao extends GenericDao<FamiliaBean> {

	public FamiliaDao() {
		super(FamiliaBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<FamiliaBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select fb from FamiliaBean fb where fb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<FamiliaBean>) q.list();
	}

}
