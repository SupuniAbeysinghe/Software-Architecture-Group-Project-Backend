package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shopping_cart_id")
    private Long cid;
    private int totalItems;
    private double totalPrices;
    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn(name="id", referencedColumnName="id")
    private User user;

    @OneToMany(cascade= CascadeType.ALL,mappedBy = "cart")
    private Set<CartItem> cartItem;



}
