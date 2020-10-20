package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({PenaltiesController.class})
public class PenaltiesControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    protected void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PenaltiesController()).build();
    }

    @Test
    protected void getGreeting_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/penalties")
                        .param("name", "Roughing")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(3)));
    }

    @Test
    protected void getAllGreetings_shouldReturn200() throws Exception {
        mockMvc.perform(
                get("/penalties")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}