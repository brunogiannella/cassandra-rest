package br.com.gft.digital.bigdata.pocbigdata.model;

import java.util.Map;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "pocBigData", name = "indicador_string", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class IndicadorString {

	public IndicadorString() {
	};

	@PartitionKey
	@Column(name = "tipo_indicador")
	private String tipoIndicador;
	
	@Column(name = "ultimo_indexado")
	private Long ultimoIndexado;
	
	@Column(name = "dados")
	private Map<String, Long> dados;

	public String getTipoIndicador() {
		return tipoIndicador;
	}

	public void setTipoIndicador(String tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public Long getUltimoIndexado() {
		return ultimoIndexado;
	}

	public void setUltimoIndexado(Long ultimoIndexado) {
		this.ultimoIndexado = ultimoIndexado;
	}

	public Map<String, Long> getDados() {
		return dados;
	}

	public void setDados(Map<String, Long> dados) {
		this.dados = dados;
	}

}
