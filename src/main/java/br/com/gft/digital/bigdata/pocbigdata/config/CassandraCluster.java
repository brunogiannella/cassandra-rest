package br.com.gft.digital.bigdata.pocbigdata.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

import br.com.gft.digital.bigdata.pocbigdata.constantes.CassandraConstantes;

public class CassandraCluster {

	private static CassandraCluster uniqueInstance;
	private Session session;


	private CassandraCluster() {
	}

	public static synchronized CassandraCluster getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new CassandraCluster();

		return uniqueInstance;
	}

	public Session iniciarSessao() {
		if (uniqueInstance.getSession() == null) {
			Cluster cluster = Cluster.builder().addContactPoint(CassandraConstantes.IP_CONEXAO).build();
			Metadata metadata = cluster.getMetadata();
			System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
			uniqueInstance.setSession(cluster.connect());
		}

		return uniqueInstance.getSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

}