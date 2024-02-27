package com.eCommerceWeb.eCommerceWeb.repository;

import com.eCommerceWeb.eCommerceWeb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByCategories_Name(String categoryName);



@Query("SELECT p FROM Product p WHERE lower(p.product_name) LIKE %:key1% OR lower(p.description) LIKE %:key2%")
public List<Product> findByProductNameOrDescriptionContainingIgnoreCase(@Param("key1") String key1, @Param("key2") String key2);
}


