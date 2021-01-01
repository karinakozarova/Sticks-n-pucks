package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@RestController
class AccountController {
    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("loginData", new LoginFormObject());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute LoginFormObject loginFormObject, Model model) {
        model.addAttribute("loginData", loginFormObject);
        return "loggedOut";
    }

    @GetMapping("/register")
    ModelAndView register() {
        return new ModelAndView("chooseSignupType", (Map<String, ?>) null);
    }

    @GetMapping("/manager/register")
    ModelAndView registerManager() {
        return new ModelAndView("managerRegistration", (Map<String, ?>) null);
    }

    @GetMapping("/player/register")
    ModelAndView registerPlayer() {
        return new ModelAndView("playerRegistration", (Map<String, ?>) null);
    }

    @GetMapping("/loggedOut")
    ModelAndView loggedOut() {
        return new ModelAndView("loggedOut", (Map<String, ?>) null);
    }
}