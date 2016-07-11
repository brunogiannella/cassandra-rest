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
import br.com.gft.digital.bigdata.pocbigdata.model.Apolice;

@Repository
public class ApoliceRepositoryImpl implements CassandraDao<Apolice> {

	Session session =  CassandraCluster.getInstance().iniciarSessao();
	Mapper<Apolice> mapper = new MappingManager(session).mapper(Apolice.class);
	
	public List<Apolice> get() {		
		ResultSet results = session.execute("SELECT * FROM pocbigdata.apolice");
		Result<Apolice> apolicesResult = mapper.map(results);
		return apolicesResult.all();
	};
	
	public Apolice get(Long idApolice) {
		return mapper.get(idApolice);
	}
	
	public void save(Apolice apolice) {
		mapper.save(apolice);;
	}
	
	public void delete(Apolice apolice) {
		mapper.delete(apolice);
	}

}
