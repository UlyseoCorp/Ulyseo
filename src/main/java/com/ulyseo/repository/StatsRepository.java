package com.ulyseo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ulyseo.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long> {

	@Query("SELECT distinct a FROM Stats a ORDER BY monthAndYear DESC")
	public List<Stats> getLastsStats(Pageable pageable);
}
