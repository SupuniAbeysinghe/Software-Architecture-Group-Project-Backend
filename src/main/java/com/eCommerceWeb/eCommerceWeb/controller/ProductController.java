package com.eCommerceWeb.eCommerceWeb.controller;
import com.eCommerceWeb.eCommerceWeb.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import com.eCommerceWeb.eCommerceWeb.service.CategoryService;
import com.eCommerceWeb.eCommerceWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
        List<Product> products = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("products", products);
        return "product/index";

    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);
        return "products/CreateProduct";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute ProductDTO productDTO,
            BindingResult result
    ){
        if (productDTO.getImageFile().isEmpty()){
            result.addError(new FieldError("productDTO","imageFile","The image file is required"));
        }
        if(result.hasErrors()){
            return "products/CreateProduct";
        }
        return "redirect:/products";
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
