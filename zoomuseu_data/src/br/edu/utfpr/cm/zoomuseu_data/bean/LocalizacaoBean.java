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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: localizacao
 * 
 */
@Entity
@Table(name = "localizacao")
public class LocalizacaoBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(length = 50, nullable = false)
	private String municipio;

	@Column(columnDefinition = "CHAR", length = 2)
	private String estado;

	@Column(length = 50, nullable = false)
	private String pais;

	@Column(length = 50, nullable = false)
	private String formacaoVegetal;

	@Column(length = 50, nullable = false)
	private String bioma;

	@Column(length = 15, nullable = false)
	private String latitude;
	@Column(length = 15, nullable = false)
	private String longitude;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localizacao")
	private List<EspecimeBean> especimes;
	private static final long serialVersionUID = 1L;

	public LocalizacaoBean() {
		super();
		especimes = new ArrayList<EspecimeBean>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFormacaoVegetal() {
		return this.formacaoVegetal;
	}

	public void setFormacaoVegetal(String formacaoVegetal) {
		this.formacaoVegetal = formacaoVegetal;
	}

	public String getBioma() {
		return this.bioma;
	}

	public void setBioma(String bioma) {
		this.bioma = bioma;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<EspecimeBean> getEspecimes() {
		return especimes;
	}

	public void setEspecimes(List<EspecimeBean> especimes) {
		this.especimes = especimes;
	}

}
