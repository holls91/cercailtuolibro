package it.holls.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Query<T> {

	private String query;
	private Class<T> clazz;
	private EntityManager em;
	private boolean isQuery;
	private Map<String,Object> parameters;
	
	public Query(Class<T> clazz, String query) {
		this(clazz,query,false);
	}
	public Query(Class<T> clazz, String query, boolean isQuery) {
		this.query = query;
		this.clazz = clazz;
		this.isQuery = isQuery;
		this.parameters = new HashMap<>();
	}
	
	
	public Query<T> setEntityManager(EntityManager em) {
		this.em = em;
		return this;
	}
	public Query<T> setParameter(String parameter, Object value) {
		parameters.put(parameter,value);
		return this;
	}

	public T getSingleResult() {
		return buildTypedQuery().getSingleResult();
	}
	public List<T> getResultList() {
		return buildTypedQuery().getResultList();
	}

	private TypedQuery<T> buildTypedQuery() {
		String currentQuery = this.query;
		if(!isQuery)
			currentQuery = ResourceBundle.getBundle("queries").getString(currentQuery);
		TypedQuery<T> typedQuery = em.createQuery(currentQuery,clazz);
		if(!parameters.isEmpty())
			parameters.forEach(typedQuery::setParameter);
		return typedQuery;
	}
	
}
