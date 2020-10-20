package com.sticksnpucks.Sticksnpucks;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({TeamsController.class})
public class TeamsControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    protected void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TeamsController()).build();
    }

    @Test
    protected void getAllTeams_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/teams")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}