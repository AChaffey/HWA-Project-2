package com.qa.project2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.project2.domain.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, Long> { 
	
	 
		
		// Derived Query
		List<Music> findBySongName(String songName);
		
		// Manual SQL Query
		@Query(value = "SELECT * FROM user WHERE year = ?1", nativeQuery=true)
		Optional<Music> findByUsername(String username);
	}

