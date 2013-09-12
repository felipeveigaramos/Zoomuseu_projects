package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;


import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenericDao<T> {

	private Class<T> cl;

	protected static AnnotationConfiguration config = new AnnotationConfiguration();
	protected static SessionFactory sessionFactory;
	protected static Session session;

	static {
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.ClassificacaoBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.ImagemBean.class);
		config.addAnnotatedClass(br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean.class);
		config.configure();

		sessionFactory = config.buildSessionFactory();

		session = sessionFactory.openSession();

		session.setFlushMode(FlushMode.ALWAYS);
	}

	public static void prepararBanco() {
		SchemaExport export = new SchemaExport(GenericDao.config);
		export.drop(false, true);
		export.create(false, true);
	}

	/**
	 * @param cl
	 */
	public GenericDao(Class<T> cl) {
		this.cl = cl;
	}

	public Class<T> getType() {
		return this.cl;
	}

	public T persistir(T e) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(e);
			transaction.commit();
			session.refresh(e);
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		}
		return e;
	}

	public void remover(T e) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(e);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public T pesquisar(Long id) {
		return (T) session.get(cl, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		return session.createCriteria(cl).list();
	}

	public T refresh(T b) {
		session.refresh(b);

		return b;
	}

	@Override
	protected void finalize() throws Throwable {
		session.flush();
		session.close();
	}

}
