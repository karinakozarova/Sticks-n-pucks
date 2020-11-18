package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class InformationPagesController {
    @GetMapping("/")
    ModelAndView listTeams() {
        return new ModelAndView("index.html",  new HashMap<>());
    }
}
