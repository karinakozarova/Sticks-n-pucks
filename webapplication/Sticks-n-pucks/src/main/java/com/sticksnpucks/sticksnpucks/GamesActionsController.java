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
     * @return html page listing all the games
     */
    @GetMapping("/games/all")
    ModelAndView getAllGames() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("games-listing.html", model);
    }

    /**
     * @return html page for adding a new game
     */
    @GetMapping("/games/add")
    ModelAndView addNewGame() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("add-game.html", model);
    }

    /**
     * @return html page visualising a single games
     */
    @GetMapping("/games/view")
    ModelAndView viewGame() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("view-game.html", model);
    }
}