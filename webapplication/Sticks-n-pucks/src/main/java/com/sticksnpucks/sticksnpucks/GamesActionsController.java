package com.sticksnpucks.sticksnpucks;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.io.*;
import java.util.*;

/**
 * Requests to the API related to the Games
 */
@RestController
public class GamesActionsController {
    /**
     * Get all the Games that are already in the database
     * @return json data as string
     * @throws IOException when the data could not be received
     */
    @GetMapping("/games/all")
    ModelAndView getAllGames() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("games-listing.html", model);
    }

    @GetMapping("/games/add")
    ModelAndView addNewGame() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("add-game.html", model);
    }

    @GetMapping("/games/view")
    ModelAndView viewGame() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("view-game.html", model);
    }
}