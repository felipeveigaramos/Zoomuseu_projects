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
 * Entity implementation class for Entity: OrdemBean
 * 
 */
@Entity
@Table(name = "ordem")
public class OrdemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne
	private InfraClasseBean infraClasse;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ordem")
	private List<SubOrdemBean> subOrdens;

	public OrdemBean() {
		super();
		subOrdens = new ArrayList<SubOrdemBean>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SubOrdemBean> getSubOrdens() {
		return subOrdens;
	}

	public void setSubOrdens(List<SubOrdemBean> subOrdens) {
		this.subOrdens = subOrdens;
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
		result = prime * result
				+ ((infraClasse == null) ? 0 : infraClasse.hashCode());
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
		OrdemBean other = (OrdemBean) obj;
		if (id != other.id)
			return false;
		if (infraClasse == null) {
			if (other.infraClasse != null)
				return false;
		} else if (!infraClasse.equals(other.infraClasse))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * @return the infraClasse
	 */
	public InfraClasseBean getInfraClasse() {
		return infraClasse;
	}

	/**
	 * @param infraClasse
	 *            the infraClasse to set
	 */
	public void setInfraClasse(InfraClasseBean infraClasse) {
		this.infraClasse = infraClasse;
	}

}
