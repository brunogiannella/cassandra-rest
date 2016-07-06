package br.com.gft.digital.bigdata.pocbigdata.model;

import java.math.BigDecimal;
import java.util.Date;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "pocBigData", name = "apolice",
caseSensitiveKeyspace = false,
caseSensitiveTable = false)
public class Apolice {

	public Apolice() {};
	
	public Apolice(Long idApolice) {
		super();
		this.idApolice = idApolice;
	}

	@PartitionKey
	@Column(name = "id_apolice")
	private Long idApolice;
	
	@Column(name = "cpf_cnpj_cliente")
	private Long cpfCnpjCliente;
	
	@Column(name = "cod_contrato")
	private Long codContrato;
	
	@Column(name = "fabricante")
	private String fabricante;
	
	@Column(name = "cod_classe_veiculo")
	private Integer codClasseVeiculo;
	
	@Column(name = "dsc_classe_veiculo")
	private String dscClasseVeiculo;
	
	@Column(name = "modelo_veiculo")
	private String modeloVeiculo;
	
	@Column(name = "cor_veiculo")
	private String corVeiculo;
	
	@Column(name = "ano_veiculo")
	private Integer anoVeiculo;
	
	@Column(name = "placa_veiculo")
	private String placaVeiculo;
	
	@Column(name = "chassi_veiculo")
	private String chassiVeiculo;
	
	@Column(name = "dt_inicio_vigencia")
	private Date dtInicioVigencia;
	
	@Column(name = "dt_fim_vigencia")
	private Date dtFimVigencia;
	
	@Column(name = "fl_veiculo_novo")
	private Boolean flVeiculoNovo;
	
	@Column(name = "fl_veiculo_garantia")
	private Boolean flVeiculoGarantia;
	
	@Column(name = "tempo_garantia")
	private Integer tempoGarantia;
	
	@Column(name = "dsc_plano_contratado")
	private String dscPlanoContratado;
	
	@Column(name = "val_franquia_casco")
	private BigDecimal valFranquiaCasco;
	
	@Column(name = "val_franquia_vidro")
	private BigDecimal valFranquiaVidro;
	
	@Column(name = "val_franquia_lant")
	private BigDecimal valFranquiaLant;
	
	@Column(name = "val_franquia_farol")
	private BigDecimal valFranquiaFarol;
	
	@Column(name = "val_franquia_retrov")
	private BigDecimal valFranquiaRetrov;
	
	@Column(name = "fl_tipo_frota")
	private Boolean flTipoFrota;
	
	@Column(name = "flg_renovacao")
	private Boolean flgRenovacao;
	
	@Column(name = "val_franquia_vd_diant")
	private BigDecimal valFranquiaVdDiant;
	
	@Column(name = "val_franquia_vd_tras")
	private BigDecimal valFranquiaVdTras;
    
	@Column(name = "val_Franquia_vd_lat")
	private BigDecimal valFranquiaVdLat;
    
	@Column(name = "val_franquia_vd_teto")
	private BigDecimal valFranquiaVdTeto;
    
	@Column(name = "val_franquia_lant_led")
	private BigDecimal valFranquiaLantLed;
    
	@Column(name = "val_franquia_farol_led")
	private BigDecimal valFranquiaFarolLed;
    
	@Column(name = "val_franquia_farol_aux")
	private BigDecimal valFranquiaFarolAux;
    
	@Column(name = "val_franquia_farol_auxLed")
	private BigDecimal valFranquiaFarolAuxLed;
    
	@Column(name = "val_franquia_parachoq")
	private BigDecimal valFranquiaParachoq;
    
	@Column(name = "flg_apol_pend_pagto")
	private Boolean flgApolPendPagto;

