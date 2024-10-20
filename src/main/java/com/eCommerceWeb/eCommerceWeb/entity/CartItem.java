package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_detail_id")
    private Long cid;
    private int quantity;
    private double totalPrice;

    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="shopping_cart_id", referencedColumnName="shopping_cart_id")
    private ShoppingCart cart;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn(name="product_id", referencedColumnName="product_id")
    private Product product;
}
