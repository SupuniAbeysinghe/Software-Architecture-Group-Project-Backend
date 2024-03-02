package com.eCommerceWeb.eCommerceWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        return "cart";
    }
}
