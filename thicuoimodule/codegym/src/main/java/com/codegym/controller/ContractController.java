package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.model.MySearch;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Controller
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/contracts")
    public ModelAndView list()
    {
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("contracts",contractService.findAll());
        modelAndView.addObject("mySearch",new MySearch());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate()
    {
        List<String> loais=new ArrayList<>();
        loais.add("Dat");
        loais.add("Nha dat");

        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("loais",loais);
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save (@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("create");

        modelAndView.addObject("customers", customerService.findAll());

        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("contract",contract);
            return modelAndView;
        }


        contractService.save(contract);
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("message", "New contract created successfully");
        return modelAndView;
    }

//    @GetMapping("/detail/{id}")
//    public ModelAndView detail(@PathVariable Integer id) {
//        Contract contract= contractService.findById(id).get();
//        ModelAndView modelAndView = new ModelAndView("detail");
//        modelAndView.addObject("contract",contract);
//        return modelAndView;
//    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Contract contract= contractService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("contract",contract);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("contract") Contract contract) {

        contractService.remove(contract.getId());
        return "redirect:/contracts";
    }

    @PostMapping("/search")
    public ModelAndView listSearch(@ModelAttribute("search") MySearch mySearch)
    {
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("mySearch",mySearch);
        if(mySearch.getName().length()>0)
            modelAndView.addObject("contracts",contractService.findAllByName("%"+mySearch.getName()+"%"));
        else
            modelAndView.addObject("contracts",contractService.findAllByContractType(mySearch.getContractType()));
        return modelAndView;
    }

}
