package com.qa.project2.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.project2.domain.Music;
import com.qa.project2.repo.MusicRepo;
import com.qa.project2.services.MusicService;

@SpringBootTest
	@ActiveProfiles("test")
public class MusicServiceTest {
	
	

		@Autowired
		private MusicService service;

		@MockBean
		private MusicRepo repo;

		// Create Test
		@Test
		public void createTest() {
			Music input = new Music("Baby", "Justin Beiber", "2010");
			Music output = new Music(1L,"Baby", "Justin Beiber", "2010");
			
			Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
			
			assertEquals(output, service.create(input));
			
			Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
		}

		// ReadAll Test
		@Test
		public void getAllTest() {
			// Creating any expected output and inputs if necessary
			List<Music> output = new ArrayList<>();
			output.add(new Music(1L,"Baby", "Justin Beiber", "2010"));
			
			// Mocking the dependency (repo)
			Mockito.when(repo.findAll()).thenReturn(output);
			
			// Asserting the actual test method's output
			assertEquals(output, service.getAll());
			
			// Verifying the number of times a mock method ran - Not Required
			Mockito.verify(repo, Mockito.times(1)).findAll(); 
		}

		// Read By ID Test
		@Test
		public void getByIdTest() {
			// Creating any expected output and inputs if necessary
			Music output = new Music(1L, "Baby", "Justin Beiber", "2010");
			Optional<Music> optionalOutput = Optional.of(output);
			
			// Mocking the dependency (repo)
			Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
			
			// Asserting the actual test method's output
			assertEquals(output, service.getById(1L));
			
			// Verifying the number of times a mock method ran - Not Required
			Mockito.verify(repo, Mockito.times(1)).findById(1L);
		}

		// Update Test
		@Test
		public void updateTest() {
			// Creating any expected output and inputs if necessary
			Music input = new Music("Baby", "Justin Beiber", "2010");
			Optional<Music> existing = Optional.of(new Music(1L, "Baby", "Justin Beiber", "2010"));
			Music output = new Music(1L, "Baby", "Justin Beiber", "2010");
			
			// Mocking the dependency (repo)
			Mockito.when(repo.findById(1L)).thenReturn(existing);
			Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
			
			// Asserting the actual test method's output
			assertEquals(output, service.update(1L, input));
			
			// Verifying the number of times a mock method ran - Not Required
			Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
			Mockito.verify(repo, Mockito.times(1)).findById(1L);
		}

		
		@Disabled
		@Test
		public void getBysongNameTest() {

		}
		
		
		@Disabled
		@Test
		public void deleteTest() {

		}
	}

