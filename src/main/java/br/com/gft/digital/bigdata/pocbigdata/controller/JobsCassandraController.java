package br.com.gft.digital.bigdata.pocbigdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.digital.bigdata.pocbigdata.dao.impl.IndicadorStringRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.model.IndicadorString;
import br.com.gft.digital.bigdata.pocbigdata.model.RestObject;

@RestController
public class JobsCassandraController {

	@Autowired
	private IndicadorStringRepositoryImpl indicadoresRepository;
		 
	@RequestMapping(value="/indicador", method = RequestMethod.GET)
	public RestObject consultaIndicadores() { 
		try {
			List<IndicadorString> indicadores = indicadoresRepository.get();
			return new RestObject(200, true, "Consulta realizada com sucesso", indicadores);
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

}
