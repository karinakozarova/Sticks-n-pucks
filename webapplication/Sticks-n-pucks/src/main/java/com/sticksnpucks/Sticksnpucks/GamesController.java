package com.sticksnpucks.Sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class GamesController {
    @GetMapping("/games")
    public String getAllGames() throws IOException {
        return ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/games");
    }
}