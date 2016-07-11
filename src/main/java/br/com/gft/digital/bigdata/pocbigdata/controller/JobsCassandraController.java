package br.com.gft.digital.bigdata.pocbigdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ClienteRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.model.Cliente;
import br.com.gft.digital.bigdata.pocbigdata.model.RestObject;

@RestController
public class JobsCassandraController {

	@Autowired
	private ClienteRepositoryImpl clienteRepository;
		 
	@RequestMapping(value="/cliente", method = RequestMethod.GET)
	public RestObject consultarClientes() { 
		try {
			List<Cliente> clientes = clienteRepository.get();
			return new RestObject(200, true, "Consulta realizada com sucesso", clientes);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro na consulta: " + e.getMessage(), null);
		}
	}
	
	@RequestMapping(value="/cliente/{cpfCnpj}", method = RequestMethod.GET)
	public RestObject consultarCliente(@PathVariable Long cpfCnpj) {
		try {
			Cliente cliente = clienteRepository.get(cpfCnpj);
			
			if(cliente == null) {
				return new RestObject(200, true, "Usuário não encontrado", cliente);
			}
			
			return new RestObject(200, true, "Consulta realizada com sucesso", cliente);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro na consulta: " + e.getMessage(), null);
		}
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.POST)
	public RestObject salvarCliente(@RequestBody Cliente cliente) { 
		try {
			clienteRepository.save(cliente);
			return new RestObject(200, true, "Cliente cadastrado com sucesso", null);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro no cadastro: " + e.getMessage(), null);
		}
	}
	
	@RequestMapping(value="/cliente/{cpfCnpj}", method = RequestMethod.DELETE)
	public RestObject removerCliente(@PathVariable Long cpfCnpj) { 
		try {
			Cliente cliente = new Cliente(cpfCnpj);
			clienteRepository.delete(cliente);
			return new RestObject(200, true, "Cliente cadastrado com sucesso", null);
		} catch(Exception e) {
			return new RestObject(500, false, "Ocorreu um erro no cadastro: " + e.getMessage(), null);
		}
	}
}
