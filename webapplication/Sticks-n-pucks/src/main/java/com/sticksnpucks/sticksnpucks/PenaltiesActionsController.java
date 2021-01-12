package com.sticksnpucks.sticksnpucks;

import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.io.*;

/**
 * Requests to the API related to the Games
 */
@RestController
public class PenaltiesActionsController {
    /**
     * @return html page listing all the penalties
     */
    @GetMapping("/penalties/all")
    ModelAndView getAllPenalties(ModelMap model) throws IOException {
        String penalties = ApiController.getAPIResult(ApiController.getBaseAPICallUrl() + "/penalty");
        model.addAttribute("penalties", penalties);
        return new ModelAndView("list-penalties.html", model);
    }
}