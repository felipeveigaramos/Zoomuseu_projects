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
 * Entity implementation class for Entity: InfraClasseBean
 * 
 */
@Entity
@Table(name = "infraClasse")
public class InfraClasseBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "infraClasse")
	private List<OrdemBean> ordens;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private SubClasseBean subClasse;

	public InfraClasseBean() {
		super();
		ordens = new ArrayList<OrdemBean>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<OrdemBean> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(List<OrdemBean> ordens) {
		this.ordens = ordens;
	}

	/**
	 * @return the subClasse
	 */
	public SubClasseBean getSubClasse() {
		return subClasse;
	}

	/**
	 * @param subClasse
	 *            the subClasse to set
	 */
	public void setSubClasse(SubClasseBean subClasse) {
		this.subClasse = subClasse;
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
		result = prime * result + ((ordens == null) ? 0 : ordens.hashCode());
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
		InfraClasseBean other = (InfraClasseBean) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ordens == null) {
			if (other.ordens != null)
				return false;
		} else if (!ordens.equals(other.ordens))
			return false;
		return true;
	}

}
