package it.holls.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import it.holls.model.Libro;

public class LibroDao extends GenericDAO<Libro> {
    
	private static EntityManager em;
	
	public LibroDao(EntityManager em){
		super(em,Libro.class);
	}

	public List<Libro> findByTitle(String title){
		return getQuery("libro.titleLike").setParameter("titolo", "%"+title+"%").getResultList();
	}
	
	public Set<Libro> findByAuthor(Integer id){
		AutoreDao autoreDao = new AutoreDao(em);
		return autoreDao.getById(id).getLibri();
	}
	
}
