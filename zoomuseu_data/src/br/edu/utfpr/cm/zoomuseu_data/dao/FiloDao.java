package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;

public class FiloDao extends GenericDao<FiloBean> {

	public FiloDao() {
		super(FiloBean.class);
	}

	@SuppressWarnings("unchecked")
	public List<FiloBean> pesquisar(String nome, boolean identico)
			throws ClassCastException {
		Query q = session
				.createQuery("select fb from FiloBean fb where fb.nome "
						+ (identico ? "=" : "like") + " :name");
		q.setParameter("name", (identico ? "" : "%") + nome
				+ (identico ? "" : "%"));
		return (List<FiloBean>) q.list();
	}

}
