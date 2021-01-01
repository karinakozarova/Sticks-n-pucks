package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@RestController
class TeamsActionsController {

    @GetMapping("/teams/all")
    ModelAndView listTeams() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("teams-listing.html", model);
    }

    @GetMapping("/teams/register")
    ModelAndView registerTeam() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("team-registration.html", model);
    }

    @GetMapping("/teams/view")
    ModelAndView viewTeam() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("view-team.html", model);
    }
}