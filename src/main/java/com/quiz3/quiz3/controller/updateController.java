package com.quiz3.quiz3.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class updateController {
    @RequestMapping("/updateEarthquake")
    public String nearLocation(){
        return "updateEarthquake";
    }
}
