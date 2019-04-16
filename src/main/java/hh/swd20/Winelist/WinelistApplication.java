package hh.swd20.Winelist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Winelist.domain.User;
import hh.swd20.Winelist.domain.UserReposiotry;
import hh.swd20.Winelist.domain.Type;
import hh.swd20.Winelist.domain.TypeRepository;
import hh.swd20.Winelist.domain.Wine;
import hh.swd20.Winelist.domain.WineRepository;

@SpringBootApplication
public class WinelistApplication {
	private static final Logger log = LoggerFactory.getLogger(WinelistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WinelistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner wineDemo(WineRepository repository, TypeRepository trepository, UserReposiotry urepository) {
		return (args) -> {
			log.info("save some wines");
			
			trepository.save(new Type("Red"));
			trepository.save(new Type("White"));
			trepository.save(new Type("Sparkling"));
			trepository.save(new Type("Rose"));
			
			repository.save(new Wine("Sartori Amarone della Valpolicella", "Italy", 2013,"Corvina", trepository.findByName("Red").get(0)));
			repository.save(new Wine("Dopff au Moulin", "France", 2016, "Riesling", trepository.findByName("White").get(0)));
			
			log.info("fetch all wines");
			for (Wine wine : repository.findAll()) {
				log.info(wine.toString());
			}
			
			User user1 = new User("user","$2a$04$jA0nw8db2Hxz/UX1Cu5fH.9oMwrJw.sxEqoxGvmew8IA4iHLDtv..", "USER");
			User user2 = new User("admin","$2a$04$RR2A6g9knkGEN.pvYyw6ze5rcckMa8GN8lOpCc6k.Ywc47BusC1Uy", "ADMIN");
			
					urepository.save(user1);
					urepository.save(user2);

		};
	}
}