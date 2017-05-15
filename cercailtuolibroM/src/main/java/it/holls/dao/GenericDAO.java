package it.holls.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.persistence.EntityManager;

import it.holls.utilities.Query;

public class GenericDAO<T> {
	
	protected EntityManager em;
	private Class<T> clazz;
	private String tableName;
	
	public GenericDAO(EntityManager em, Class<T> clazz) {
		this(em,clazz,clazz.getSimpleName());
	}
	public GenericDAO(EntityManager em, Class<T> clazz, String tableName) {
		this.em = em;
		this.clazz = clazz;
		this.tableName = tableName;
	}

	// Operazioni di CRUD:
	// Create
	public void create(T data) {
		entityManagerOperation(em::persist,data);
	}
	// Read
	public T getById(Integer id) {
		return em.find(clazz,id);
	}
	public T findById(Integer id) {
		return getById(id);
	}
	// Update
	public T update(T data) {
		return entityManagerOperation(data,em::merge);
	}
	// Delete
	public void delete(T data) {
		entityManagerOperation(em::remove,data);
	}
	
	public List<T> findAll() {
		return query("SELECT t from "+tableName+" t",true).getResultList();
//		return query(tableName.toLowerCase()+".selectAll").getResultList();	// query dal file di .properties
	}
	
	protected void entityManagerOperation(Consumer<T> operation, T data) {
		entityManagerOperation(data,d->{operation.accept(d);return null;});
	}
	protected T entityManagerOperation(T data, UnaryOperator<T> operation) {
		em.getTransaction().begin();
        T out = operation.apply(data);
        em.getTransaction().commit();
        return out;
	}
	
	public Query<T> query(String query) {
		return query(query,false);
	}
	public Query<T> query(String query, boolean isQuery) {
		return new Query<T>(clazz,query,isQuery).setEntityManager(em);
	}
	
}
