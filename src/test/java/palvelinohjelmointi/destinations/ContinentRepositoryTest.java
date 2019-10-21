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

@RunWith(SpringRunner.class)
@DataJpaTest // Annotating test class

public class ContinentRepositoryTest {
	
	@Autowired
	ContinentRepository continentRepository;
	
	@Test
	public void saveNewContinent() {
		Continent continent = new Continent("TestContinent");
		continentRepository.save(continent);
		assertThat(continent.getId()).isNotNull();
	}
	
	@Test
	public void deleteContinent() {
		List<Continent> continents = continentRepository.findByName("TestContinent");
		assertThat(continents).hasSize(1);
		continentRepository.deleteById(continents.get(0).getId());
		List<Continent> deletedContinents = continentRepository.findByName("TestContinent");
		assertThat(deletedContinents).hasSize(0);
	}
}
