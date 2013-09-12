package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;

public class InfraClasseDao extends GenericDao<InfraClasseBean> {
	public InfraClasseDao() {
		super(InfraClasseBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<InfraClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select icb from InfraClasseBean icb where icb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<InfraClasseBean>) q.list();
	}

}
