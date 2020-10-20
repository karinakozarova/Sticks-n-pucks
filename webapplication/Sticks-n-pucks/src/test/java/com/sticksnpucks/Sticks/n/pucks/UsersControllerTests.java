package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({UsersController.class})
public class UsersControllerTests {
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UsersController()).build();
    }

    @Test
    public void getAllUsers_shouldReturn200_whenNameIsValid() throws Exception {
        mockMvc.perform(
                get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getUser_shouldReturn200_WhenIdIsValid() throws Exception {
        mockMvc.perform(
                get("/users")
                        .param("id", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteUser_ShouldReturn200_WhenIdIsValid() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/user")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser_ShouldReturn404_WhenUrlIsNotValid() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/unknownurlunittests")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    public void putUser_ShouldReturn200_WhenIdIsValid() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/user/1")
                .param("name", "Added by unit test"))
                .andExpect(status().isOk());
    }

    @Test
    public void postUser_ShouldReturn200_WhenIdIsValid() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .param("name", "Added by unit test")
                .param("email", "unit@test.com"))
                .andExpect(status().isOk());
    }
}