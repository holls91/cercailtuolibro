package it.holls.services;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.holls.model.Ruolo;

public class GeneralService extends Application {

	public static final Response UNAUTHORIZED = Response.status(Status.UNAUTHORIZED).build();
	public static final Response CREATED = Response.status(Status.CREATED).build();
	public static final Response OK = Response.status(Status.OK).build();
	
	
	public boolean assertRole(Ruolo userRole, Ruolo... acceptRoles) {
		for(Ruolo r : acceptRoles)
			if(r==userRole)
				return true;
		return false;
	}
	
	public Response response(Status status) {
		return Response.status(status).build();
	}
	
}
