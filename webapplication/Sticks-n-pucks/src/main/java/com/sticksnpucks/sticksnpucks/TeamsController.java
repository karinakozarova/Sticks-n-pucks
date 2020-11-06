package com.sticksnpucks.sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Requests to the API related to the Teams
 */
@RestController
public class TeamsController {
    /**
     * Get all the Teams that are already in the database
     * @return json data as string
     * @throws IOException when the data could not be received
     */
    @GetMapping("/teams")
    public String getAllTeams() throws IOException {
        return ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/team");
    }
}