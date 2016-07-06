package br.com.gft.digital.bigdata.pocbigdata.model;

import java.math.BigDecimal;
import java.util.Date;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "pocBigData", name = "cliente",
		caseSensitiveKeyspace = false,
		caseSensitiveTable = false)
public class Cliente {

	public Cliente() {};
	
	public Cliente(Long cpfCnpj) {
		super();
		this.cpfCnpj = cpfCnpj;
	}

	@PartitionKey
	@Column(name = "cpf_cnpj")
	private Long cpfCnpj;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "tipo_pessoa")
	private String tipoPessoa;
	
	@Column(name = "dscLogra")
	private String dscLogra;
	
	@Column(name = "nmeBairro")
	private String nmeBairro;
	
	@Column(name = "nmeCidade")
	private String nmeCidade;
	
	@Column(name = "sigUF")
	private String sigUF;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "idade")
	private Integer idade;
	
	@Column(name = "dt_nascimento")
	private Date dtNascimento;
	
	@Column(name = "profissao")
	private String profissao;
	
	@Column(name = "renda_media")
	private BigDecimal rendaMedia;

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getDscLogra() {
		return dscLogra;
	}

	public void setDscLogra(String dscLogra) {
		this.dscLogra = dscLogra;
	}

	public String getNmeBairro() {
		return nmeBairro;
	}

	public void setNmeBairro(String nmeBairro) {
		this.nmeBairro = nmeBairro;
	}

	public String getNmeCidade() {
		return nmeCidade;
	}

	public void setNmeCidade(String nmeCidade) {
		this.nmeCidade = nmeCidade;
	}

	public String getSigUF() {
		return sigUF;
	}

	public void setSigUF(String sigUF) {
		this.sigUF = sigUF;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public BigDecimal getRendaMedia() {
		return rendaMedia;
	}

	public void setRendaMedia(BigDecimal rendaMedia) {
		this.rendaMedia = rendaMedia;
	}

}
