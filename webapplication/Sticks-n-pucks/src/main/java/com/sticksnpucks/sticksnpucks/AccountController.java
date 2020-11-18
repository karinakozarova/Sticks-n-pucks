package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
class AccountController {
    @GetMapping("/login")
    ModelAndView login() {
        return new ModelAndView("login.html", (Map<String, ?>) null);
    }

    @GetMapping("/register")
    ModelAndView register() {
        // TODO
        return new ModelAndView("login.html", (Map<String, ?>) null);
    }

    @GetMapping("/loggedOut")
    ModelAndView loggedOut() {
        // TODO
        return new ModelAndView("loggedOut.html", (Map<String, ?>) null);
    }
}