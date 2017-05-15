package cercailtuolibro;

import it.holls.builders.AutoreBuilder;
import it.holls.builders.LibroBuilder;
import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.names.Cognomi;
import it.holls.names.NomiFemminili;
import it.holls.names.NomiMaschili;
import it.holls.services.AutoreService;
import it.holls.services.LibroService;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LibroDaoTest extends JPAHibernateTest {

	private static LibroService libroService = new LibroService();
	
	@Test
	public void saveAndRetrieveBook(){
		Libro libro1 = LibroBuilder
				.anLibroBuilder()
				.withAnno(2017)
				.withFonteTrama("Amazon")
				.withSmallTrama("Piccola trama")
				.withTitolo("Titolo bello")
				.withTitoloOriginale("Beautiful title")
				.withTrama("Grande trama")
				.withValid(true)
				.build();
		
		libroService.create(libro1);
        
		Libro libroRetrieved = libroService.get(libro1.getId());
		
		assertNotNull(libroRetrieved);
		assertEquals(java.util.Optional.of(2017).get(), libroRetrieved.getAnno());
		assertEquals("Amazon", libroRetrieved.getFonteTrama());
		assertEquals("Piccola trama", libroRetrieved.getSmallTrama());
		assertEquals("Titolo bello", libroRetrieved.getTitolo());
		assertEquals("Beautiful title", libroRetrieved.getTitoloOriginale());
		assertEquals("Grande trama", libroRetrieved.getTrama());

		
	}
}
