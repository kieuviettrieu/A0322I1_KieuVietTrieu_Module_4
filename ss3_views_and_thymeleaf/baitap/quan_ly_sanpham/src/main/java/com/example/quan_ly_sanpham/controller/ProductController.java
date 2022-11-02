package com.example.quan_ly_sanpham.controller;


import com.example.quan_ly_sanpham.model.Product;
import com.example.quan_ly_sanpham.service.IProductService;
import com.example.quan_ly_sanpham.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam String nameProduct)
    {
        List<Product> productList=new ArrayList<>();
        for (Product product: productService.findAll()) {
            if(product.getName().toLowerCase().indexOf(nameProduct.toLowerCase())>=0)
            {
                productList.add(product);
            }
        }
        model.addAttribute("products",productList);
        model.addAttribute("nameSearch",nameProduct);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
