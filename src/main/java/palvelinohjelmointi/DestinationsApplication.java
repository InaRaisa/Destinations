package palvelinohjelmointi;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import palvelinohjelmointi.domain.Continent;
//import palvelinohjelmointi.domain.ContinentRepository;
//import palvelinohjelmointi.domain.Destination;
//import palvelinohjelmointi.domain.DestinationRepository;

// Author: Ina Räisänen
// Student number: a1800750

@SpringBootApplication
public class DestinationsApplication {
	//private static final Logger log = LoggerFactory.getLogger(DestinationsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DestinationsApplication.class, args);
	}
	
		/* Nämä poistetaan sitten kun MariaDB:seen on lisätty nämä tiedot:
	@Bean
	public CommandLineRunner demo(DestinationRepository repository, ContinentRepository crepository) {
		return (args) -> {
			crepository.save(new Continent("Africa"));
			crepository.save(new Continent("Asia"));
			crepository.save(new Continent("Europe"));
			crepository.save(new Continent("North America"));
			crepository.save(new Continent("Oceania"));
			crepository.save(new Continent("South America"));
			
			repository.save(new Destination(crepository.findByName("Africa").get(0), "Zimbabwe", "Harare", 16150362, "May to October", "4 weeks"));
			repository.save(new Destination(crepository.findByName("Asia").get(0), "Vietnam", "Hanoi", 9755407, "February to April", "3 weeks"));
			repository.save(new Destination(crepository.findByName("Europe").get(0), "Spain", "Madrid", 47007367, "March to May", "2 weeks"));
			
			log.info("fetch all destinations");
			for (Destination destination : repository.findAll()) {
				log.info(destination.toString());
			}
		};
	}*/
}
