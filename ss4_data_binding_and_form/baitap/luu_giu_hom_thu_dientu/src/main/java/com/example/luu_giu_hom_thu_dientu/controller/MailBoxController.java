package com.example.luu_giu_hom_thu_dientu.controller;

import com.example.luu_giu_hom_thu_dientu.model.MailBox;
import com.example.luu_giu_hom_thu_dientu.service.IMailBoxService;
import com.example.luu_giu_hom_thu_dientu.service.MailBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MailBoxController {
    private static final String[] listLanguage={"English","Vietnamese","Japanese","Chinese"};
    private static final int[] listSize={5,10,15,25,50,100};
    private static MailBoxService mailBoxService=new MailBoxService();

    @GetMapping("/form")
    public ModelAndView form()
    {
        ModelAndView modelAndView=new ModelAndView("index","mailBox",mailBoxService.getMailBox());
        modelAndView.addObject("listLang",listLanguage);
        modelAndView.addObject("listSize",listSize);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MailBox mailBox)
    {
        mailBoxService.update(mailBox);
        ModelAndView modelAndView=new ModelAndView("index","mailBox",mailBoxService.getMailBox());
        modelAndView.addObject("listLang",listLanguage);
        modelAndView.addObject("listSize",listSize);
        return modelAndView;
    }
}
