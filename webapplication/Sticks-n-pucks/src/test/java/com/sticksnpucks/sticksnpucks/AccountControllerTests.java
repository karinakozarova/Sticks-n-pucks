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
class AccountControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();
    }

    @Test
	void registerPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/register")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void managerRegisterPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/manager/register")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void playerRegisterPage_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/player/register")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void login_shouldReturn200_inAllCases() throws Exception {
        mockMvc.perform(
                get("/login")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void loginPost_shouldReturn200_withNoData() throws Exception {
        mockMvc.perform(
                post("/login")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}