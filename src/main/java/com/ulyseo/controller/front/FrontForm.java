package com.ulyseo.controller.front;

import java.util.List;

import com.ulyseo.model.AudioElement;

public class FrontForm {

	private List<AudioElement> newsAudio;

	private List<AudioElement> topAudios;

	public List<AudioElement> getNewsAudio() {
		return newsAudio;
	}

	public void setNewsAudio(List<AudioElement> newsAudio) {
		this.newsAudio = newsAudio;
	}

	public List<AudioElement> getTopAudios() {
		return topAudios;
	}

	public void setTopAudios(List<AudioElement> topAudios) {
		this.topAudios = topAudios;
	}

}
