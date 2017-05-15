package it.holls.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.holls.builders.AutoreBuilder;
import it.holls.builders.LibroBuilder;
import it.holls.dao.AutoreDao;
import it.holls.dao.LibroDao;
import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.utilities.EntityManagerHelper;
import it.holls.names.Cognomi;
import it.holls.names.NomiFemminili;
import it.holls.names.NomiMaschili;


@Path("/db")
public class DBService extends GeneralService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/author/{n}")
	public List<Autore> autori(@PathParam("n") Integer n) {
		AutoreDao dao = new AutoreDao(EntityManagerHelper.getEntityManager());
		List<Autore> lista = new ArrayList<>();
		for(int i=0; i<n; i++) {
			AutoreBuilder ab = AutoreBuilder.anAutoreBuilder();
			ab.withNome(NomiMaschili.random()+" "+Cognomi.random());
			int count = 0;
			do {
				count++;
			} while(Math.random()<0.5);
			libri(count).forEach(ab::withLibro);
			lista.add(ab.build());
			lista.forEach(dao::create);
		}
		return lista;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/book/{n}")
	public List<Libro> libri(@PathParam("n") Integer n) {
		LibroDao dao = new LibroDao(EntityManagerHelper.getEntityManager());
		List<Libro> lista = new ArrayList<>();
		for(int i=0; i<n; i++) {
			LibroBuilder lb = LibroBuilder.anLibroBuilder();
			lb.withTitolo("Le Aventure di "+NomiFemminili.random());
			lista.add(lb.build());
		}
		lista.forEach(dao::create);
		return lista;
	}

}
