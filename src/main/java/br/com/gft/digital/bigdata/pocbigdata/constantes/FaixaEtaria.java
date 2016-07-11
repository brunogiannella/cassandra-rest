package br.com.gft.digital.bigdata.pocbigdata.constantes;

public enum FaixaEtaria {
	
	ENTRE_18_E_25_ANOS("18-25"),
	ENTRE_25_E_30_ANOS("25-30"),
	ENTRE_30_E_40_ANOS("30-40"),
	ENTRE_40_E_50_ANOS("40-50"),
	ENTRE_50_E_60_ANOS("50-60"),
	MAIS_DE_60_ANOS(">60");

	public String descricao;
	
	FaixaEtaria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
