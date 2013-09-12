package br.edu.utfpr.cm.zoomuseu_data.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: classificacao
 * 
 */
@Entity
@Table(name = "classificacao")
public class ClassificacaoBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private FiloBean filo;
	@ManyToOne
	private SubFiloBean subFilo;
	@ManyToOne
	private ClasseBean classe;
	@ManyToOne
	private SubClasseBean subClasse;
	@ManyToOne
	private InfraClasseBean infraClasse;
	@ManyToOne
	private OrdemBean ordem;
	@ManyToOne
	private SubOrdemBean subOrdem;
	@ManyToOne
	private SuperFamiliaBean superFamilia;
	@ManyToOne
	private FamiliaBean familia;
	@ManyToOne
	private SubFamiliaBean subFamilia;
	@ManyToOne
	private TriboBean tribo;
	@ManyToOne
	private GeneroBean genero;
	@ManyToOne
	private SubGeneroBean subGenero;
	@ManyToOne
	private EspecieBean especie;
	@ManyToOne
	private SubEspecieBean subEspecie;
	@ManyToOne
	private VariedadeBean variedade;

	public String getUltimaClassificacao() {
		if (this.filo == null) {
			return null;
		} else if (this.subFilo == null) {
			return "Filo:" + filo.getNome();
		} else if (classe == null) {
			return "SubFilo:" + subFilo.getNome();
		} else if (subClasse == null) {
			return "Classe:" + classe.getNome();
		} else if (infraClasse == null) {
			return "SubClasse:" + subClasse.getNome();
		} else if (this.ordem == null) {
			return "InfraClasse:" + infraClasse.getNome();
		} else if (this.subOrdem == null) {
			return "Ordem:" + ordem.getNome();
		} else if (this.superFamilia == null) {
			return "SubOrdem:" + subOrdem.getNome();
		} else if (this.familia == null) {
			return "SuperFamilia:" + superFamilia.getNome();
		} else if (this.subFamilia == null) {
			return "Familia:" + familia.getNome();
		} else if (this.tribo == null) {
			return "SubFamilia:" + subFamilia.getNome();
		} else if (this.genero == null) {
			return "Tribo:" + tribo.getNome();
		} else if (this.subGenero == null) {
			return "Genero:" + genero.getNome();
		} else if (this.especie == null) {
			return "SubGenero:" + subGenero.getNome();
		} else if (this.subEspecie == null) {
			return "Especie:" + especie.getNome();
		} else if (this.variedade == null) {
			return "SubEspecie:" + subEspecie.getNome();
		}
		return "Variedade:" + variedade.getNome();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the filo
	 */
	public FiloBean getFilo() {
		return filo;
	}

	/**
	 * @param filo
	 *            the filo to set
	 */
	public void setFilo(FiloBean filo) {
		this.filo = filo;
	}

	/**
	 * @return the subFilo
	 */
	public SubFiloBean getSubFilo() {
		return subFilo;
	}

	/**
	 * @param subFilo
	 *            the subFilo to set
	 */
	public void setSubFilo(SubFiloBean subFilo) {
		this.subFilo = subFilo;
	}

	/**
	 * @return the classe
	 */
	public ClasseBean getClasse() {
		return classe;
	}

	/**
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(ClasseBean classe) {
		this.classe = classe;
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

	/**
	 * @return the ordem
	 */
	public OrdemBean getOrdem() {
		return ordem;
	}

	/**
	 * @param ordem
	 *            the ordem to set
	 */
	public void setOrdem(OrdemBean ordem) {
		this.ordem = ordem;
	}

	/**
	 * @return the subOrdem
	 */
	public SubOrdemBean getSubOrdem() {
		return subOrdem;
	}

	/**
	 * @param subOrdem
	 *            the subOrdem to set
	 */
	public void setSubOrdem(SubOrdemBean subOrdem) {
		this.subOrdem = subOrdem;
	}

	/**
	 * @return the superFamilia
	 */
	public SuperFamiliaBean getSuperFamilia() {
		return superFamilia;
	}

	/**
	 * @param superFamilia
	 *            the superFamilia to set
	 */
	public void setSuperFamilia(SuperFamiliaBean superFamilia) {
		this.superFamilia = superFamilia;
	}

	/**
	 * @return the familia
	 */
	public FamiliaBean getFamilia() {
		return familia;
	}

	/**
	 * @param familia
	 *            the familia to set
	 */
	public void setFamilia(FamiliaBean familia) {
		this.familia = familia;
	}

	/**
	 * @return the subFamilia
	 */
	public SubFamiliaBean getSubFamilia() {
		return subFamilia;
	}

	/**
	 * @param subFamilia
	 *            the subFamilia to set
	 */
	public void setSubFamilia(SubFamiliaBean subFamilia) {
		this.subFamilia = subFamilia;
	}

	/**
	 * @return the tribo
	 */
	public TriboBean getTribo() {
		return tribo;
	}

	/**
	 * @param tribo
	 *            the tribo to set
	 */
	public void setTribo(TriboBean tribo) {
		this.tribo = tribo;
	}

	/**
	 * @return the genero
	 */
	public GeneroBean getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(GeneroBean genero) {
		this.genero = genero;
	}

	/**
	 * @return the subGenero
	 */
	public SubGeneroBean getSubGenero() {
		return subGenero;
	}

	/**
	 * @param subGenero
	 *            the subGenero to set
	 */
	public void setSubGenero(SubGeneroBean subGenero) {
		this.subGenero = subGenero;
	}

	/**
	 * @return the especie
	 */
	public EspecieBean getEspecie() {
		return especie;
	}

	/**
	 * @param especie
	 *            the especie to set
	 */
	public void setEspecie(EspecieBean especie) {
		this.especie = especie;
	}

	/**
	 * @return the subEspecie
	 */
	public SubEspecieBean getSubEspecie() {
		return subEspecie;
	}

	/**
	 * @param subEspecie
	 *            the subEspecie to set
	 */
	public void setSubEspecie(SubEspecieBean subEspecie) {
		this.subEspecie = subEspecie;
	}

	/**
	 * @return the variedade
	 */
	public VariedadeBean getVariedade() {
		return variedade;
	}

	/**
	 * @param variedade
	 *            the variedade to set
	 */
	public void setVariedade(VariedadeBean variedade) {
		this.variedade = variedade;
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
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((filo == null) ? 0 : filo.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((infraClasse == null) ? 0 : infraClasse.hashCode());
		result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
		result = prime * result
				+ ((subClasse == null) ? 0 : subClasse.hashCode());
		result = prime * result
				+ ((subEspecie == null) ? 0 : subEspecie.hashCode());
		result = prime * result
				+ ((subFamilia == null) ? 0 : subFamilia.hashCode());
		result = prime * result + ((subFilo == null) ? 0 : subFilo.hashCode());
		result = prime * result
				+ ((subGenero == null) ? 0 : subGenero.hashCode());
		result = prime * result
				+ ((subOrdem == null) ? 0 : subOrdem.hashCode());
		result = prime * result
				+ ((superFamilia == null) ? 0 : superFamilia.hashCode());
		result = prime * result + ((tribo == null) ? 0 : tribo.hashCode());
		result = prime * result
				+ ((variedade == null) ? 0 : variedade.hashCode());
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
		ClassificacaoBean other = (ClassificacaoBean) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (filo == null) {
			if (other.filo != null)
				return false;
		} else if (!filo.equals(other.filo))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (infraClasse == null) {
			if (other.infraClasse != null)
				return false;
		} else if (!infraClasse.equals(other.infraClasse))
			return false;
		if (ordem == null) {
			if (other.ordem != null)
				return false;
		} else if (!ordem.equals(other.ordem))
			return false;
		if (subClasse == null) {
			if (other.subClasse != null)
				return false;
		} else if (!subClasse.equals(other.subClasse))
			return false;
		if (subEspecie == null) {
			if (other.subEspecie != null)
				return false;
		} else if (!subEspecie.equals(other.subEspecie))
			return false;
		if (subFamilia == null) {
			if (other.subFamilia != null)
				return false;
		} else if (!subFamilia.equals(other.subFamilia))
			return false;
		if (subFilo == null) {
			if (other.subFilo != null)
				return false;
		} else if (!subFilo.equals(other.subFilo))
			return false;
		if (subGenero == null) {
			if (other.subGenero != null)
				return false;
		} else if (!subGenero.equals(other.subGenero))
			return false;
		if (subOrdem == null) {
			if (other.subOrdem != null)
				return false;
		} else if (!subOrdem.equals(other.subOrdem))
			return false;
		if (superFamilia == null) {
			if (other.superFamilia != null)
				return false;
		} else if (!superFamilia.equals(other.superFamilia))
			return false;
		if (tribo == null) {
			if (other.tribo != null)
				return false;
		} else if (!tribo.equals(other.tribo))
			return false;
		if (variedade == null) {
			if (other.variedade != null)
				return false;
		} else if (!variedade.equals(other.variedade))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassificacaoBean [id=" + id + ", filo=" + filo + ", subFilo="
				+ subFilo + ", classe=" + classe + ", subClasse=" + subClasse
				+ ", infraClasse=" + infraClasse + ", ordem=" + ordem
				+ ", subOrdem=" + subOrdem + ", superFamilia=" + superFamilia
				+ ", familia=" + familia + ", subFamilia=" + subFamilia
				+ ", tribo=" + tribo + ", genero=" + genero + ", subGenero="
				+ subGenero + ", especie=" + especie + ", subEspecie="
				+ subEspecie + ", variedade=" + variedade + "]";
	}

	public boolean eValida() {
		if (this.filo != null && this.subFilo != null && this.classe != null
				&& this.subClasse != null && this.infraClasse != null
				&& this.ordem != null) {
			return true;
		}
		return false;
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
