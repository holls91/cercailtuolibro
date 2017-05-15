package cercailtuolibro;

import java.util.function.Function;
import java.util.function.Supplier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.holls.services.AutoreService;
import it.holls.services.DBService;
import it.holls.services.GeneralService;
import it.holls.services.LibroService;
import it.holls.utilities.EntityManagerHelper;

public class EasyServices {

	public static void main(String[] args) throws JsonProcessingException {

		esegui(DBService::new,		s->s.autori(10),	false);
		esegui(DBService::new,		s->s.libri(10),		false);
		esegui(AutoreService::new,	s->s.list(),		true);
		esegui(LibroService::new,	s->s.list(),		true);
		
		EntityManagerHelper.closeEntityManager();
		
	}

	public static <T extends GeneralService> void esegui(Supplier<T> service, Function<T,Object> call, boolean print) throws JsonProcessingException {
		esegui(service,call,print,false);
	}
	public static <T extends GeneralService> void esegui(Supplier<T> service, Function<T,Object> call, boolean print, boolean prettyPrint) throws JsonProcessingException {
		T myService = service.get();
		Object result = call.apply(myService);
		ObjectMapper mapper = new ObjectMapper();
		if(print)
			if(!prettyPrint) System.out.println(mapper.writeValueAsString(result));
			else System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
		
	}

}
