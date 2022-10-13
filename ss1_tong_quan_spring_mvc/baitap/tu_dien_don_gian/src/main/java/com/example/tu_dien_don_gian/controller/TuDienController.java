package com.example.tu_dien_don_gian.controller;

import com.example.tu_dien_don_gian.service.TuDien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TuDienController {

    @GetMapping("/showform")
    public String showForm()
    {
        return "tudien";
    }

    @PostMapping("/showform")
    public ModelAndView showSearch(@RequestParam String keytudien)
    {
        String result=TuDien.getDictionary(keytudien);
        ModelAndView modelAndView=new ModelAndView("tudien");
        modelAndView.addObject("result",result);
        modelAndView.addObject("check",1);
        modelAndView.addObject("keytudien",keytudien);
        return modelAndView;
    }
}
