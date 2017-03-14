package it.holls.services;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.holls.dao.LibroDao;
import it.holls.model.Libro;
import it.holls.model.Utente;
import it.holls.utilities.EntityManagerHelper;


@Path("/book")
public class LibroService extends GeneralService {

	@PUT
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Libro libro) {
		System.out.println("createLibro: "+libro);
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		dao.create(libro);
		return CREATED;
	}

	@GET
	@Path("/id/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Libro get(@PathParam("id") Integer id) {
		System.out.println("LibroService.get("+id+")");
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		return dao.getById(id);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Libro libro) {
		System.out.println("updateLibro: "+libro);
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		dao.update(libro);
		return OK;
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(Libro libro) {
		System.out.println("deleteLibro: "+libro);
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		dao.delete(libro);
		return OK;
	}
	
	
	@GET
	@Path("/find/{title}")
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Libro> findByTitle(@PathParam("title") String title) {
		System.out.println("LibroService.findByTitle("+title+")");
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		return dao.findByTitle(title);
	}
	@GET
	@Path("/author/id/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Set<Libro> findByAuthor(@PathParam("id") Integer id) {
		System.out.println("LibroService.findByAuthor("+id+")");
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		return dao.findByAuthor(id);
	}

	@POST
	@Path("/approve/{id}")
	public Response approva(@PathParam("id") Integer id) {
		System.out.println("LibroService.approva("+id+")");
		Utente utente = new Utente();	// ovviamente non da qui...
		if(!assertRole(utente.getRuolo()))
			return UNAUTHORIZED;
		// TODO
		return null;
	}

}
