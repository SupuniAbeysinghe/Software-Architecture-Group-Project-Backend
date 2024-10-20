package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
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
