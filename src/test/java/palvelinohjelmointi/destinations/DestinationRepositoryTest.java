package palvelinohjelmointi.destinations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.domain.Continent;
import palvelinohjelmointi.domain.ContinentRepository;
import palvelinohjelmointi.domain.Destination;
import palvelinohjelmointi.domain.DestinationRepository;
import palvelinohjelmointi.domain.User;
import palvelinohjelmointi.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DestinationRepositoryTest {

	@Autowired
	private DestinationRepository destinationRepository;
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByCountryShouldReturnContinent() {
		List<Destination> destinations = destinationRepository.findByCountry("Spain");

		assertThat(destinations).hasSize(0);
		assertThat(destinations.get(0).getContinent()).isEqualTo("Europe");
	}
	
	@Test
	public void findByContinentShouldReturnCountry() {
		List<palvelinohjelmointi.domain.Destination> destinations = destinationRepository.findByContinent("Spain");
		assertThat(destinations).hasSize(1);
	}
	
	@Test
	public void saveNewDestination() {
		Destination destination = new Destination("TestCountry", "TestCapital", 3, "TestMonth", "TestLength");
		destinationRepository.save(destination);
		assertThat(destination.getId()).isNotNull();
	}
	
	@Test
	public void saveNewContinent() {
		Continent continent = new Continent("TestContinent");
		continentRepository.save(continent);
		assertThat(continent.getId()).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		User user = new User("Test", "Test", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteDestination() {
		List<palvelinohjelmointi.domain.Destination> destinations = destinationRepository.findByCountry("TestCountry");
		assertThat(destinations).hasSize(0);
		destinationRepository.deleteById(destinations.get(0).getId());
		List<palvelinohjelmointi.domain.Destination> deletedDestinations = destinationRepository.findByCountry("TestCountry");
		assertThat(deletedDestinations).hasSize(0);
	}
	
	@Test
	public void deleteContinent() {
		List<Continent> continents = continentRepository.findByName("TestContinent");
		assertThat(continents).hasSize(0);
		continentRepository.deleteById(continents.get(0).getId());
		List<Continent> deletedContinents = continentRepository.findByName("TestContinent");
		assertThat(deletedContinents).hasSize(0);
	}
}
