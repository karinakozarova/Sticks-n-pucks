package com.sticksnpucks.Sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Requests to the API related to the Accounts of the users
 */
@RestController
public class UsersController {
    private String submodule = "/account/";

    /**
     * Delete a user
     * @param id id of the user
     * @return status code
     */
    @DeleteMapping("/user")
    public int deleteAUser(@RequestParam(name = "id", required = true) int id) {
        return ApiController.deleteFromAPI(ApiController.getBaseAPICallUrl() + submodule + id);
    }

    /**
     * Edit a user
     * @param id id of the user
     * @param name name of the user
     * @return status code
     */
    @PutMapping("/user/{id}")
    public int updateAUser(@PathVariable(name = "id", required = true) int id, @RequestParam(name = "name", required = true) String name) {
        return ApiController.putToAPI(ApiController.getBaseAPICallUrl() + submodule + id + "/" + name);
    }

    /**
     * Create a new user
     * @param name name of the user
     * @param email email of the user
     * @return status code
     */
    @PostMapping("/user")
    public int createAUser(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "email", required = true) String email) {
        return ApiController.postToAPI(ApiController.getBaseAPICallUrl() + submodule + name + "/" + email);
    }

    /**
     * Get all the Users that are already in the database or a specific user
     * @param id id of the user
     * @return json data as string
     * @throws IOException when the data could not be received
     */
    @GetMapping("/users")
    public String getAUser(@RequestParam(name = "id", required = false) Integer id) throws IOException {
        return id == null
                ? ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + submodule)
                : ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + submodule + id);
    }
}