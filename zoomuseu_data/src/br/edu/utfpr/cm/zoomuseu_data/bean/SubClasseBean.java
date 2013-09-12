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
 * Entity implementation class for Entity: subClasse
 * 
 */
@Entity
@Table(name = "subClasse")
public class SubClasseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne
	private ClasseBean classe;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subClasse")
	private List<InfraClasseBean> infraClasses;

	public SubClasseBean() {
		super();
		infraClasses = new ArrayList<InfraClasseBean>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClasseBean getClasse() {
		return classe;
	}

	public void setClasse(ClasseBean classe) {
		this.classe = classe;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
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
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		SubClasseBean other = (SubClasseBean) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * @return the infraClasses
	 */
	public List<InfraClasseBean> getInfraClasses() {
		return infraClasses;
	}

	/**
	 * @param infraClasses
	 *            the infraClasses to set
	 */
	public void setInfraClasses(List<InfraClasseBean> infraClasses) {
		this.infraClasses = infraClasses;
	}

}
