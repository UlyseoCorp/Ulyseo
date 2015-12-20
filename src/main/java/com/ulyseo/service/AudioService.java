package com.ulyseo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ulyseo.model.AudioElement;
import com.ulyseo.repository.AudioElementRepository;

@Service
public class AudioService {

	@Autowired
	private AudioElementRepository audioElementRepository;

	/**
	 * Return the top 5 of better audio element for the day
	 * 
	 * @return
	 */
	public List<AudioElement> getNewsAudio() {

		List<AudioElement> audioElements = audioElementRepository.getNewsAudio(new PageRequest(0, 4));

		return audioElements;

	}

}
