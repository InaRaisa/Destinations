package palvelinohjelmointi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//The CrudRepository provides CRUD functionality for the entity class that is being managed
//By extending CrudRepository, the DestinationRepository inherits methods for working with Destination persistence, 
//including methods for saving, deleting, and finding Destination entities
public interface DestinationRepository extends CrudRepository<Destination, Long> {
	    
	List<Destination> findByCountry(String country);
	
	List<Destination> findByContinent(String continent);
}