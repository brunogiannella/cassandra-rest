package br.com.gft.digital.bigdata.pocbigdata.constantes;

public enum TipoIndexador {
	
	MARCA_X_ROUBOS("marca_roubos"),
	MARCA_X_DEFEITOS("marca_defeitos"),
	FAIXAETATICA_X_SINISTROS("faixaetaria_sinistros"),
	REGIAO_X_SINISTROS("regiao_sinistros");

	public String descricao;
	
	TipoIndexador(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
