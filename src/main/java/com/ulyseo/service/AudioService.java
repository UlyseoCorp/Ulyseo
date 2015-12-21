package com.ulyseo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ulyseo.model.AudioElement;
import com.ulyseo.model.Stats;
import com.ulyseo.repository.AudioElementRepository;
import com.ulyseo.repository.StatsRepository;
import com.ulyseo.util.UtilTools;

@Service
public class AudioService {

	@Autowired
	private AudioElementRepository audioElementRepository;

	@Autowired
	private StatsRepository statsRepository;

	/**
	 * Return 8 most recent audios
	 * 
	 * @return
	 */
	public List<AudioElement> getNewsAudios() {

		List<AudioElement> audioElements = audioElementRepository.getNewsAudios(new PageRequest(0, 8));

		return audioElements;

	}

	/**
	 * Return the top 4 of better audio element for the day
	 * 
	 * @return
	 */
	public List<AudioElement> getTopAudios() {

		Stats stats = statsRepository.getLastsStats(new PageRequest(0, 1)).get(0);

		Map<AudioElement, Integer> map = stats.getListenCountByAudioElements();
		map = UtilTools.sortByValues(map);

		List<AudioElement> audioElements = new ArrayList<AudioElement>(map.keySet());
		List<AudioElement> audioRandomElements = audioElementRepository.getRandomAudios(new PageRequest(0, 4));
		audioElements.addAll(audioRandomElements);

		return audioElements;

	}

}
