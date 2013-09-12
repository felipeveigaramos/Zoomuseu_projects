package br.edu.utfpr.cm.zoomuseu_data.dao;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.cm.zoomuseu_data.bean.LocalizacaoBean;

public class LocalizacaoDao extends GenericDao<LocalizacaoBean> {

        public LocalizacaoDao() {
                super(LocalizacaoBean.class);
        }

        @SuppressWarnings("unchecked")
        public List<LocalizacaoBean> pesquisarMunicipio(String municipio, boolean identico) {
                Query q = session.createQuery("select lb from LocalizacaoBean lb where lb.municipio " + (identico ? "=" : "like") + " :municipio");
                q.setParameter("municipio", (identico ? "" : "%") + municipio                                 + (identico ? "" : "%"));
                return (List<LocalizacaoBean>) q.list();
        }

}
