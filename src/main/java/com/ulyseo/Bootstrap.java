package com.ulyseo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyseo.model.AudioCollection;
import com.ulyseo.model.AudioElement;
import com.ulyseo.model.AudioType;
import com.ulyseo.model.Stats;
import com.ulyseo.model.User;
import com.ulyseo.repository.AudioCollectionRepository;
import com.ulyseo.repository.AudioElementRepository;
import com.ulyseo.repository.StatsRepository;
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

	@Autowired
	StatsRepository statsRepository;

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

		AudioElement surivaureEp1 = new AudioElement();
		surivaureEp1.setTitle("OUalala");
		surivaureEp1.setDescription("Une intro de folie.");
		surivaureEp1.setChapter(surivaure.getAudioChaperList().get(0));
		surivaureEp1.setCreationDate(new Date());
		audioElementRepository.save(surivaureEp1);
		audioElementRepository.flush();

		// Axeomodia
		AudioCollection guilde = new AudioCollection();
		guilde.setTitle("La Guilde d'Ersoh");
		guilde.setDescription("A big and cool adventure.");
		guilde.setAuthor(user);
		guilde.setImage("http://www.journaldugeek.com/wp-content/blogs.dir/1/files/2015/10/affiche-star-wars-7.jpg");
		guilde.setType(AudioType.SAGA);
		audioCollectionRepository.save(guilde);
		audioCollectionRepository.flush();

		AudioElement guildeEP = new AudioElement();
		guildeEP.setTitle("In the space");
		guildeEP.setDescription("Une intro de folie.");
		guildeEP.setChapter(guilde.getAudioChaperList().get(0));
		guildeEP.setCreationDate(new Date());
		audioElementRepository.save(guildeEP);
		audioElementRepository.flush();

		// Stats
		Calendar cal = Calendar.getInstance();

		Stats stats = new Stats();
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.YEAR, 2010);
		Date monthAndYear = cal.getTime();
		stats.setMonthAndYear(monthAndYear);
		stats.setListenCountByAudioElements(new HashMap<AudioElement, Integer>());
		stats.getListenCountByAudioElements().put(startrukIntro, 5);
		stats.getListenCountByAudioElements().put(donjonEp1, 2);
		stats.getListenCountByAudioElements().put(surivaureEp, 7);
		statsRepository.save(stats);

		Stats stats2 = new Stats();
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.YEAR, 2012);
		monthAndYear = cal.getTime();
		stats2.setMonthAndYear(monthAndYear);
		stats2.setListenCountByAudioElements(new HashMap<AudioElement, Integer>());
		stats2.getListenCountByAudioElements().put(startrukIntro, 51);
		stats2.getListenCountByAudioElements().put(donjonEp1, 23);
		stats2.getListenCountByAudioElements().put(surivaureEp, 2);
		statsRepository.save(stats2);

	}

}
