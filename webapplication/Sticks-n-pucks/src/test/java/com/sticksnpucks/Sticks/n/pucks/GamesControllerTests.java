package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GamesControllerTests {

	@Autowired
	private GamesController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void AllGamesCanBeRetrieved() throws IOException {
		assertThat(!controller.getAllGames().isEmpty());
	}
}
