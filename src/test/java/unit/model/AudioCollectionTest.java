package unit.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ulyseo.model.AudioChapter;
import com.ulyseo.model.AudioCollection;
import com.ulyseo.model.User;
import com.ulyseo.util.UnitTest;

public class AudioCollectionTest extends UnitTest<AudioCollection> {

	@Test
	public void testContraints() {

		AudioCollection audioCollection = new AudioCollection();
		audioCollection.setId(1);
		audioCollection.setDescription("description");
		audioCollection.setTitle("title");
		audioCollection.setAuthor(new User());
		audioCollection.setAudioChaperList(new ArrayList<AudioChapter>());

		this.check(audioCollection);
		assertEquals(this.getErrors().isEmpty(), true);

	}

}
