package br.com.gft.digital.bigdata.pocbigdata.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

import br.com.gft.digital.bigdata.pocbigdata.config.CassandraCluster;
import br.com.gft.digital.bigdata.pocbigdata.constantes.TipoIndexador;
import br.com.gft.digital.bigdata.pocbigdata.dao.CassandraDao;
import br.com.gft.digital.bigdata.pocbigdata.model.IndicadorString;

@Repository
public class IndicadorStringRepositoryImpl implements CassandraDao<IndicadorString> {

	Session session =  CassandraCluster.getInstance().iniciarSessao();
	Mapper<IndicadorString> mapper = new MappingManager(session).mapper(IndicadorString.class);
	
	public List<IndicadorString> get() {		
		ResultSet results = session.execute("SELECT * FROM pocbigdata.indicador_string");
		Result<IndicadorString> indicadoresResult = mapper.map(results);
		return indicadoresResult.all();
	};
	
	public IndicadorString get(Long id) {
		return mapper.get(TipoIndexador.values()[id.intValue()]);
	}
	
	public IndicadorString get(TipoIndexador tipoIndexador) {
		return mapper.get(tipoIndexador);
	}
	
	public IndicadorString get(String tipoIndexador) {
		return mapper.get(tipoIndexador);
	}
	
	public void save(IndicadorString indicador) {
		mapper.save(indicador);;
	}
	
	public void delete(IndicadorString indicador) {
		mapper.delete(indicador);
	}

}
