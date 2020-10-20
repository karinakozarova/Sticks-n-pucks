package com.sticksnpucks.Sticks.n.pucks;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	public void getAPIResult_ReturnsString_WithResult() throws IOException {
		String urlPath = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka",
				url = ApiController.getAPIResult(urlPath);
		assertFalse(Strings.isNullOrEmpty(url));
		assertTrue(url.contains("Vodka is a distilled beverage composed primarily of water and ethanol"));
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
//	@Test
//	public void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello, World")));
//	}
}