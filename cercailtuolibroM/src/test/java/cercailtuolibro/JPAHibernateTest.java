package cercailtuolibro;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import it.holls.utilities.EntityManagerHelper;

public class JPAHibernateTest {
	
    protected static EntityManager em;

//    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
    	em = EntityManagerHelper.getEntityManager();
    }

//    @AfterClass
    public static void tearDown(){
    	EntityManagerHelper.closeEntityManager();
    }
}
