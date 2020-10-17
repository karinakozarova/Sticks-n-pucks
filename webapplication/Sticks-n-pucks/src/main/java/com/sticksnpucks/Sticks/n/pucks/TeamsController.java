package com.sticksnpucks.Sticks.n.pucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class TeamsController {
    @GetMapping("/teams")
    public String getAllTeams() throws IOException {
        return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/team");
    }
}