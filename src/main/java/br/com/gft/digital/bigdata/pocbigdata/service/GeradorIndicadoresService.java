package br.com.gft.digital.bigdata.pocbigdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.digital.bigdata.pocbigdata.dao.ClienteRepository;

@Service("geradorIndicadoresService")
public class GeradorIndicadoresService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void gerarIndicadores() {
		System.out.println("Indicadores foram gerados");
	}
	
}
