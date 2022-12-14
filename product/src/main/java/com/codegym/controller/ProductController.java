package com.codegym.controller;


import com.codegym.model.MyDate;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@org.springframework.stereotype.Controller
@RequestMapping
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/products")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("myDate",new MyDate());
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id)
    {
        ModelAndView modelAndView=new ModelAndView("edit");
        Product product= productService.findById(id).get();

        modelAndView.addObject("product",product);
        modelAndView.addObject("categorys", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit (@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("categorys", categoryService.findAll());

        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("product",product);
            return modelAndView;
        }

        productService.save(product);
        modelAndView.addObject("message", "Edit product successfully");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate()
    {
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        modelAndView.addObject("categorys", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save (@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("categorys", categoryService.findAll());

        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("product",product);
            return modelAndView;
        }


        productService.save(product);
        modelAndView.addObject("message", "New product created successfully");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        Product product= productService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Product product= productService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") Product product) {

        productService.remove(product.getId());
        return "redirect:/products";
    }

    @PostMapping("/search")
    public ModelAndView listSearch(@ModelAttribute("myDate") MyDate myDate,
                                               @PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("products", productService.findAllByFirstLastDay(myDate.getFirstDay(),myDate.getLastDay(),pageable));
//        modelAndView.addObject("nameSearch","");
        modelAndView.addObject("myDate",myDate);
        return modelAndView;
    }


}
