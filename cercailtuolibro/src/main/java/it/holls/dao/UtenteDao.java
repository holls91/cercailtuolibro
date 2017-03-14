package it.holls.dao;

import javax.persistence.EntityManager;

import it.holls.model.Utente;

public class UtenteDao {
    
	private static EntityManager em;
	
	public UtenteDao(EntityManager em){
		UtenteDao.em = em;
	}

//	public Utente findByID(Integer id){
//		return (Utente)em.find(Utente.class,id);
//	}
//	
}
