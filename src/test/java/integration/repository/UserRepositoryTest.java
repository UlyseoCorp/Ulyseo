package integration.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ulyseo.model.User;
import com.ulyseo.repository.UserRepository;
import com.ulyseo.util.IntegrationTest;

public class UserRepositoryTest extends IntegrationTest<UserRepository> {

	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setPassword("test");
		userRepository.save(user);
	}

	@Test
	public void testFindByEmailAndPassword() {

		User user = userRepository.findByEmailAndPassword("test@test.com", "test");

		assertEquals(user.getEmail(), "test@test.com");
		assertEquals(user.getPassword(), "test");
	}

}
