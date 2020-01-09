package com.littlepage.airplaneticketsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("personalInfo")
public class PersonalInfo {

    @RequestMapping("infoPage")
    public String personalInfo(){
        return "personalInfo";
    }
}
