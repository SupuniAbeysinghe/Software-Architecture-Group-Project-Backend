package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.service.ShoppingCartService;
import com.eCommerceWeb.eCommerceWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping("/cart")
    public String cart(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }

        String email=principal.getName();
        User user = userRepository.findByEmail(email);
        ShoppingCart shoppingCart=user.getShoppingCart();
        model.addAttribute("shoppingCart",shoppingCart);
        return "cart";
    }
}
