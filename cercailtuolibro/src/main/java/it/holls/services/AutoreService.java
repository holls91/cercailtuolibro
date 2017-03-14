package it.holls.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.holls.builders.Cognomi;
import it.holls.builders.NomiFemminili;
import it.holls.builders.NomiMaschili;
import it.holls.builders.AutoreBuilder;
import it.holls.builders.LibroBuilder;
import it.holls.dao.AutoreDao;
import it.holls.model.Autore;
import it.holls.utilities.EntityManagerHelper;


@Path("/author")
public class AutoreService extends GeneralService {

	// CRUD
	@PUT
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Autore autore) {
		System.out.println("createAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.create(autore);
		return CREATED;
	}

	@GET
	@Path("/id/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Autore get(@PathParam("id") Integer id) {
		System.out.println("getAuthorById: " + id);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findById(id);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Autore autore) {
		System.out.println("updateAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.update(autore);
		return OK;
	}

	@DELETE
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Autore autore) {
		System.out.println("deleteAuthor: "+autore);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		dao.delete(autore);
		return OK;
	}

	
	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Autore> list() {
		//FIXME Questa riga va tolta prossimamente
		create(AutoreBuilder.anAutoreBuilder().withNome(NomiMaschili.random()+" "+Cognomi.random()).withLibro(LibroBuilder.anLibroBuilder().withTitolo("Le Aventure di "+NomiFemminili.random()).build()).build());
		System.out.println("listAuthors");
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findAll();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Autore getByName(@PathParam("name") String name) {
		System.out.println("getAuthorByName: " + name);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findByNameSingleResult(name);
	}
	
	@GET
	@Path("/find/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Autore> findByName(@PathParam("name") String name) {
		System.out.println("findAuthorByName: " + name);
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		return dao.findByName(name);
	}

}
