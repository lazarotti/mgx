package br.com.mgx.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.transaction.Transaction;

import br.com.mgx.exception.SiqDaoException;
import br.com.mgx.exception.SiqEntidadeNaoEncontradaException;



/**
 * Classe criada conforme BluePrint da Sun no catologo JavaEE5<br/>. <a
 * href=http://webdev2.sun.com/bpcatalog>JavaEE 5 Catalog</a>
 * 
 * @author alazarotti
 * 
 */
@Name("dao")
@AutoCreate
public class JpaDao implements DataAccessObject {

	@In
	private EntityManager entityManager;


	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String)
	 */
	public void queryUpdate(String queryString) {
		queryFactory(queryString, 0).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString) {
		return queryFactory(queryString, 0).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String,
	 *      java.util.Map)
	 */
	public void queryUpdate(String queryString,
			Map<String, Object> namedParameters) {
		queryFactory(queryString, namedParameters, 0).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String,
	 *      java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString, Map<String, Object> namedParameters) {
		return queryFactory(queryString, namedParameters, 0).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String,
	 *      java.lang.Object[])
	 */
	public void queryUpdate(String queryString, Object[] params) {
		queryFactory(queryString, params, 0).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String,
	 *      java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString, Object[] params) {
		return queryFactory(queryString, params, 0).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String,
	 *      java.util.Map, java.lang.Integer)
	 */
	public void queryUpdate(String queryString,
			Map<String, Object> namedParameters, Integer maxRows) {
		queryFactory(queryString, namedParameters, maxRows).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String,
	 *      java.util.Map, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString, Map<String, Object> namedParameters,
			Integer maxRows) {
		return queryFactory(queryString, namedParameters, maxRows)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String,
	 *      java.lang.Object[], java.lang.Integer)
	 */
	public void queryUpdate(String queryString, Object[] params, Integer maxRows) {
		queryFactory(queryString, params, maxRows).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String,
	 *      java.lang.Object[], java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString, Object[] params, Integer maxRows) {
		return queryFactory(queryString, params, maxRows).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#queryUpdate(java.lang.String,
	 *      java.lang.Integer)
	 */
	public void queryUpdate(String queryString, Integer maxRows) {
		queryFactory(queryString, maxRows).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#query(java.lang.String,
	 *      java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List query(String queryString, Integer maxRows) {
		return queryFactory(queryString, maxRows).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#querySingleResult(java.lang.String)
	 */
	public Object querySingleResult(String queryString) {
		Object obj = null;
		try {
			obj = queryFactory(queryString, 0).getSingleResult();
		} catch (NoResultException e) {
			throw new SiqEntidadeNaoEncontradaException(e);
		}
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#querySingleResult(java.lang.String,
	 *      java.util.Map)
	 */
	public Object querySingleResult(String queryString,
			Map<String, Object> namedParameters) {
		Object obj = null;
		try {
			obj = queryFactory(queryString, namedParameters, 0)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new SiqEntidadeNaoEncontradaException(e);
		}
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#querySingleResult(java.lang.String,
	 *      java.lang.Object[])
	 */
	public Object querySingleResult(String queryString, Object[] params) {
		Object obj = null;
		try {
			obj = queryFactory(queryString, params, 0).getSingleResult();
		} catch (NoResultException e) {
			throw new SiqEntidadeNaoEncontradaException(e);
		}
		return obj;
	}

	private Query queryFactory(String queryString,
			Map<String, Object> namedParameters, Integer maxRows) {
		Query query = queryFactory(queryString, maxRows);
		for (Iterator<String> iter = namedParameters.keySet().iterator(); iter
				.hasNext();) {
			String key = iter.next();
			query.setParameter(key, namedParameters.get(key));
		}
		return query;
	}

	private Query queryFactory(String queryString, Object[] params,
			Integer maxRows) {
		Query query = queryFactory(queryString, maxRows);
		for (int i = 1; i <= params.length; i++) {
			query.setParameter(i, params[i - 1]);
		}
		return query;
	}

	private Query queryFactory(String queryString, Integer maxRows) {
		Query query = entityManager.createQuery(queryString);
		if (maxRows.intValue() != 0)
			query.setMaxResults(maxRows.intValue());
		return query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#getAll(java.lang.Class)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#getAll(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Collection getAll(Class clazz) {
		return query("from " + clazz.getName() + " obj");
	}

	@SuppressWarnings("unchecked")
	public Collection getAllOrderBy(Class clazz, String fieldName,
			Integer orderBy) {

		String order = null;

		if (orderBy == null || orderBy.equals(Type.ORDERBY_ASC))
			order = "ASC";
		else
			order = "DESC";

		return query("FROM " + clazz.getName() + " obj ORDER BY obj."
				+ fieldName + " " + order);
	}

	@SuppressWarnings("unchecked")
	public Object getById(Class clazz, Object pk) {
		return entityManager.find(clazz, pk);
	}
	
	
	@SuppressWarnings("unchecked")
	public Object getById(String className, Object pk) {
		Object obj = null;
		try{
			obj = getById(Class.forName(className), pk);
		}catch(Exception e){
			 throw new SiqDaoException(e);
		}
		return obj;
	}
	

	public Object addOrUpdate(Object obj) {
		if(entityManager.contains(obj)){
			obj = entityManager.merge(obj);
		}else{
			entityManager.persist(obj);
		}
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#update(java.lang.Object)
	 */
	public Object update(Object obj) {
		return entityManager.merge(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#add(java.lang.Object)
	 */
	public void add(Object obj) {
		entityManager.persist(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.siq.gqf.dao.jpa.RepositoryMaster#remove(java.lang.Object)
	 */
	public void remove(Object obj) {
		entityManager.remove(obj);
	}

	@SuppressWarnings("unchecked")
	public Object getAttributeOfObject(Class clazz, Object pk, String attribute) {
		Object obj = null;
		StringBuffer query = new StringBuffer();
		query.append("select clazz.");
		query.append(attribute);
		query.append(" from ");
		query.append(clazz.getName());
		query.append(" clazz where clazz.id = ? ");
		try {
			obj = querySingleResult(query.toString(), new Object[] { pk });
		} catch (NoResultException e) {
			throw new SiqEntidadeNaoEncontradaException(e);
		}
		return obj;
	}


	public void removeFlush(Object obj) {
		try {

			obj = entityManager.merge(obj);
			remove(obj);			
			Transaction.instance().commit();			

		} catch (Exception e) {
			throw new SiqDaoException(e);
			
		} finally{
			try {
				Transaction.instance().begin();
			} catch (Exception e) {
				throw new SiqDaoException(e);
			}
		}
		
	}

	public void desconecta(Object obj){
		Session session = (Session)entityManager.getDelegate();
		session.evict(obj);
	}

}
