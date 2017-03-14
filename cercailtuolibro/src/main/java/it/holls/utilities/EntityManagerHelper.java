package it.holls.utilities;

import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

	private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager getEntityManager() {
        if(em==null) {
        	ResourceBundle bundle = ResourceBundle.getBundle("it.holls.properties.cercailtuolibro");
        	emf = Persistence.createEntityManagerFactory(bundle.getString("persistenceTest"));
        	em = emf.createEntityManager();
        }
        return em;
    }
    
    public static void closeEntityManager(){
        em.clear();
        em.close();
        emf.close();
        emf = null;
        em = null;
    }
	
}
