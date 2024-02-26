package com.eCommerceWeb.eCommerceWeb.controller;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import com.eCommerceWeb.eCommerceWeb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @GetMapping("/products")
    public Product getProduct(@RequestParam int id){
        return productRepository.findById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productRepository.save(product);
    }

    @Autowired
     CategoryService categoryService;

    @GetMapping("/products/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String categoryName) {
        List<Product> products = categoryService.getProductsByCategoryName(categoryName);
        return ResponseEntity.ok(products);
    }
}
