package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
class PlayersActionsController {
    @GetMapping("/players/all")
    ModelAndView listPlayers() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("players-listing.html", model);
    }

    @GetMapping("/players/free-agents/all")
    ModelAndView listFreeAgents() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("free-agents-listing.html", model);
    }

    @GetMapping("/players/view")
    ModelAndView viewPlayer() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("view-player.html", model);
    }
}