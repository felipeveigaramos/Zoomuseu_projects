package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;

public class SubOrdemDao extends GenericDao<SubOrdemBean> {

	public SubOrdemDao() {
		super(SubOrdemBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<SubOrdemBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select sob from SubOrdemBean sob where sob.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<SubOrdemBean>) q.list();
	}
}
