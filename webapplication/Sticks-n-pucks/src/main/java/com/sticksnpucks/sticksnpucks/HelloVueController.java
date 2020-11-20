package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
class HelloVueController {

    @GetMapping("/vuedemo")
    ModelAndView showHelloPage() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Comes from controller!");
        return new ModelAndView("hello-vue.html", model);
    }

}