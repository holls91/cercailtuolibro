package it.holls.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.holls.model.Autore;
import it.holls.model.Libro;

public class LibroDao extends GenericDAO<Libro> {
    
	public LibroDao(EntityManager em){
		super(em,Libro.class);
	}

	public List<Libro> findByTitle(String title){
		return query("libro.titleLike").setParameter("titolo", "%"+title+"%").getResultList();
	}
	
	public Autore findAuthors(Integer id){
		return getById(id).getAutore();
	}
	
}
