package br.com.gft.digital.bigdata.pocbigdata.dao;

import java.util.List;

public interface CassandraDao<T> {
	List<T> get();
	T get(Long id);
	void save(T obj);
	void delete(T obj);
}
