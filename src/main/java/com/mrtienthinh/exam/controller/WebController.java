package com.mrtienthinh.exam.controller;

import com.mrtienthinh.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/product")
    public String viewProduct() {
        return "product";
    }

    @GetMapping("/product/new")
    public String viewCreateProduct() {
        return "create";
    }

    @GetMapping("/product/sell")
    public String viewSellProduct() {
        return "sell";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }


}
