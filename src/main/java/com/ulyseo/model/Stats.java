package com.ulyseo.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "stats")
public class Stats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	@DateTimeFormat(pattern = "MM/yyyy")
	private Date monthAndYear;

	@ElementCollection
	@CollectionTable(name = "listenCount")
	@MapKeyColumn(name = "audioElement")
	private Map<AudioElement, Integer> listenCountByAudioElements;

	public Map<AudioElement, Integer> getListenCountByAudioElements() {
		return listenCountByAudioElements;
	}

	public void setListenCountByAudioElements(Map<AudioElement, Integer> listenCountByAudioElements) {
		this.listenCountByAudioElements = listenCountByAudioElements;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMonthAndYear() {
		return monthAndYear;
	}

	public void setMonthAndYear(Date monthAndYear) {
		this.monthAndYear = monthAndYear;
	}

}
