package palvelinohjelmointi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DestinationRepository extends CrudRepository<Destination, Long> {
	    
	List<Destination> findByCountry(String country);
	
	List<Destination> findByContinent(String continent);
}