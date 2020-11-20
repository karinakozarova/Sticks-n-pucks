package com.sticksnpucks.sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Requests to the API related to the Penalties
 */
@RestController
public class PenaltiesController {
    /**
     * Get all the Penalties that are already in the database
     *
     * @param name name of the penalty
     * @return json data as string
     * @throws IOException when the data could not be received
     */
    @GetMapping("/penalties")
    public String getAllPenaltiesOrSpecificPenalty(@RequestParam(name = "name", required = false) String name) throws IOException {
        return name == null ?
                ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty") :
                ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty/" + name);
    }
}