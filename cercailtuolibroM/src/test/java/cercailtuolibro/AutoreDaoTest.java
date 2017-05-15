package cercailtuolibro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import it.holls.builders.AutoreBuilder;
import it.holls.model.Autore;
import it.holls.services.AutoreService;
import it.holls.names.Cognomi;
import it.holls.names.NomiFemminili;
import it.holls.names.NomiMaschili;
import org.junit.Test;

public class AutoreDaoTest extends JPAHibernateTest {

	private static AutoreService autoreService = new AutoreService();
	
	private static AutoreBuilder empty = AutoreBuilder.anAutoreBuilder();
	private static AutoreBuilder pippo = AutoreBuilder.anAutoreBuilder().withNome("Pippo");
	private static AutoreBuilder pippo2 = AutoreBuilder.anAutoreBuilder().withNome("Pippo2");
	
//	@org.junit.BeforeClass
	public static void initDB() throws FileNotFoundException, SQLException {
		init();
		em.getTransaction().begin();
		for(Cognomi c : Cognomi.values()) {
			for(NomiFemminili f : NomiFemminili.values()) {
				em.persist(empty.withNome(f.toString()+" "+c.toString()).build());
			}
			for(NomiMaschili m : NomiMaschili.values()) {
				em.persist(empty.withNome(m.toString()+" "+c.toString()).build());
			}
		}
        em.getTransaction().commit();
	}
	
	@Test
	public void saveAndRetrieveAuthor(){
		Autore autore = pippo.build();
		
		autoreService.create(autore);
        
		Autore autoreRetrieved = autoreService.get(autore.getId());
		
		assertNotNull(autoreRetrieved);
		assertEquals("Pippo", autoreRetrieved.getNome());
		
	}
	
	@Test
	public void createMoreAuthorsAndDelete(){
		Autore autore1 = pippo.build();
		Autore autore2 = pippo2.build();
		
		autoreService.create(autore1);
		autoreService.create(autore2);
		
		List<Autore> autori = autoreService.findByName("Pippo");
		
		System.out.println(autori);
		
		assertNotNull(autori);
		assertEquals(2, autori.size());
		assertEquals("Pippo", autori.get(0).getNome());
		assertEquals("Pippo2", autori.get(1).getNome());
		
		autoreService.delete(autore1);
		autori = autoreService.findByName("Pippo");
		assertEquals(1, autori.size());
		assertEquals("Pippo2", autori.get(0).getNome());
	}

	@Test
	public void updateAutore(){
		Autore autore = pippo.build();
		autoreService.create(autore);
		
		Integer id = autore.getId();
		
		Autore entity = autoreService.get(id);
		assertNotNull(entity);
		assertEquals("Pippo", entity.getNome());
		
		autore.setNome("PippoChange");
		autoreService.update(autore);
		
		Autore entityAfterChange = autoreService.get(id);
		assertNotNull(entityAfterChange);
		assertEquals("PippoChange", entityAfterChange.getNome());
	}

}
