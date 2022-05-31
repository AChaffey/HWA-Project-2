package com.qa.project2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.project2.domain.Music;
import com.qa.project2.repo.MusicRepo;

@Service
public class MusicService {
	
	
		
		private MusicRepo repo;
		
		public MusicService(MusicRepo repo) {
			this.repo = repo;
		}
		
		// Create
		public Music create(Music user) {
			return repo.saveAndFlush(user);
		}
		
		// ReadAll
		public List<Music> getAll() {
			return repo.findAll();
		}
		
		// Read By ID
		public Music getById(long id) {
			return repo.findById(id).get();

		}
		
		// Read By FirstName
		public List<Music> getByFirstName(String name) {
			return repo.findBySongName(name);
		}
		
		// Update
		public Music update(long id, Music user) {
			// First, get the existing entry
			Music existing = repo.findById(id).get();
			
			// Then, updated the existing entry using the new object
			existing.setSongName(user.getSongName());
			existing.setArtist(user.getArtist());
			existing.setReleaseYear(user.getReleaseYear());
			
			return repo.saveAndFlush(existing);
		}

		// Delete
		public boolean delete(long id) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}	
	}

