package com.sticksnpucks.Sticks.n.pucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class PenaltiesController {
    @GetMapping("/penalties")
    public String getAllPenaltiesOrSpecificPenalty(@RequestParam(name="name", required=false) String name) throws IOException {
        try {
            return name.isBlank() ?
                    ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty"):
                    ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty/" + name);
        } catch (NullPointerException a){
            return ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty");
        }
    }
}