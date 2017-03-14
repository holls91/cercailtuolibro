package it.holls.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.holls.dao.UtenteDao;
import it.holls.model.Utente;


@Path("/user")
public class UtenteService extends GeneralService {

//	@Inject	// ??? booooh ???
//	private UtenteDao dao;
//	
//	@GET
//	@Path("/{id}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Utente get(@PathParam("id") Integer id) {
//		System.out.println("getUser: " + id);
//		return dao.findByID(id);
//	}

}