	public Long getIdApolice() {
		return idApolice;
	}

	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}

	public Long getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(Long cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public Long getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(Long codContrato) {
		this.codContrato = codContrato;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getCodClasseVeiculo() {
		return codClasseVeiculo;
	}

	public void setCodClasseVeiculo(Integer codClasseVeiculo) {
		this.codClasseVeiculo = codClasseVeiculo;
	}

	public String getDscClasseVeiculo() {
		return dscClasseVeiculo;
	}

	public void setDscClasseVeiculo(String dscClasseVeiculo) {
		this.dscClasseVeiculo = dscClasseVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public Integer getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(Integer anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getChassiVeiculo() {
		return chassiVeiculo;
	}

	public void setChassiVeiculo(String chassiVeiculo) {
		this.chassiVeiculo = chassiVeiculo;
	}

	public Date getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(Date dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public Date getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(Date dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public Boolean getFlVeiculoNovo() {
		return flVeiculoNovo;
	}

	public void setFlVeiculoNovo(Boolean flVeiculoNovo) {
		this.flVeiculoNovo = flVeiculoNovo;
	}

	public Boolean getFlVeiculoGarantia() {
		return flVeiculoGarantia;
	}

	public void setFlVeiculoGarantia(Boolean flVeiculoGarantia) {
		this.flVeiculoGarantia = flVeiculoGarantia;
	}

	public Integer getTempoGarantia() {
		return tempoGarantia;
	}

	public void setTempoGarantia(Integer tempoGarantia) {
		this.tempoGarantia = tempoGarantia;
	}

	public String getDscPlanoContratado() {
		return dscPlanoContratado;
	}

	public void setDscPlanoContratado(String dscPlanoContratado) {
		this.dscPlanoContratado = dscPlanoContratado;
	}

	public BigDecimal getValFranquiaCasco() {
		return valFranquiaCasco;
	}

	public void setValFranquiaCasco(BigDecimal valFranquiaCasco) {
		this.valFranquiaCasco = valFranquiaCasco;
	}

	public BigDecimal getValFranquiaVidro() {
		return valFranquiaVidro;
	}

	public void setValFranquiaVidro(BigDecimal valFranquiaVidro) {
		this.valFranquiaVidro = valFranquiaVidro;
	}

	public BigDecimal getValFranquiaLant() {
		return valFranquiaLant;
	}

	public void setValFranquiaLant(BigDecimal valFranquiaLant) {
		this.valFranquiaLant = valFranquiaLant;
	}

	public BigDecimal getValFranquiaFarol() {
		return valFranquiaFarol;
	}

	public void setValFranquiaFarol(BigDecimal valFranquiaFarol) {
		this.valFranquiaFarol = valFranquiaFarol;
	}

	public BigDecimal getValFranquiaRetrov() {
		return valFranquiaRetrov;
	}

	public void setValFranquiaRetrov(BigDecimal valFranquiaRetrov) {
		this.valFranquiaRetrov = valFranquiaRetrov;
	}

	public Boolean getFlTipoFrota() {
		return flTipoFrota;
	}

	public void setFlTipoFrota(Boolean flTipoFrota) {
		this.flTipoFrota = flTipoFrota;
	}

	public Boolean getFlgRenovacao() {
		return flgRenovacao;
	}

	public void setFlgRenovacao(Boolean flgRenovacao) {
		this.flgRenovacao = flgRenovacao;
	}

	public BigDecimal getValFranquiaVdDiant() {
		return valFranquiaVdDiant;
	}

	public void setValFranquiaVdDiant(BigDecimal valFranquiaVdDiant) {
		this.valFranquiaVdDiant = valFranquiaVdDiant;
	}

	public BigDecimal getValFranquiaVdTras() {
		return valFranquiaVdTras;
	}

	public void setValFranquiaVdTras(BigDecimal valFranquiaVdTras) {
		this.valFranquiaVdTras = valFranquiaVdTras;
	}

	public BigDecimal getValFranquiaVdLat() {
		return valFranquiaVdLat;
	}

	public void setValFranquiaVdLat(BigDecimal valFranquiaVdLat) {
		this.valFranquiaVdLat = valFranquiaVdLat;
	}

	public BigDecimal getValFranquiaVdTeto() {
		return valFranquiaVdTeto;
	}

	public void setValFranquiaVdTeto(BigDecimal valFranquiaVdTeto) {
		this.valFranquiaVdTeto = valFranquiaVdTeto;
	}

	public BigDecimal getValFranquiaLantLed() {
		return valFranquiaLantLed;
	}

	public void setValFranquiaLantLed(BigDecimal valFranquiaLantLed) {
		this.valFranquiaLantLed = valFranquiaLantLed;
	}

	public BigDecimal getValFranquiaFarolLed() {
		return valFranquiaFarolLed;
	}

	public void setValFranquiaFarolLed(BigDecimal valFranquiaFarolLed) {
		this.valFranquiaFarolLed = valFranquiaFarolLed;
	}

	public BigDecimal getValFranquiaFarolAux() {
		return valFranquiaFarolAux;
	}

	public void setValFranquiaFarolAux(BigDecimal valFranquiaFarolAux) {
		this.valFranquiaFarolAux = valFranquiaFarolAux;
	}

	public BigDecimal getValFranquiaFarolAuxLed() {
		return valFranquiaFarolAuxLed;
	}

	public void setValFranquiaFarolAuxLed(BigDecimal valFranquiaFarolAuxLed) {
		this.valFranquiaFarolAuxLed = valFranquiaFarolAuxLed;
	}

	public BigDecimal getValFranquiaParachoq() {
		return valFranquiaParachoq;
	}

	public void setValFranquiaParachoq(BigDecimal valFranquiaParachoq) {
		this.valFranquiaParachoq = valFranquiaParachoq;
	}

	public Boolean getFlgApolPendPagto() {
		return flgApolPendPagto;
	}

	public void setFlgApolPendPagto(Boolean flgApolPendPagto) {
		this.flgApolPendPagto = flgApolPendPagto;
	}
	
}
