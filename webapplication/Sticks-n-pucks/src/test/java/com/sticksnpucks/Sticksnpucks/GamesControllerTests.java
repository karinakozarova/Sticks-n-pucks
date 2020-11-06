package com.sticksnpucks.Sticksnpucks;

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
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void AllGamesCanBeRetrieved() throws IOException {
        assertTrue(!controller.getAllGames().isEmpty());
    }
}
