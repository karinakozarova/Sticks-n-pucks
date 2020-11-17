package com.sticksnpucks.sticksnpucks;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
class HelloVueController {

    @GetMapping("/")
    ModelAndView showHelloPage() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Hello Vue!");
        model.put("chartData", Arrays.asList(7,6,5,4,3,2,1));
        return new ModelAndView("hello-vue.html", model);
    }

}
