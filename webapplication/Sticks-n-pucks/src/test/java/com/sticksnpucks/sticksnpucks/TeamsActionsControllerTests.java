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
class TeamsActionsControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TeamsActionsController()).build();
    }

    @Test
	void getAllTeams_shouldReturn200_inAllConditions() throws Exception {
        mockMvc.perform(
                get("/teams/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getSpecificTeam_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/teams/view"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getRoster_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/teams/roster"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void addNewTeam_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/teams/register")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}