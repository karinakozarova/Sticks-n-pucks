package com.sticksnpucks.Sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class PenaltiesController {
    @GetMapping("/penalties")
    public String getAllPenaltiesOrSpecificPenalty(@RequestParam(name="name", required=false) String name) throws IOException {
        return name == null ?
            ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty"):
            ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty/" + name);
    }
}