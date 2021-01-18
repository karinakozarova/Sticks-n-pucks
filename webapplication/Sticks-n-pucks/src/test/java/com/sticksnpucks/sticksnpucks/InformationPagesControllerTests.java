package com.sticksnpucks.sticksnpucks;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({UsersController.class})
class InformationPagesControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new InformationPagesController()).build();
    }

    @Test
	void indexPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
	void dashboardPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/dashboard")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
	void chat_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/chat")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
	void rulesPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/hockey/rules")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}