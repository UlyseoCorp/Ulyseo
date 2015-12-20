package unit.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ulyseo.model.AudioChapter;
import com.ulyseo.model.AudioElement;
import com.ulyseo.util.UnitTest;

public class AudioChapterTest extends UnitTest<AudioChapter> {

	@Test
	public void testContraints() {

		AudioChapter audioChapter = new AudioChapter();
		audioChapter.setId(1);
		audioChapter.setAudioElementList(new ArrayList<AudioElement>());
		audioChapter.setTitle("title");

		this.check(audioChapter);
		assertEquals(this.getErrors().isEmpty(), true);
		assertEquals(audioChapter.getTitle(), "title");
		assertEquals(audioChapter.getId(), 1);
		assertEquals(audioChapter.getAudioElementList().size(), 0);

	}

}
