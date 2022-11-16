package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import com.codegym.repository.IOderRepository;
import com.codegym.service.book.IBookService;
import com.codegym.service.oder.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOderService oderService;

    @GetMapping("/books")
    public ModelAndView listBook(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("book/list");
        modelAndView.addObject("books",bookService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/oders")
    public ModelAndView listOder(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("oder/list");
        modelAndView.addObject("oders",oderService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create-oder")
    public ModelAndView showCreate()
    {
        ModelAndView modelAndView=new ModelAndView("oder/create");
        modelAndView.addObject("oder",new Oder());
        modelAndView.addObject("books",bookService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-oder")
    public ModelAndView create(@ModelAttribute("oder") Oder oder)
    {
        ModelAndView modelAndView=new ModelAndView("oder/create");
        modelAndView.addObject("oder",new Oder());
        modelAndView.addObject("books",bookService.findAll());
        Book book= oder.getBook();
        int quantity=oder.getQuantity();
        if(book.getQuantity()-quantity<0)
        {
            modelAndView.addObject("message", "The maximum number of books that can be borrowed is "
                    +book.getQuantity());
            return modelAndView;
        }
        else
        {
            book.setQuantity(book.getQuantity()-quantity);
            bookService.save(book);
            oderService.save(oder);
            modelAndView.addObject("message", "New oder created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/return-oder/{id}")
    public String returnBook(@PathVariable Long id)
    {
        Oder oder=oderService.findById(id);

        Book book= oder.getBook();
        int quantity=oder.getQuantity();
        book.setQuantity(book.getQuantity()+quantity);

        bookService.save(book);
        oderService.delete(id);

        return "redirect:/oders";
    }


}
