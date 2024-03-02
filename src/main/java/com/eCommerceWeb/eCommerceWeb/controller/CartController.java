package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.service.ProductService;
import com.eCommerceWeb.eCommerceWeb.service.ShoppingCartService;
import com.eCommerceWeb.eCommerceWeb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserService userService;

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart")
    public String cart(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        String email = principal.getName();
        // Retrieve the user by email using the UserRepository
        User user = userRepository.findUserByEmail(email);
        ShoppingCart shoppingCart = user.getShoppingCart();
        if (shoppingCart == null) {
            model.addAttribute("check", "No item in your cart");
        }
        model.addAttribute("shoppingCart", shoppingCart);
        return "cart";
    }
//        String email = principal.getName();
//        Optional<User> userOptional = userService.getUser(email);

//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            ShoppingCart shoppingCart = user.getShoppingCart();
//            if (shoppingCart == null) {
//                model.addAttribute("check", "No item in your cart");
//            }
//            model.addAttribute("shoppingCart", shoppingCart);
//            return "cart";
//
//        } else {
//            return "redirect:/login";
//        }

        @PostMapping("/add-to-cart")
        public String addItemToCart(
                @RequestParam("cid") int product_id,
                @RequestParam(value = "quantity",required = false,defaultValue ="1" ) int quantity,
                Principal principal,
                HttpServletRequest request){

        if(principal== null){
            return "redirect:/login";
        }
            // Fetch the product by ID using the ProductRepository
            Product product = productRepository.findById(product_id);
            String username=  principal.getName();
            User user =userRepository.findUserByEmail(username);

            ShoppingCart cart=cartService.addItemToCart(product,quantity,user);
            return "redirect:" +request.getHeader("Referer");
        }

}
