package com.ulyseo;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyseo.model.AudioCollection;
import com.ulyseo.model.AudioElement;
import com.ulyseo.model.AudioType;
import com.ulyseo.model.User;
import com.ulyseo.repository.AudioCollectionRepository;
import com.ulyseo.repository.AudioElementRepository;
import com.ulyseo.repository.UserRepository;

@Service
public class Bootstrap implements InitializingBean {

	private static Logger logger = Logger.getLogger(Bootstrap.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	AudioCollectionRepository audioCollectionRepository;

	@Autowired
	AudioElementRepository audioElementRepository;

	@Override
	@Transactional()
	public void afterPropertiesSet() throws Exception {
		logger.info("Bootstrapping data...");

		User user = new User();
		user.setEmail("test@gmail.com");
		user.setPassword("test");
		userRepository.save(user);

		this.loadAudioLib(user);

		logger.info("...Bootstrapping completed");
	}

	public void loadAudioLib(User user) {
		logger.info("Load audio lib");

		// Startruc
		AudioCollection startruk = new AudioCollection();
		startruk.setTitle("Startruk");
		startruk.setDescription("A big and cool adventure.");
		startruk.setAuthor(user);
		startruk.setImage("http://www.avoir-alire.com/IMG/jpg/star_trek_xi_ver18.jpg");
		startruk.setType(AudioType.SAGA);
		audioCollectionRepository.save(startruk);
		audioCollectionRepository.flush();

		AudioElement startrukIntro = new AudioElement();
		startrukIntro.setTitle("intro");
		startrukIntro.setDescription("Une intro de folie.");
		startrukIntro.setChapter(startruk.getAudioChaperList().get(0));
		startrukIntro.setCreationDate(new Date());
		audioElementRepository.save(startrukIntro);
		audioElementRepository.flush();

		AudioElement startrukIntro2 = new AudioElement();
		startrukIntro2.setTitle("bande annonce");
		startrukIntro2.setDescription("Une intro de folie.");
		startrukIntro2.setChapter(startruk.getAudioChaperList().get(0));
		startrukIntro2.setCreationDate(new Date());
		audioElementRepository.save(startrukIntro2);
		audioElementRepository.flush();

		// Le donjon de naheulbeuk
		AudioCollection donjon = new AudioCollection();
		donjon.setTitle("Le donjon de naheulbeuk");
		donjon.setDescription("A big and cool adventure.");
		donjon.setAuthor(user);
		donjon.setImage("http://www.editionsoctobre.com/images/thumbnails/0000/0141/42-Naheulbeuk0_large.jpg");
		donjon.setType(AudioType.SAGA);
		audioCollectionRepository.save(donjon);
		audioCollectionRepository.flush();

		AudioElement donjonEp1 = new AudioElement();
		donjonEp1.setTitle("Les trolls des cavernes");
		donjonEp1.setDescription("Une intro de folie.");
		donjonEp1.setChapter(donjon.getAudioChaperList().get(0));
		donjonEp1.setCreationDate(new Date());
		audioElementRepository.save(donjonEp1);
		audioElementRepository.flush();

		// Les rescapé du survivaure
		AudioCollection surivaure = new AudioCollection();
		surivaure.setTitle("Les rescapé du survivaure");
		surivaure.setDescription("A big and cool adventure.");
		surivaure.setAuthor(user);
		surivaure.setImage("http://i.skyrock.net/9131/25429131/pics/916152698_small.jpg");
		surivaure.setType(AudioType.SAGA);
		audioCollectionRepository.save(surivaure);
		audioCollectionRepository.flush();

		AudioElement surivaureEp = new AudioElement();
		surivaureEp.setTitle("In the space");
		surivaureEp.setDescription("Une intro de folie.");
		surivaureEp.setChapter(surivaure.getAudioChaperList().get(0));
		surivaureEp.setCreationDate(new Date());
		audioElementRepository.save(surivaureEp);
		audioElementRepository.flush();

	}

}
