package com.sticksnpucks.sticksnpucks;

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
class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBaseAPICallUrlReturnsAString() throws MalformedURLException, URISyntaxException {
        String url = ApiController.getBaseAPICallUrl();

        boolean isUrlEmpty = Strings.isNullOrEmpty(String.valueOf(new URL(url).toURI()));

        assertFalse(isUrlEmpty);
    }

    @Test
    void postAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/post/json";

        int result = ApiController.postToAPI(urlPath);

        assertEquals(200, result);
    }

    @Test
    void postAPIResult_ReturnsSuccessAmaNe() throws IOException {
        String urlPath = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka";

        int result = ApiController.postToAPI(urlPath);

        assertEquals(411, result);
    }

    @Test
    void putAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/put/json";

        int result = ApiController.putToAPI(urlPath);

        assertEquals(200, result);
    }

    @Test
    void deleteAPIResult_ReturnsSuccess() throws IOException {
        String urlPath = "https://reqbin.com/sample/delete/json";

        int result = ApiController.deleteFromAPI(urlPath);

        assertEquals(200, result);
    }
}