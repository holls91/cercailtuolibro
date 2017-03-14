package it.holls.dao;

import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {
	
	protected EntityManager em;
	private Class<T> clazz;
	
	public GenericDAO(EntityManager em, Class<T> clazz) {
		this.em = em;
		this.clazz = clazz;
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
	// Update
	public T update(T data) {
		return entityManagerOperation(data,em::merge);
	}
	// Delete
	public void delete(T data) {
		entityManagerOperation(em::remove,data);
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
	
	public TypedQuery<T> getQuery(String query) {
		ResourceBundle bundle = ResourceBundle.getBundle("it.holls.properties.cercailtuolibro");
		bundle = ResourceBundle.getBundle(bundle.getString("queries"));
		return em.createQuery(bundle.getString(query),clazz);
	}
	
}
