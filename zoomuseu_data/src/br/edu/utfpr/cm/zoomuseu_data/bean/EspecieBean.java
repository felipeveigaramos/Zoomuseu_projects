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
 * Entity implementation class for Entity: especie
 * 
 */
@Entity
@Table(name = "especie")
public class EspecieBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne
	private SubGeneroBean subGenero;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "especie")
	private List<SubEspecieBean> subEspecies;

	public EspecieBean() {
		super();
		subEspecies = new ArrayList<SubEspecieBean>();
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

	public SubGeneroBean getSubGenero() {
		return subGenero;
	}

	public void setSubGenero(SubGeneroBean subGenero) {
		this.subGenero = subGenero;
	}

	public List<SubEspecieBean> getSubEspecies() {
		return subEspecies;
	}

	public void setSubEspecies(List<SubEspecieBean> subEspecies) {
		this.subEspecies = subEspecies;
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
				+ ((subGenero == null) ? 0 : subGenero.hashCode());
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
		EspecieBean other = (EspecieBean) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (subGenero == null) {
			if (other.subGenero != null)
				return false;
		} else if (!subGenero.equals(other.subGenero))
			return false;
		return true;
	}

}
