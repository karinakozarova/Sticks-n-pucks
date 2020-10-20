package com.sticksnpucks.Sticks.n.pucks;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.*;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.*;
import java.net.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBaseAPICallUrlReturnsAString() throws MalformedURLException, URISyntaxException {
        String url = ApiController.getBaseAPICallUrl();
        assertFalse(Strings.isNullOrEmpty(String.valueOf(new URL(url).toURI())));
    }

    @Test
    public void postAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/post/json";
        int result = ApiController.postToAPI(urlPath);
        assertEquals(200, result);
    }

    @Test
    public void postAPIResult_ReturnsSuccessAmaNe() throws IOException {
        String urlPath = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka";
        int result = ApiController.postToAPI(urlPath);
        assertEquals(411, result);
    }

    @Test
    public void putAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/put/json";
        int result = ApiController.putToAPI(urlPath);
        assertEquals(200, result);
    }

    @Test
    public void deleteAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/delete/json";
        int result = ApiController.deleteFromAPI(urlPath);
        assertEquals(200, result);
    }
}