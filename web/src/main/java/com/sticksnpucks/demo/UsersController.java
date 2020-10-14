package com.sticksnpucks.demo;

import org.springframework.web.bind.annotation.*;
import java.io.*;

@RestController
public class UsersController {
    @DeleteMapping("/user")
    public int deleteAUser(@RequestParam(name = "id", required = true) int id) {
        return ApiController.DeleteFromAPI(ApiController.GetBaseAPICallUrl() + "/account/" + id);
    }

    @PutMapping("/user/{id}")
    public int updateAUser(@PathVariable(name = "id", required = true) int id, @RequestParam(name = "name", required = true) String name) {
        return ApiController.PutToAPI(ApiController.GetBaseAPICallUrl() + "/account/" + id + "/" + name);
    }

    @PostMapping("/user")
    public int createAUser(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "email", required = true) String email) {
        return ApiController.PostToAPI(ApiController.GetBaseAPICallUrl() + "/account/" + name + "/" + email);
    }

    @GetMapping("/users")
    public String getAUser(@RequestParam(name = "id", required = false) Integer id) throws IOException {
        if (id == null) {
            return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/account");
        }
        return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + "/account/" + id);
    }
}