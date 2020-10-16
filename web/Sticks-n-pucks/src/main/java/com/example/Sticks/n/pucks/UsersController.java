package com.example.Sticks.n.pucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class UsersController {
    private String submodule = "/account/";

    @DeleteMapping("/user")
    public int deleteAUser(@RequestParam(name = "id", required = true) int id) {
        return ApiController.deleteFromAPI(ApiController.GetBaseAPICallUrl() + submodule + id);
    }

    @PutMapping("/user/{id}")
    public int updateAUser(@PathVariable(name = "id", required = true) int id, @RequestParam(name = "name", required = true) String name) {
        return ApiController.putToAPI(ApiController.GetBaseAPICallUrl() + submodule + id + "/" + name);
    }

    @PostMapping("/user")
    public int createAUser(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "email", required = true) String email) {
        return ApiController.postToAPI(ApiController.GetBaseAPICallUrl() + submodule + name + "/" + email);
    }

    @GetMapping("/users")
    public String getAUser(@RequestParam(name = "id", required = false) Integer id) throws IOException {
        if (id == null) {
            return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + submodule);
        }
        return ApiController.GetAPIResult(ApiController.GetBaseAPICallUrl() + submodule + id);
    }
}