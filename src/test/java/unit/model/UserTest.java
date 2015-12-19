package unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ulyseo.model.User;
import com.ulyseo.util.UnitTest;

public class UserTest extends UnitTest<User> {

	@Test
	public void testContraints() {

		User user = new User();
		user.setEmail("te");
		user.setPassword("te");

		this.check(user);
		assertEquals(this.getErrors().isEmpty(), false);

		user.setEmail("test@test.fr");
		user.setPassword("te");

		this.check(user);
		assertEquals(this.getErrors().isEmpty(), false);

		user.setEmail("test@test.fr");
		user.setPassword("test");

		this.check(user);
		assertEquals(this.getErrors().isEmpty(), true);

	}

}
