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
import br.com.gft.digital.bigdata.pocbigdata.model.Sinistro;

@Repository
public class SinistroRepositoryImpl implements CassandraDao<Sinistro> {

	Session session =  CassandraCluster.getInstance().iniciarSessao();
	Mapper<Sinistro> mapper = new MappingManager(session).mapper(Sinistro.class);
	
	public List<Sinistro> get() {		
		ResultSet results = session.execute("SELECT * FROM pocbigdata.sinistro");
		Result<Sinistro> sinistrosResult = mapper.map(results);
		return sinistrosResult.all();
	};
	
	public List<Sinistro> getSinistros(Long idSinistro) {
		ResultSet results = session.execute("SELECT * FROM pocbigdata.sinistro WHERE id_sinistro > " + idSinistro + " ORDER BY id_sinistro");
		Result<Sinistro> sinistrosResult = mapper.map(results);
		return sinistrosResult.all();
	}
	
	public Sinistro get(Long idSinistro) {
		return mapper.get(idSinistro);
	}
	
	public void save(Sinistro sinistro) {
		mapper.save(sinistro);;
	}
	
	public void delete(Sinistro sinistro) {
		mapper.delete(sinistro);
	}

}
