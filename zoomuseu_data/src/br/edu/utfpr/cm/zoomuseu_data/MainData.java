package br.edu.utfpr.cm.zoomuseu_data;

import br.edu.utfpr.cm.zoomuseu_data.dao.GenericDao;

public class MainData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * AnnotationConfiguration annotationConfiguration = new
		 * AnnotationConfiguration() .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.ClassificacaoBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.ImagemBean.class)
		 * .addAnnotatedClass(
		 * br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean.class);
		 * 
		 * annotationConfiguration.configure();
		 * 
		 * new SchemaExport(annotationConfiguration).create(false, true);
		 * 
		 * SessionFactory sessionFactory = annotationConfiguration
		 * .buildSessionFactory();
		 * 
		 * Session session = sessionFactory.openSession();
		 * 
		 * FiloBean fb = new FiloBean(); org.hibernate.Transaction transaction =
		 * session.beginTransaction(); fb.setNome("filoteste");
		 * session.persist(fb);
		 * 
		 * transaction.commit(); session.flush(); session.close();
		 */

		GenericDao.prepararBanco();



	}

}
