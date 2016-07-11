package br.com.gft.digital.bigdata.pocbigdata.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

import br.com.gft.digital.bigdata.pocbigdata.config.CassandraCluster;
import br.com.gft.digital.bigdata.pocbigdata.dao.CassandraDao;
import br.com.gft.digital.bigdata.pocbigdata.model.Cliente;

@Repository
public class ClienteRepositoryImpl implements CassandraDao<Cliente> {

	Session session =  CassandraCluster.getInstance().iniciarSessao();
	Mapper<Cliente> mapper = new MappingManager(session).mapper(Cliente.class);
	
	public List<Cliente> get() {		
		ResultSet results = session.execute("SELECT * FROM pocbigdata.cliente");
		Result<Cliente> clientesResult = mapper.map(results);
				
		return clientesResult.all();
	};
	
	public Cliente get(Long cpfCnpj) {
		return mapper.get(cpfCnpj);
	}
	
	public void save(Cliente cliente) {
		mapper.save(cliente);;
	}
	
	public void delete(Cliente cliente) {
		mapper.delete(cliente);
	}

}
