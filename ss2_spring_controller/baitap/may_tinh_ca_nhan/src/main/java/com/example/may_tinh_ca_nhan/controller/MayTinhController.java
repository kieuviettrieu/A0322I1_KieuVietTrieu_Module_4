package com.example.may_tinh_ca_nhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MayTinhController {

    @GetMapping("/caculator")
    public String formCaculator()
    {
        return "index";
    }

    @PostMapping("/addition")
    public ModelAndView addition(@RequestParam int number1, @RequestParam int number2)
    {
        double result=number1+number2;
        ModelAndView modelAndView=new ModelAndView("index","result",result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("str","Addition");
        return modelAndView;
    }

    @PostMapping("/subtraction")
    public ModelAndView subtraction(@RequestParam int number1, @RequestParam int number2)
    {
        double result=number1-number2;
        ModelAndView modelAndView=new ModelAndView("index","result",result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("str","Subtraction");
        return modelAndView;
    }


    @PostMapping("/multiplication")
    public ModelAndView multiplication(@RequestParam int number1, @RequestParam int number2)
    {
        double result=number1*number2;
        ModelAndView modelAndView=new ModelAndView("index","result",result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("str","Multiplication");
        return modelAndView;
    }

    @PostMapping("/division")
    public ModelAndView division(@RequestParam int number1, @RequestParam int number2)
    {
        Double result;
        if(number2==0)
            result=null;
        else
            result= Double.valueOf(number1/number2);
        ModelAndView modelAndView=new ModelAndView("index","result",result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("str","Division");
        return modelAndView;
    }
}
