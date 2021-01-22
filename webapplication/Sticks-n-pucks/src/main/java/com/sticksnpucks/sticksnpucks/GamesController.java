package com.sticksnpucks.sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Requests to the API related to the Games
 */
@RestController
public class GamesController {
    /**
     * Get all the Games that are already in the database
     * @return json data as string
     * @throws IOException when the data could not be received
     */
    @GetMapping("/games")
    public String getAllGames() throws IOException {
        return ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/games");
    }
}