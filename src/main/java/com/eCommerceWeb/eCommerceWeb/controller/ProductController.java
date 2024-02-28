package com.eCommerceWeb.eCommerceWeb.controller;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import com.eCommerceWeb.eCommerceWeb.service.CategoryService;
import com.eCommerceWeb.eCommerceWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping({"","/"})
    public String showProductList(Model model){
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "product/index";

    }


    public ProductController(ProductRepository productRepository){
        this.repo=productRepository;
    }
    @GetMapping("/products")
    public Product getProduct(@RequestParam int id){
        return repo.findById(id);
    }

//for searching products
//    @Autowired
//    ProductService productService;
//    @GetMapping("/products/search")
//    public List<Product> getAllProducts(
//                                        @RequestParam(defaultValue = "") String searchKey){
//        return productService.getAllProducts(searchKey);
//    }
//
//    @PostMapping("/products")
//    public void addProduct(@RequestBody Product product){
//        productRepository.save(product);
//    }


//for filter products
    @Autowired
     CategoryService categoryService;


     @GetMapping("/products/category")
     public List<Product> getProductsByCategory(
                                               @RequestParam(defaultValue = "") String catKey){
         return categoryService.getProductsByCategoryName(catKey);
}

}
