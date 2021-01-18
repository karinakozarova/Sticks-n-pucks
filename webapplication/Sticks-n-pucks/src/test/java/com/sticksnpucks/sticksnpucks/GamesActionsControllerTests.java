package com.sticksnpucks.sticksnpucks;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({UsersController.class})
class GamesActionsControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GamesActionsController()).build();
    }

    @Test
	void getAllGames_shouldReturn200_inAllConditions() throws Exception {
        mockMvc.perform(
                get("/games/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
	void addNewGame_shouldReturn200_inAllConditions() throws Exception {
        mockMvc.perform(
                get("/games/add")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getSpecificGame_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/games/view")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}