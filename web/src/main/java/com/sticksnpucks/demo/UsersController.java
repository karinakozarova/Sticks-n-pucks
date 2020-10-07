package com.sticksnpucks.demo;

import org.springframework.web.bind.annotation.*;
import java.io.*;

@RestController
public class UsersController {
    @DeleteMapping("/user")
     public int deleteAUser(@RequestParam(name="id", required=true) int id) {
        return ApiController.DeleteFromAPI(ApiController.GetBaseAPICallUrl() + "/account/" + id);
    }

    @PutMapping("/user")
    public int updateAUser(@RequestParam(name="id", required=true) int id, @RequestParam(name="name", required=true) String name) {
        return ApiController.PutToAPI(ApiController.GetBaseAPICallUrl() + "/account/" + id + "/" + name);
    }

    @PutMapping("/user")
    public int updateAUser(@RequestParam(name="name", required=true) String name) {
        return ApiController.PutToAPI(ApiController.GetBaseAPICallUrl() + "/account/" + "/" + name);
    }
//    @GetMapping("/users")
//    public String getAllUsers() throws IOException {
//        return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/account");
//    }

    @GetMapping("/users")
    public String getAUser(@RequestParam(name="id", required=true) int id) throws IOException {
        return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/account/" + id);
    }
}