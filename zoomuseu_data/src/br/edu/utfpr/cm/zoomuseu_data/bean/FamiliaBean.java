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
 * Entity implementation class for Entity: familia
 * 
 */
@Entity
@Table(name = "familia")
public class FamiliaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "familia")
	private List<SubFamiliaBean> subFamilias;
	@ManyToOne
	private SuperFamiliaBean superFamilia;

	public FamiliaBean() {
		super();
		subFamilias = new ArrayList<SubFamiliaBean>();
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

	public List<SubFamiliaBean> getSubFamilias() {
		return subFamilias;
	}

	public void setSubFamilias(List<SubFamiliaBean> subFamilias) {
		this.subFamilias = subFamilias;
	}

	public SuperFamiliaBean getSuperFamilia() {
		return superFamilia;
	}

	public void setSuperFamilia(SuperFamiliaBean superFamilia) {
		this.superFamilia = superFamilia;
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
				+ ((superFamilia == null) ? 0 : superFamilia.hashCode());
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
		FamiliaBean other = (FamiliaBean) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (superFamilia == null) {
			if (other.superFamilia != null)
				return false;
		} else if (!superFamilia.equals(other.superFamilia))
			return false;
		return true;
	}

}
