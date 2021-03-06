package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class InformationPagesController {
    @GetMapping("/")
    ModelAndView indexPage() {
        return new ModelAndView("index.html",  new HashMap<>());
    }

    @GetMapping("/dashboard")
    ModelAndView dashboardPage() {
        return new ModelAndView("dashboard.html",  new HashMap<>());
    }

    @GetMapping("/chat")
    ModelAndView chatPage() {
        return new ModelAndView("chat.html",  new HashMap<>());
    }

    @GetMapping("/hockey/rules")
    ModelAndView rulesPage() {
        return new ModelAndView("rules.html",  new HashMap<>());
    }
}
