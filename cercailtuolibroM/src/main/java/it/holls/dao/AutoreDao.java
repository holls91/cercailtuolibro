package it.holls.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import it.holls.model.Autore;
import it.holls.model.Libro;

public class AutoreDao extends GenericDAO<Autore> {

	public AutoreDao(EntityManager em) {
		super(em,Autore.class);
	}
	
	public List<Autore> findByName(String name) {
		return query("autore.nameLike").setParameter("nome", "%"+name+"%").getResultList();
	}

	public Autore findByNameSingleResult(String name) {
		return query("autore.byName").setParameter("nome", name).getSingleResult();
	}

	public Set<Libro> findBooks(int id) {
		return findById(id).getLibri();
	}

}
