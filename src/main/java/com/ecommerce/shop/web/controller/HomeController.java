package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@Slf4j
public class HomeController {

    @Autowired
    ProductService productServiceImpl;

//    @GetMapping("/index")
    @GetMapping(value = {"/","/index"})
    public String getIndex(Model model){
        List<Product> productList = productServiceImpl.findAll();
        log.info("product list items are -----> {}", productList);
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("/products/{id}")
    public String getProduct(Model model, @PathVariable Long id){
        Product product = productServiceImpl.findById(id);
        log.info("product list items are -----> {}", product);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/services")
    public String getServices(){
        return "services";
    }

    @GetMapping("/single/{id}")
    public String getSingle(Model model, @PathVariable Long id){
        Product product = productServiceImpl.findById(id);
        log.info("product list items are -----> {}", product);
        model.addAttribute("product", product);
        return "single";
    }

}
