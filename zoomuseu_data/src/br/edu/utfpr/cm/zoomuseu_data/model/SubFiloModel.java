package br.edu.utfpr.cm.zoomuseu_data.model;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.dao.SubFiloDao;

public class SubFiloModel implements InterfaceSubFiloModel {
        private SubFiloDao sfd;
        private InterfaceFiloModel ifm;

        public SubFiloModel() {
                sfd = new SubFiloDao();
                ifm = ModelFactory.getInstance().getInterfaceFiloModel();
        }

        @Override
        public long inserir(SubFiloBean sfb) {
                SubFiloBean subFiloInserido = sfd.persistir(sfb);
                ifm.refresh(subFiloInserido.getFilo());
                return subFiloInserido.getId() >= 0 ? subFiloInserido.getId() : -1;
        }

        @Override
        public void remover(long id) {
                SubFiloBean sfb = sfd.pesquisar(id);
                FiloBean fb = sfb.getFilo();
                fb.getSubFilos().remove(sfb);
                sfd.remover(sfb);
                ifm.refresh(fb);
        }

        @Override
        public void atualizar(SubFiloBean sfb) {
                SubFiloBean sfba = sfd.pesquisar(sfb.getId());
                FiloBean fba = sfba.getFilo();
                FiloBean fb = sfb.getFilo();

                if (fba.equals(fb)) {
                        sfd.persistir(sfb);
                        fba.getSubFilos().set(fba.getSubFilos().indexOf(sfba), sfb);
                        ifm.refresh(fba);
                } else {
                        remover(sfba.getId());
                        inserir(sfb);
                }
        }

        @Override
        public SubFiloBean pesquisar(long id) {
                return sfd.pesquisar(id);
        }

        @Override
        public List<SubFiloBean> listar() {
                return sfd.listar();
        }

        @Override
        public List<SubFiloBean> pesquisar(String nome, boolean identico)
                        throws ClassCastException {
                return sfd.pesquisar(nome, identico);
        }

        @Override
        public void refresh(SubFiloBean sfb) {
                sfd.refresh(sfb);

        }

}
