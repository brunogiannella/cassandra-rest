package br.com.gft.digital.bigdata.pocbigdata.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.digital.bigdata.pocbigdata.constantes.TipoIndexador;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ApoliceRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ClienteRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.IndicadorStringRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.SinistroRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.model.Apolice;
import br.com.gft.digital.bigdata.pocbigdata.model.Cliente;
import br.com.gft.digital.bigdata.pocbigdata.model.Grafico;
import br.com.gft.digital.bigdata.pocbigdata.model.IndicadorString;
import br.com.gft.digital.bigdata.pocbigdata.model.ItemGrafico;
import br.com.gft.digital.bigdata.pocbigdata.model.RestObject;
import br.com.gft.digital.bigdata.pocbigdata.model.Sinistro;

@RestController
public class JobsCassandraController {

	@Autowired
	private IndicadorStringRepositoryImpl indicadoresRepository;
	
	@Autowired
	private ClienteRepositoryImpl clienteRepositoryImpl;
	
	@Autowired
	private ApoliceRepositoryImpl apoliceRepositoryImpl;
	
	@Autowired
	private SinistroRepositoryImpl sinistroRepositoryImpl;
		 
	@RequestMapping(value="/indicador", method = RequestMethod.GET)
	public RestObject consultaIndicadores() { 
		try {
			List<Grafico> graficos = new ArrayList<Grafico>();
			
			List<IndicadorString> indicadores = indicadoresRepository.get();
			
			for(IndicadorString indicador : indicadores) {
				
				Grafico grafico = new Grafico();
				grafico.setTipoGrafico(indicador.getTipoIndicador());
				
				if(TipoIndexador.MARCA_X_ROUBOS.getDescricao().equals(indicador.getTipoIndicador())) {
					grafico.setTituloGrafico("Roubos por marca");
				} else if(TipoIndexador.FAIXAETATICA_X_SINISTROS.getDescricao().equals(indicador.getTipoIndicador())) {
					grafico.setTituloGrafico("Utilização do seguro por faixa etaria");
				} else if(TipoIndexador.MARCA_X_DEFEITOS.getDescricao().equals(indicador.getTipoIndicador())) {
					grafico.setTituloGrafico("Defeitos por marca");
				} else if(TipoIndexador.REGIAO_X_SINISTROS.getDescricao().equals(indicador.getTipoIndicador())) {
					grafico.setTituloGrafico("Quantidade de sinistros por região");
				}
				
				if(indicador.getDados() != null) {
					List<ItemGrafico> itensGrafico = new ArrayList<ItemGrafico>();
					
					for (String key : indicador.getDados().keySet()) {
						ItemGrafico item = new ItemGrafico();
						item.setItem(key);
						item.setValor(indicador.getDados().get(key));
						
						itensGrafico.add(item);
					}
					
					grafico.setItens(itensGrafico);
				}
				
				graficos.add(grafico);
			}
			
			return new RestObject(200, true, "Consulta realizada com sucesso", graficos);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro na consulta: " + e.getMessage(), null);
		}
	}
	
	@RequestMapping(value="/indicador/{descricao}", method = RequestMethod.GET)
	public RestObject consultarCliente(@PathVariable String descricao) {
		try {
			IndicadorString indicador = indicadoresRepository.get(descricao);
			
			if(indicador == null) {
				return new RestObject(200, true, "Indicador não encontrado", indicador);
			}
			
			return new RestObject(200, true, "Consulta realizada com sucesso", indicador);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro na consulta: " + e.getMessage(), null);
		}
	}
	
	@RequestMapping(value="/indicador/gerarMassa", method = RequestMethod.GET)
	public RestObject gerarMassa() {
		try {
			gerarMassaCliente();
			gerarMassaApolice();
			gerarMassaSinisro();
			return new RestObject(200, false, "Massa gerada com sucesso.", null);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro na consulta: " + e.getMessage(), null);
		}
	}
	
	private void gerarMassaCliente() {
		for(int i = 0; i < 200; i++) {
			Cliente cliente = new Cliente(41766098851L + i);
			cliente.setNome("Cliente " + i);
			cliente.setDtNascimento(new Date());
			cliente.setIdade(18 + i);
			cliente.setProfissao("Analista de sistemas");
			cliente.setEmail("cliente" + i + "@gmail.com");
			cliente.setSigUF("SP");
			cliente.setCep("05640001");
			cliente.setTipoPessoa("PF");
			cliente.setNmeCidade("São Paulo");
			cliente.setSobrenome("Teste");
			cliente.setNmeBairro("Morumbi");
			cliente.setDscLogra("Avenida teste, 123");
			
			clienteRepositoryImpl.save(cliente);
		}
	}
	
	private void gerarMassaApolice() {
		for(int i = 0; i < 200; i++) {
			Apolice apolice = new Apolice();
			apolice.setIdApolice(new Long(i));
			apolice.setCpfCnpjCliente(41766098851L + i);
			
			if(i % 2 == 1) {
				apolice.setModeloVeiculo("Mercedes");
			} else {
				apolice.setModeloVeiculo("BMW");
			}
			
			apolice.setAnoVeiculo(2012);
			apolice.setCorVeiculo("Branco");
			
			apoliceRepositoryImpl.save(apolice);
		}
	}
	
	private void gerarMassaSinisro() {
		for(int i = 0; i < 200; i++) {
			Sinistro sinistro = new Sinistro();
			sinistro.setIdSinistro(new Long(i));
			sinistro.setIdApolice(new Long(i));
			sinistro.setDescricao("Sinistro " + i);
			
			if(i % 2 == 1) {
				sinistro.setEndereco("SP");
			} else {
				sinistro.setEndereco("RJ");
			}
			
			if(i % 2 == 1) {
				sinistro.setTipoSinistro("acidente");
			} else {
				sinistro.setTipoSinistro("pane");
			}
			
			
			
			sinistroRepositoryImpl.save(sinistro);
		}
	}

}
