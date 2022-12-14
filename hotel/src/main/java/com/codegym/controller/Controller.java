package com.codegym.controller;


import com.codegym.model.Contract;
import com.codegym.model.Hotel;
import com.codegym.model.MyDate;
import com.codegym.service.IContractService;
import com.codegym.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;


@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/contracts")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("list");
        String nameSearch="";
//        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("myDate",new MyDate());
        modelAndView.addObject("contracts",contractService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id)
    {
        ModelAndView modelAndView=new ModelAndView("edit");
        Contract contract=contractService.findById(id).get();

        modelAndView.addObject("contract",contract);
        modelAndView.addObject("hotels",hotelService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit (@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("hotels",hotelService.findAll());

        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("contract",contract);
            return modelAndView;
        }
        Contract contractOld=contractService.findById(contract.getId()).get();
        Hotel hotel0;
        for (Hotel hotel:contractOld.getHotels())
        {
            hotel0=hotelService.findById(hotel.getId()).get();
            hotel0.setStatus(true);
        }

        Hotel hotel1;
        for (Hotel hotel:contract.getHotels())
        {
            hotel1=hotelService.findById(hotel.getId()).get();
            hotel1.setStatus(false);
            hotelService.save(hotel1);
        }
        contractService.save(contract);
        modelAndView.addObject("message", "Edit contract successfully");
        modelAndView.addObject("contract",contract);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate()
    {
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("hotels",hotelService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save (@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("create");


        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("contract",contract);
            return modelAndView;
        }

        Hotel hotel1;
        for (Hotel hotel:contract.getHotels())
        {
            hotel1=hotelService.findById(hotel.getId()).get();
            hotel1.setStatus(false);
            hotelService.save(hotel1);
        }
        contractService.save(contract);
        modelAndView.addObject("hotels",hotelService.findAll());
        modelAndView.addObject("message", "New contract created successfully");
        modelAndView.addObject("contract",new Contract());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        Contract contract=contractService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("contract",contract);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Contract contract=contractService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("contract",contract);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("contract") Contract contract) {

        ModelAndView modelAndView = new ModelAndView("delete");
        Contract contract1=contractService.findById(contract.getId()).get();

        Hotel hotel1;
        for (Hotel hotel:contract1.getHotels())
        {
            hotel1=hotelService.findById(hotel.getId()).get();
            hotel1.setStatus(true);
            hotelService.save(hotel1);
        }
        contractService.remove(contract.getId());
        return "redirect:/contracts";
    }

    @PostMapping("/search")
    public ModelAndView listSearchNameEmployee(@ModelAttribute("myDate") MyDate myDate,
                                               @PageableDefault(value = 5) Pageable pageable)
    {
        System.out.println(myDate.getFirstDay()+"--"+myDate.getLastDay());
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("contracts",contractService.findAllByFirstLastDay(myDate.getFirstDay(),myDate.getLastDay(),pageable));
//        modelAndView.addObject("nameSearch","");
        modelAndView.addObject("myDate",myDate);
        return modelAndView;
    }


}
