package com.eCommerceWeb.eCommerceWeb.service.impl;

import com.eCommerceWeb.eCommerceWeb.entity.CartItem;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override

    public ShoppingCart addItemToCart (Product product, int quantity, User user){
        ShoppingCart cart=user.getShoppingCart();

        if(cart ==  null){
             cart= new ShoppingCart();
        }
        Set<CartItem> cartItems= cart.getCartItem();
        CartItem cartItem=null;
        if(cartItems ==  null){
            cartItems=new HashSet<>();
            if (cartItem == null){
                cartItem=new CartItem();
                cartItem.setProduct((product));
                cartItem.setTotalPrice(quantity * product.getPrice());
            }
        }
        return null;
    }


}
