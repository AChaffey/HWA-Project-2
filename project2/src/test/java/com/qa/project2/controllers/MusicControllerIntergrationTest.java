package com.qa.project2.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project2.domain.Music;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql", "classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class MusicControllerIntergrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Music input = new Music("Baby", "Justin Bieber", "2010");
		String inputAsJSON = mapper.writeValueAsString(input);

		Music output = new Music(2L, "Baby", "Justin Bieber", "2010");
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(post("/music/create").contentType(MediaType.APPLICATION_JSON).content(inputAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(outputAsJSON));

	}

	@Test
	public void getAllTest() throws Exception {
		Music user = new Music(1L, "Baby", "Justin Bieber", "2010");
		List<Music> output = new ArrayList<>();
		output.add(user);

		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/music/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		Music entry = new Music(1L, "Baby", "Justin Bieber", "2010");
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		mvc.perform(get("/music/getById/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}

	@Test
	public void updateTest() throws Exception {
		Music entry = new Music("Baby", "Justin Bieber", "2010");
		Music result = new Music(1L, "Baby", "Justin Bieber", "2010");

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(put("/music/update/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isAccepted()).andExpect(content().json(resultAsJSON));
	}

	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/music/delete/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
}
