package it.holls.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.holls.dao.UtenteDao;
import it.holls.model.Utente;
import it.holls.utilities.EntityManagerHelper;


@Path("/user")
public class UtenteService extends GeneralService {

	@GET
	@Path("/{username}")		// http:localhost:8080/cercailtuolibro/user/{username}
	@Produces({ MediaType.APPLICATION_JSON })
	public Utente get(@PathParam("username") String username) {
		System.out.println("getUser: "+username);
		UtenteDao dao = new UtenteDao(EntityManagerHelper.getEntityManager()); 
		return dao.getUser(username);
	}

}
