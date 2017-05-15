package cercailtuolibro;

import it.holls.builders.AutoreBuilder;
import it.holls.builders.LibroBuilder;
import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.services.AutoreService;
import it.holls.services.LibroService;
import jersey.repackaged.com.google.common.collect.Sets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gattino on 15/05/2017.
 */
public class DaoIntegrationTest extends JPAHibernateTest {

    private static AutoreService autoreService = new AutoreService();
    private static LibroService libroService = new LibroService();

    @Test
    public void createAuthorWithBooks(){
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

        Libro libro2 = LibroBuilder
                .anLibroBuilder()
                .withAnno(2017)
                .withFonteTrama("Amazon 2")
                .withSmallTrama("Piccola trama 2")
                .withTitolo("Titolo bello 2")
                .withTitoloOriginale("Beautiful title 2")
                .withTrama("Grande trama 2")
                .withValid(true)
                .build();

        libroService.create(libro2);


        Autore autore = AutoreBuilder
                .anAutoreBuilder()
                .withNome("Pippo")
                .withLibri(Sets.newHashSet(libro1, libro2))
                .build();

        autoreService.create(autore);

        Autore autoreRetrieved = autoreService.get(autore.getId());

        assertEquals(2, autoreRetrieved.getLibri().size());
    }
}
