package unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ulyseo.model.AudioChapter;
import com.ulyseo.util.UnitTest;

public class AudioChapterTest extends UnitTest<AudioChapter> {

	@Test
	public void testContraints() {

		AudioChapter audioChapter = new AudioChapter();
		audioChapter.setTitle("title");

		this.check(audioChapter);
		assertEquals(this.getErrors().isEmpty(), true);

	}

}
