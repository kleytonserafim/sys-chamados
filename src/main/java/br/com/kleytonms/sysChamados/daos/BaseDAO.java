package br.com.kleytonms.sysChamados.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
}
