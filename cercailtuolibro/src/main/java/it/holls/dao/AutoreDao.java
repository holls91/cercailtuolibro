package it.holls.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.holls.model.Autore;

public class AutoreDao extends GenericDAO<Autore> {

	public AutoreDao(EntityManager em) {
		super(em,Autore.class);
	}
	
	public Autore findById(Integer id) {
		return getById(id);
	}

	public List<Autore> findByName(String name) {
		return getQuery("autore.nameLike").setParameter("nome", "%"+name+"%").getResultList();
	}
	public List<Autore> findAll() {
		return getQuery("autore.selectAll").getResultList();
	}

	public Autore findByNameSingleResult(String name) {
		// la query associata a "authorByName" è in annotazione alla classe Autore
		return em.createNamedQuery("autore.byName",Autore.class).setParameter("nome", name).getSingleResult();
	}

}
