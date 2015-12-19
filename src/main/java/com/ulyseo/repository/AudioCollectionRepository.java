package com.ulyseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulyseo.model.AudioCollection;

public interface AudioCollectionRepository extends JpaRepository<AudioCollection, Long> {

}
