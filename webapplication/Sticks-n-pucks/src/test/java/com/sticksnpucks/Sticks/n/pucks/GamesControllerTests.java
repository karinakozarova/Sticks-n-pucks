package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GamesControllerTests {

    @Autowired
    protected GamesController controller;

    @Test
    protected void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    protected void AllGamesCanBeRetrieved() throws IOException {
        assertTrue(!controller.getAllGames().isEmpty());
    }
}
