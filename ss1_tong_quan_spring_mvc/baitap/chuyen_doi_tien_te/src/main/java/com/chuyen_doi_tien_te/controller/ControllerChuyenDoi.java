package com.chuyen_doi_tien_te.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerChuyenDoi {

    @RequestMapping("/chuyendoi")
    public ModelAndView showFormChuyenDoi()
    {
        ModelAndView modelAndView = new ModelAndView("chuyentiente");
        modelAndView.addObject("check",0);
        return modelAndView;
    }

    @PostMapping("/showtiente")
    public ModelAndView showTienTe(@RequestParam String usd, @RequestParam String tigia)
    {
        ModelAndView modelAndView = new ModelAndView("chuyentiente");
        float usdi=Float.parseFloat(usd);
        float tigiai=Float.parseFloat(tigia);
        double result=usdi*tigiai;
        modelAndView.addObject("check",1);
        modelAndView.addObject("result",result);
        modelAndView.addObject("usd",usd);
        modelAndView.addObject("tigia",tigia);
        return modelAndView;
    }
}
