package com.eCommerceWeb.eCommerceWeb.controller;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import com.eCommerceWeb.eCommerceWeb.service.CategoryService;
import com.eCommerceWeb.eCommerceWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

//for searching products
    @Autowired
    ProductService productService;
    @GetMapping("/products/search")
    public List<Product> getAllProducts(
                                        @RequestParam(defaultValue = "") String searchKey){
        return productService.getAllProducts(searchKey);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productRepository.save(product);
    }


//for filter products
    @Autowired
     CategoryService categoryService;


     @GetMapping("/products/category")
     public List<Product> getProductsByCategory(
                                               @RequestParam(defaultValue = "") String catKey){
         return categoryService.getProductsByCategoryName(catKey);
}

}