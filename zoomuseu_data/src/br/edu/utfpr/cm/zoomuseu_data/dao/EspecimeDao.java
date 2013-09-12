package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;

public class EspecimeDao extends GenericDao<EspecimeBean> {
        public EspecimeDao() {
                super(EspecimeBean.class);
        }

        @SuppressWarnings("unchecked")
        public List<EspecimeBean> pesquisar(String nomesPopulares, boolean identico) {
                Query q = session
                                .createQuery("select eb from EspecimeBean eb where eb.nomesPopulares "
                                                + (identico ? "=" : "like") + " :popularNames");
                q.setParameter("popularNames", (identico ? "" : "%") + nomesPopulares
                                + (identico ? "" : "%"));
                return (List<EspecimeBean>) q.list();
        }

        @SuppressWarnings("unchecked")
        public List<EspecimeBean> pesquisarEspecie(String nomeEspecie, boolean identico) {
                Query q = session
.createQuery("select eb from EspecimeBean eb where eb.classificacao.especie "
+ (identico ? "=" : "like") + " :nomeEspecie");
                q.setParameter("nomeEspecie", (identico ? "" : "%") +
nomeEspecie                                 + (identico ? "" : "%"));
                return (List<EspecimeBean>) q.list();
        }


}
