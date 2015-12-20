package com.ulyseo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ulyseo.model.AudioElement;

public interface AudioElementRepository extends JpaRepository<AudioElement, Long> {

	@Query("SELECT a FROM AudioElement a ORDER BY creationDate DESC")
	public List<AudioElement> getNewsAudio(Pageable pageable);

}
