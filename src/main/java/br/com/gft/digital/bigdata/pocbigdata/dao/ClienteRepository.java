package br.com.gft.digital.bigdata.pocbigdata.dao;

import java.util.List;

import br.com.gft.digital.bigdata.pocbigdata.model.Cliente;

public interface ClienteRepository {
	List<Cliente> getClientes();
	Cliente getCliente(Long cpfCnpj);
	void save(Cliente cliente);
	void delete(Cliente cliente);
}
