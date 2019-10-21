package palvelinohjelmointi.destinations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.domain.Destination;
import palvelinohjelmointi.domain.DestinationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest // Annotating test class
public class DestinationRepositoryTest {

	@Autowired
	private DestinationRepository destinationRepository;
	
	// All test cases are annotated using Test annotation
	@Test
	public void findByCountryShouldReturnContinent() {
		List<Destination> destinations = destinationRepository.findByCountry("Spain");
		assertThat(destinations).hasSize(1);
		assertThat(destinations.get(0).getContinent()).isEqualTo("Europe");
	}
	
	@Test
	public void findByContinentShouldReturnCountry() {
		List<Destination> destinations = destinationRepository.findByContinent("Europe");
		assertThat(destinations).hasSize(2);
	}
	
	@Test
	public void saveNewDestination() {
		Destination destination = new Destination("TestCountry", "TestCapital", 3, "TestMonth", "TestLength");
		destinationRepository.save(destination); // Saving into the database
		assertThat(destination.getId()).isNotNull();
	}
	
	@Test
	public void deleteDestination() {
		List<Destination> destinations = destinationRepository.findByCountry("TestCountry");
		assertThat(destinations).hasSize(1);
		destinationRepository.deleteById(destinations.get(0).getId());
		List<palvelinohjelmointi.domain.Destination> deletedDestinations = destinationRepository.findByCountry("TestCountry");
		assertThat(deletedDestinations).hasSize(0);
	}
	
}
