package unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ulyseo.model.AudioElement;
import com.ulyseo.util.UnitTest;

public class AudioElementTest extends UnitTest<AudioElement> {

	@Test
	public void testContraints() {

		AudioElement audioElement = new AudioElement();
		audioElement.setDescription("description");
		audioElement.setTitle("title");
		audioElement.setId(1);

		this.check(audioElement);
		assertEquals(this.getErrors().isEmpty(), true);
		assertEquals(audioElement.getDescription(), "description");
		assertEquals(audioElement.getTitle(), "title");
		assertEquals(audioElement.getId(), 1);

	}

}
