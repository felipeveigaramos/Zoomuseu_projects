package br.edu.utfpr.cm.zoomuseu_data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: especime
 * 
 */
@Entity
@Table(name = "especime")
public class EspecimeBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String coletor;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataColeta;
	@Column(length = 50, nullable = false)
	private String habitat;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ImagemBean> imagens;

	@Column(length = 50)
	private String nomesPopulares;
	@Column(length = 50)
	private String estagioDesenvolvimento;

	@Column(columnDefinition = "TEXT", length = 420)
	private String outros;
	@ManyToOne
	private LocalizacaoBean localizacao;
	@ManyToOne
	private ClassificacaoBean classificacao;
	private static final long serialVersionUID = 1L;

	public EspecimeBean() {
		super();
		localizacao = new LocalizacaoBean();
		classificacao = new ClassificacaoBean();
		imagens = new ArrayList<ImagemBean>(10);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColetor() {
		return this.coletor;
	}

	public void setColetor(String coletor) {
		this.coletor = coletor;
	}

	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getEstagioDesenvolvimento() {
		return this.estagioDesenvolvimento;
	}

	public void setEstagioDesenvolvimento(String estagioDesenvolvimento) {
		this.estagioDesenvolvimento = estagioDesenvolvimento;
	}

	public String getOutros() {
		return this.outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public LocalizacaoBean getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoBean localizacao) {
		this.localizacao = localizacao;
	}

	public ClassificacaoBean getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoBean classificacao) {
		this.classificacao = classificacao;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

	/**
	 * @return the nomesPopulares
	 */
	public String getNomesPopulares() {
		return nomesPopulares;
	}

	/**
	 * @param nomesPopulares
	 *            the nomesPopulares to set
	 */
	public void setNomesPopulares(String nomesPopulares) {
		this.nomesPopulares = nomesPopulares;
	}

	/**
	 * @return the imagens
	 */
	public List<ImagemBean> getImagens() {
		return imagens;
	}

	/**
	 * @param imagens
	 *            the imagens to set
	 */
	public void setImagens(List<ImagemBean> imagens) {
		this.imagens = imagens;
	}

}
