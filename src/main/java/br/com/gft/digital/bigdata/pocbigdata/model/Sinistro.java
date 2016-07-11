package br.com.gft.digital.bigdata.pocbigdata.model;

import java.math.BigDecimal;
import java.util.List;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "pocBigData", name = "sinistro", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class Sinistro {

	public Sinistro() {
	};

	@PartitionKey
	@Column(name = "id_sinistro")
	private Long idSinistro;

	@Column(name = "id_apolice")
	private Long idApolice;

	@Column(name = "tipo_sinistro")
	private String tipoSinistro;

	@Column(name = "telContato")
	private String telContato;

	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "bairro")
	private String bairro;

	@Column(name = "ponto_referencia")
	private String ponto_referencia;

	@Column(name = "lat")
	private BigDecimal lat;

	@Column(name = "lon")
	private BigDecimal lon;

	@Column(name = "causas")
	private List<String> causas;

	@Column(name = "fl_veiculo_garagem")
	private Boolean flVeiculo_garagem;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "fl_cliente_condutor")
	private Boolean flClienteCondutor;

	public Long getIdSinistro() {
		return idSinistro;
	}

	public void setIdSinistro(Long idSinistro) {
		this.idSinistro = idSinistro;
	}

	public Long getIdApolice() {
		return idApolice;
	}

	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}

	public String getTipoSinistro() {
		return tipoSinistro;
	}

	public void setTipoSinistro(String tipoSinistro) {
		this.tipoSinistro = tipoSinistro;
	}

	public String getTelContato() {
		return telContato;
	}

	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPonto_referencia() {
		return ponto_referencia;
	}

	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public List<String> getCausas() {
		return causas;
	}

	public void setCausas(List<String> causas) {
		this.causas = causas;
	}

	public Boolean getFlVeiculo_garagem() {
		return flVeiculo_garagem;
	}

	public void setFlVeiculo_garagem(Boolean flVeiculo_garagem) {
		this.flVeiculo_garagem = flVeiculo_garagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFlClienteCondutor() {
		return flClienteCondutor;
	}

	public void setFlClienteCondutor(Boolean flClienteCondutor) {
		this.flClienteCondutor = flClienteCondutor;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}
