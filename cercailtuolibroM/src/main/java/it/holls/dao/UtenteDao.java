package it.holls.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.holls.model.Utente;

public class UtenteDao extends GenericDAO<Utente> {
    
	public UtenteDao(EntityManager em){
		super(em,Utente.class,"Utente");
	}

	public List<Utente> findUser(String username) {
		return query("utente.nameLike").setParameter("nome","%"+username+"%").getResultList();
	}
	
	public Utente getUser(String username) {
		return query("utente.byName").setParameter("nome",username).getSingleResult();
	}
	
}
