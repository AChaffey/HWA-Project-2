package com.qa.project2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project2.domain.Music;
import com.qa.project2.services.MusicService;

@RestController
	@CrossOrigin
	@RequestMapping("/music")
public class MusicController {
	
		
		private MusicService service;
		
		public MusicController(MusicService service) {
			this.service = service;
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<Music>> getAll() {
			return new ResponseEntity<List<Music>>(this.service.getAll(), HttpStatus.OK);
		}
		
		
		@GetMapping("/getById/{id}")
		public ResponseEntity<Music> getById(@PathVariable long id) {
			return new ResponseEntity<Music>(service.getById(id), HttpStatus.OK);
		}
		
		
		// Create -> Post Request - @PostMapping
		@PostMapping("/create")
		public ResponseEntity<Music> create(@RequestBody Music user) {
			System.out.print(user);
			return new ResponseEntity<Music>(service.create(user), HttpStatus.CREATED);
		}
		
		// Update -> Put/Patch Request - @PutMapping
		@PutMapping("/update/{id}")
		public ResponseEntity<Music> update(@PathVariable long id, @RequestBody Music user) {
			return new ResponseEntity<Music>(service.update(id, user), HttpStatus.ACCEPTED);
		}

//		 Delete -> Delete Request - @DeleteMapping
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> delete(@PathVariable long id) {
			return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


