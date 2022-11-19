package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.model.ProductPay;
import com.codegym.service.IProductPayService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductPayService productPayService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/shop-pay")
    public ModelAndView showShopPay() {
        ModelAndView modelAndView = new ModelAndView("/shop-pay");
        modelAndView.addObject("productPays", productPayService.findAll());
        return modelAndView;
    }

    @GetMapping("/shop/product/{id}")
    public ModelAndView detailProduct(@PathVariable Long id)
    {
        Product product=productService.findById(id).get();
        ModelAndView modelAndView=new ModelAndView("/detail","product",product);
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/reduce/{id}")
    public String reduceToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.reduceProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.deleteProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.deleteProduct(productOptional.get());
        return "redirect:/shop";
    }

    @PostMapping("/shopping-cart/pay")
    public String shopPay(@ModelAttribute Cart cart)
    {
        List<ProductPay> list=new ArrayList<>();
        for (Map.Entry<Product,Integer> entry:cart.getProducts().entrySet())
        {
            Product product= entry.getKey();
            int quantity=entry.getValue();

            ProductPay productPay=new ProductPay(product.getName(),product.getImage(),product.getPrice()
                    ,quantity,product.getDescription());
            list.add(productPay);
        }
        productPayService.saveList(list);
        cart.clear();
        return "redirect:/shopping-cart";
    }

    @PostMapping("/shopping-cart/payone")
    public String shopPayOne(@ModelAttribute("product") Product product_)
    {
        int quantity=1;
        Product product=productService.findById(product_.getId()).get();
        ProductPay productPay=new ProductPay(product.getName(),product.getImage(),product.getPrice()
                ,quantity,product.getDescription());

        productPayService.save(productPay);
        return "redirect:/shop";
    }


}