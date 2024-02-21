package com.eCommerceWeb.eCommerceWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("admin/categories")
    public String getCat(){
        return "categories";
    }
}
