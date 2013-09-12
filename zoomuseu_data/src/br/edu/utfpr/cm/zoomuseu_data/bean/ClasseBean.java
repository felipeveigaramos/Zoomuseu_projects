package br.edu.utfpr.cm.zoomuseu_data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: classe
 * 
 */
@Entity
@Table(name = "classe")
public class ClasseBean implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private long id;

        @ManyToOne
        private SubFiloBean subFilo;

        @Column(length = 50, nullable = false)
        private String nome;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "classe")
        private List<SubClasseBean> subClasses;

        public ClasseBean() {
                super();
                subClasses = new ArrayList<SubClasseBean>();
        }

        public long getId() {
                return this.id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public SubFiloBean getSubFilo() {
                return subFilo;
        }

        public void setSubFilo(SubFiloBean subFilo) {
                this.subFilo = subFilo;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public List<SubClasseBean> getSubClasses() {
                return subClasses;
        }

        public void setSubClasses(List<SubClasseBean> subClasses) {
                this.subClasses = subClasses;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
                return nome;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + (int) (id ^ (id >>> 32));
                result = prime * result + ((nome == null) ? 0 : nome.hashCode());
                result = prime * result
                                + ((subClasses == null) ? 0 : subClasses.hashCode());
                result = prime * result + ((subFilo == null) ? 0 : subFilo.hashCode());
                return result;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                ClasseBean other = (ClasseBean) obj;
                if (id != other.id)
                        return false;
                if (nome == null) {
                        if (other.nome != null)
                                return false;
                } else if (!nome.equals(other.nome))
                        return false;
                if (subClasses == null) {
                        if (other.subClasses != null)
                                return false;
                } else if (!subClasses.equals(other.subClasses))
                        return false;
                if (subFilo == null) {
                        if (other.subFilo != null)
                                return false;
                } else if (!subFilo.equals(other.subFilo))
                        return false;
                return true;
        }

}
