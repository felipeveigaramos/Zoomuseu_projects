package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;

public class ClasseDao extends GenericDao<ClasseBean> {

	public ClasseDao() {
		super(ClasseBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<ClasseBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select cb from ClasseBean cb where cb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<ClasseBean>) q.list();

	}

}
