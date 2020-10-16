package com.example.Sticks.n.pucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class PenaltiesController {
    @GetMapping("/penalties")
    public String getAllPenaltiesOrSpecificPenalty(@RequestParam(name="name", required=false) String name) throws IOException {
        try {
            return name.isBlank() ?
                    ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/penalty"):
                    ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/penalty/" + name);
        } catch (NullPointerException a){
            return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/penalty");
        }
    }
}