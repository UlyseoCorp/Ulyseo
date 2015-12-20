package com.ulyseo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "audio_element")
public class AudioElement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Date creationDate;

	@ManyToOne(targetEntity = AudioChapter.class)
	@JoinColumn(name = "chapter_id")
	private AudioChapter chapter;

	public Integer getPosition() {
		return chapter.getAudioElementList().indexOf(this) + 1;
	}

	public AudioChapter getChapter() {
		return chapter;
	}

	public void setChapter(AudioChapter chapter) {
		this.chapter = chapter;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
