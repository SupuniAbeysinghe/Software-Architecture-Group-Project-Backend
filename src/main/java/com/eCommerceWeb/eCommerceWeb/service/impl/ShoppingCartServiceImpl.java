package com.eCommerceWeb.eCommerceWeb.service.impl;

import com.eCommerceWeb.eCommerceWeb.entity.CartItem;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.CartItemRepository;
import com.eCommerceWeb.eCommerceWeb.repository.ShoppingCartRepository;
import com.eCommerceWeb.eCommerceWeb.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private CartItemRepository itemRepository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    public ShoppingCart addItemToCart (Product product, int quantity, User user){
        ShoppingCart cart=user.getShoppingCart();

        if(cart ==  null){
             cart= new ShoppingCart();
        }
        Set<CartItem> cartItems= cart.getCartItem();
        CartItem cartItem=findCartItem(cartItems,product.getProduct_id());
        if(cartItems ==  null){
            cartItems=new HashSet<>();
            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setProduct((product));
                cartItem.setTotalPrice(quantity * product.getPrice());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                itemRepository.save(cartItem);
            }
        }else{
                if (cartItem == null) {
                    cartItem = new CartItem();
                    cartItem.setProduct((product));
                    cartItem.setTotalPrice(quantity * product.getPrice());
                    cartItem.setQuantity(quantity);
                    cartItem.setCart(cart);
                    cartItems.add(cartItem);
                    itemRepository.save(cartItem);

                }else{
                  cartItem.setQuantity(cartItem.getQuantity() + quantity);
                  cartItem.setTotalPrice(cartItem.getTotalPrice()+ quantity* product.getPrice());
                  itemRepository.save(cartItem);
                }
            cart.setCartItem(cartItems);

                int totalItems= totalItems(cart.getCartItem());
                double totalPrice= totalPrice(cart.getCartItem());

                cart.setTotalPrices(totalPrice);
                cart.setTotalItems(totalItems);
                cart.setUser(user);

                return cartRepository.save(cart);
            }

        return null;
    }
    private CartItem findCartItem(Set<CartItem> cartItems, int productId) {
        if(cartItems == null){
            return null;
        }
        CartItem cartItem=null;

        for(CartItem item : cartItems){
            if(item.getProduct().getProduct_id()==productId){
                cartItem=item;
            }
        }
        return cartItem;
    }
    private int totalItems(Set<CartItem> cartItems){
        int totalItems = 0;
        for(CartItem item : cartItems){
            totalItems += item.getQuantity();
        }
        return totalItems;
    }
    private double totalPrice(Set<CartItem> cartItems ){
         double totalPrice=0.0;

         for(CartItem item: cartItems){
                totalPrice +=item.getTotalPrice();
         }
         return totalPrice;
    }

}

