package com.ulyseo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "audio_chapter")
public class AudioChapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chapter")
	private List<AudioElement> audioElementList = new ArrayList<AudioElement>();

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AudioCollection.class)
	@JoinColumn(name = "collection_id")
	private AudioCollection collection;

	public Integer getPosition() {
		return collection.getAudioChaperList().indexOf(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AudioElement> getAudioElementList() {
		return audioElementList;
	}

	public void setAudioElementList(List<AudioElement> audioElementList) {
		this.audioElementList = audioElementList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AudioCollection getCollection() {
		return collection;
	}

	public void setCollection(AudioCollection collection) {
		this.collection = collection;
	}

}
