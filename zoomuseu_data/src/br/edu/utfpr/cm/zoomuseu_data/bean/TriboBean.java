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
 * Entity implementation class for Entity: tribo
 * 
 */
@Entity
@Table(name = "tribo")
public class TriboBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne
	private SubFamiliaBean subFamilia;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tribo")
	private List<GeneroBean> generos;

	public TriboBean() {
		super();
		generos = new ArrayList<GeneroBean>();
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

	public SubFamiliaBean getSubFamilia() {
		return subFamilia;
	}

	public void setSubFamilia(SubFamiliaBean subFamilia) {
		this.subFamilia = subFamilia;
	}

	public List<GeneroBean> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroBean> generos) {
		this.generos = generos;
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
				+ ((subFamilia == null) ? 0 : subFamilia.hashCode());
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
		TriboBean other = (TriboBean) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (subFamilia == null) {
			if (other.subFamilia != null)
				return false;
		} else if (!subFamilia.equals(other.subFamilia))
			return false;
		return true;
	}

}
