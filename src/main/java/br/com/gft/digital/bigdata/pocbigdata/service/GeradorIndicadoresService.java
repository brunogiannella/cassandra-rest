package br.com.gft.digital.bigdata.pocbigdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.digital.bigdata.pocbigdata.constantes.TipoIndexador;
import br.com.gft.digital.bigdata.pocbigdata.dao.CassandraDao;

@Service("geradorIndicadoresService")
public class GeradorIndicadoresService {
	
	@Autowired
	private CassandraDao clienteRepository;
	
	public void gerarIndicadores() {
		
		String tipo = "";
		
		for (TipoIndexador indexador : TipoIndexador.values()) {
			if(indexador.equals(tipo)) {
				  
			}
		}
		
		System.out.println("Indicadores foram gerados");
	}
	
}
