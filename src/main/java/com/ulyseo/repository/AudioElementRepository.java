package com.ulyseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulyseo.model.AudioElement;

public interface AudioElementRepository extends JpaRepository<AudioElement, Long> {

}
