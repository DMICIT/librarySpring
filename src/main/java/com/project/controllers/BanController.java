package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanController {

    @GetMapping(value="/ban-page")
    public String banPage(){
        return "ban-page";
    }

}
