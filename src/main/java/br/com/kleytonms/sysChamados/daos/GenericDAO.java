package br.com.kleytonms.sysChamados.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.kleytonms.sysChamados.entidades.BaseEntity;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Transactional
public abstract class GenericDAO<T extends BaseEntity, I extends Serializable> implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> persistedClass;


	protected GenericDAO(final Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}

	
	public T create(@Valid final T entity) throws DBException{
		this.entityManager.persist(entity);
		return entity;
	}

	
	public T update(@Valid final T entity) throws DBException{
		this.entityManager.merge(entity);
		return entity;
	}

	public List<T> create(@Valid final List<T> lista) throws DBException{
		for (final T t : lista) {
			this.entityManager.persist(t);
		}
		return lista;
	}

	public List<T> update(@Valid final List<T> lista) throws DBException{
		for (final T t : lista) {
			this.entityManager.merge(t);
		}
		return lista;
	}

	public T createOrUpdate(@Valid final T entity) throws DBException{
		if(entity.getId()==null) {
			this.entityManager.persist(entity);
		} else {
			this.entityManager.merge(entity);
		}
		return entity;
	}

	public void delete(final Long id) throws DBException{
		final T entity = this.find(id);
		final T mergedEntity = this.entityManager.merge(entity);
		this.entityManager.remove(mergedEntity);
	}
	
	public void delete(T t) throws DBException{
		final T entity = this.find(t.getId());
		final T mergedEntity = this.entityManager.merge(entity);
		this.entityManager.remove(mergedEntity);
	}
	
	public void delete(final List<T> lista) throws DBException{
		for (T t : lista) {
			this.entityManager.remove(t);
		}
	}

	public List<T> findAll() throws DBException{
		final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> query = builder.createQuery(this.persistedClass);
		query.from(this.persistedClass);
		return this.entityManager.createQuery(query).getResultList();
	}

	public T find(final Long id) throws DBException{
		return this.entityManager.find(this.persistedClass, id);
	}

	public T load(final I id) throws DBException{
		return this.entityManager.getReference(this.persistedClass, id);
	}

	public void refresh(@Valid final T entity) throws DBException{
		this.entityManager.refresh(entity);
	}
	
	public Object find(final Long id, Class<? extends Object> class1) throws DBException{
		return this.entityManager.find(class1, id);
	}
	
	public void detach(T t){
		this.entityManager.detach(t);
	}
}