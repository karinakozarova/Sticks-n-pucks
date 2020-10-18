package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PenaltiesControllerTests {

	@Autowired
	private PenaltiesController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
