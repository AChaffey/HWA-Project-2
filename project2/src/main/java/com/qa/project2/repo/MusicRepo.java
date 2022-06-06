package com.qa.project2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.project2.domain.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, Long> {

}
