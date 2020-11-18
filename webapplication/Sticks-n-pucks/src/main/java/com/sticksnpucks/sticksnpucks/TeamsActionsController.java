package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
class TeamsActionsController {

    @GetMapping("/teamsListing")
    ModelAndView listTeams() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Hello Vue!");
        return new ModelAndView("teams-listing.html", model);
    }

}