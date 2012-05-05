package br.com.mgx.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DataAccessObject {

	public abstract void queryUpdate(String queryString);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString);

	public abstract void queryUpdate(String queryString,Map<String, Object> namedParameters);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString,Map<String, Object> namedParameters);

	public abstract void queryUpdate(String queryString, Object[] params);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString, Object[] params);

	public abstract void queryUpdate(String queryString,Map<String, Object> namedParameters, Integer maxRows);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString,Map<String, Object> namedParameters, Integer maxRows);

	public abstract void queryUpdate(String queryString, Object[] params,Integer maxRows);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString, Object[] params,Integer maxRows);

	public abstract void queryUpdate(String queryString, Integer maxRows);

	@SuppressWarnings("unchecked")
	public abstract List query(String queryString, Integer maxRows);

	public abstract Object querySingleResult(String queryString);

	public abstract Object querySingleResult(String queryString,Map<String, Object> namedParameters);

	public abstract Object querySingleResult(String queryString, Object[] params);

	@SuppressWarnings("unchecked")
	public abstract Collection getAll(Class clazz);

	@SuppressWarnings("unchecked")
	public abstract Collection getAllOrderBy(Class clazz, String fieldName,Integer orderBy);

	@SuppressWarnings("unchecked")
	public abstract Object getById(Class clazz, Object pk);
	
	public abstract Object getById(String className, Object pk);	

	public abstract Object update(Object obj);
	
	
	/**
	 * Atualiza registro no banco e faz commit/flush na hora
	 * @param obj objeto a ser atualizado
	 */


	
	public abstract void add(Object obj);
	
	/**
	 * Adiciona registro no banco e faz commit/flush na hora
	 * @param obj objeto a ser persistido
	 */

	public Object addOrUpdate(Object obj);	

	public abstract void remove(Object obj);
	
	/**
	 * Remove registro no banco e faz commit/flush na hora
	 * @param obj objeto a ser removido
	 */
	public abstract void removeFlush(Object obj);
			
	@SuppressWarnings("unchecked")
	public abstract Object getAttributeOfObject(Class clazz,Object pk, String attribute);	
	
	public void desconecta(Object obj);	

}