package com.sticksnpucks.Sticks.n.pucks;

import javafx.beans.binding.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GamesControllerTests {

	@Autowired
	private GamesController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
