package palvelinohjelmointi.destinations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import palvelinohjelmointi.domain.User;
import palvelinohjelmointi.domain.UserRepository;

public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void createNewUser() {
		User user = new User("Test", "Test", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
