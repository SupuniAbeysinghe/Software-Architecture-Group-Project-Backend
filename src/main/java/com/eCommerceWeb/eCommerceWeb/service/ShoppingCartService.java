package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import com.eCommerceWeb.eCommerceWeb.entity.User;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(Product product, int quantity, User user);
}
