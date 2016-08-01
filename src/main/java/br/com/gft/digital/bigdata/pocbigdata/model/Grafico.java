package br.com.gft.digital.bigdata.pocbigdata.model;

import java.util.List;

public class Grafico {

	private String tituloGrafico;
	private String tipoGrafico;
	private List<ItemGrafico> itens;

	public String getTituloGrafico() {
		return tituloGrafico;
	}

	public void setTituloGrafico(String tituloGrafico) {
		this.tituloGrafico = tituloGrafico;
	}

	public List<ItemGrafico> getItens() {
		return itens;
	}

	public void setItens(List<ItemGrafico> itens) {
		this.itens = itens;
	}

	public String getTipoGrafico() {
		return tipoGrafico;
	}

	public void setTipoGrafico(String tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

}
