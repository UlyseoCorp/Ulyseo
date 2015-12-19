package com.ulyseo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "audio_collection")
public class AudioCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	public String title;

	@Column
	public String description;

	@OneToMany(cascade = CascadeType.ALL)
	public List<AudioChapter> audioChaperList = new ArrayList<AudioChapter>();

	@OneToOne
	public User author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AudioChapter> getAudioChaperList() {
		return audioChaperList;
	}

	public void setAudioChaperList(List<AudioChapter> audioChaperList) {
		this.audioChaperList = audioChaperList;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
