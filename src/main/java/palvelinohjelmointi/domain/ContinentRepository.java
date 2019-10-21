package palvelinohjelmointi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// The CrudRepository provides CRUD functionality for the entity class that is being managed
// By extending CrudRepository, the ContinentRepository inherits methods for working with Continent persistence, 
// including methods for saving, deleting, and finding Continent entities
public interface ContinentRepository extends CrudRepository <Continent, Long> {
	
	List<Continent> findByName(String name);

}
