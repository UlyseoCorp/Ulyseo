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
	private AudioType type;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "collection")
	private List<AudioChapter> audioChaperList = new ArrayList<AudioChapter>();

	@OneToOne
	private User author;

	public AudioCollection() {
		AudioChapter audioChapter = new AudioChapter();
		audioChapter.setCollection(this);
		audioChaperList.add(audioChapter);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public AudioType getType() {
		return type;
	}

	public void setType(AudioType type) {
		this.type = type;
	}

}
