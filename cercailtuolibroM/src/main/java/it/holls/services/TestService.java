package it.holls.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.holls.model.Libro;

@Path("/test")
public class TestService extends GeneralService {

	@PUT
	@Path("/ciao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Libro libro) {
		return Response.ok("Ciao, io sono Tomcat!").build();
	}

	@GET
	@Path("/ciao/{nome}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response get(@PathParam("nome") String nome) {
		return Response.ok("Ciao "+nome+", io sono Tomcat!").build();
	}

}
