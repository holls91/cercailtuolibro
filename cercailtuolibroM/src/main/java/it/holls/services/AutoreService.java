package it.holls.services;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.holls.dao.AutoreDao;
import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.utilities.EntityManagerHelper;


@Path("/author")
public class AutoreService extends GeneralService {

	// CRUD
	@PUT
	@Path("/create")	// http:localhost:8080/cercailtuolibro/author/create
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Autore autore) {
		System.out.println("createAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.create(autore);
		return CREATED;
	}

	@GET
	@Path("/{id}")		// http:localhost:8080/cercailtuolibro/author/{id}
	@Produces({ MediaType.APPLICATION_JSON })
	public Autore get(@PathParam("id") Integer id) {
		System.out.println("getAuthorById: " + id);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findById(id);
	}

	@PUT
	@Path("/update")		// http:localhost:8080/cercailtuolibro/author/update
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Autore autore) {
		System.out.println("updateAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.update(autore);
		return OK;
	}

	@DELETE
	@Path("/delete")		// http:localhost:8080/cercailtuolibro/author/delete
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Autore autore) {
		System.out.println("deleteAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.delete(autore);
		return OK;
	}

	
	@GET
	@Path("/list")		// http:localhost:8080/cercailtuolibro/author/list
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Autore> list() {
		System.out.println("listAuthors");
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findAll();
	}
	
	@GET
	@Path("/name/{name}")		// http:localhost:8080/cercailtuolibro/author/name/{name}
	@Produces({ MediaType.APPLICATION_JSON })
	public Autore getByName(@PathParam("name") String name) {
		System.out.println("getAuthorByName: " + name);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findByNameSingleResult(name);
	}
	
	@GET
	@Path("/find/{name}")		// http:localhost:8080/cercailtuolibro/author/find/{name}
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Autore> findByName(@PathParam("name") String name) {
		System.out.println("findAuthorByName: " + name);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findByName(name);
	}

	@GET
	@Path("/{id}/books")		// http:localhost:8080/cercailtuolibro/author/{id}/books
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<Libro> findBooks(@PathParam("id") Integer id) {
		System.out.println("findBooks for authorId: "+id);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findBooks(id);
	}

}
