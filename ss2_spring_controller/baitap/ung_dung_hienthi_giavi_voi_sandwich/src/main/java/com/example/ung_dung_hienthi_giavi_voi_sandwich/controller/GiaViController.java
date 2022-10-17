package com.example.ung_dung_hienthi_giavi_voi_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GiaViController {

    @PostMapping("/save")
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView=new ModelAndView("index","condiment",condiment);
        return modelAndView;
    }

    @GetMapping("/input")
    public String formInput()
    {
        return "input-giavi";
    }
}
