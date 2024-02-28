package com.eCommerceWeb.eCommerceWeb.controller;
import com.eCommerceWeb.eCommerceWeb.dto.ProductDTO;
import jakarta.validation.Valid;
import lombok.Data;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"", "/"})
    public String showProductList(Model model) {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("products", products);
        return "product/index";

    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);
        return "products/CreateProduct";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute ProductDTO productDTO,
            BindingResult result
    ) {
        if (productDTO.getImageFile().isEmpty()) {
            result.addError(new FieldError("productDTO", "imageFile", "The image file is required"));
        }
        if (result.hasErrors()) {
            return "products/CreateProduct";
        }

        //save image file
        MultipartFile image = productDTO.getImageFile();
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();
        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setProduct_category(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCreatedAt(createdAt);
        product.setImageFileName(storageFileName);

        productRepository.save(product);


        return "redirect:/products";
    }
    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int id
    ){

        try{
            Product product = productRepository.findById(id);
            model.addAttribute("product", product);

            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getProduct_name());
            productDTO.setCategory(product.getProduct_category());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());

            model.addAttribute("ProductDTO",productDTO);



        }catch (Exception ex){
            System.out.println("Exception: " +ex.getMessage());
            return "redirect:/product";
        }
        return "products/EditProduct";
    }









    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @GetMapping("/products")
    public Product getProduct(@RequestParam int id){
        return productRepository.findById(id);
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
