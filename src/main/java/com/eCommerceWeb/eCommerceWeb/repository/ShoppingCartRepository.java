package com.eCommerceWeb.eCommerceWeb.repository;

import com.eCommerceWeb.eCommerceWeb.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
