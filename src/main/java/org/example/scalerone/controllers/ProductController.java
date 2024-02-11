package org.example.scalerone.controllers;

import org.example.scalerone.models.Product;
import org.example.scalerone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // Three types of Injection
    // 1. Constructor Injection - GOOD
    // 2. Field Injection - not recommended, not readable or understandable code
    // 3. Setter Injection - not recommended, during unit testing, any calls before Setter
    // , can cause Null Pointer Exception

    // Field Injection Example
//    @Autowired
//    private ProductService productService;

    // Constructor Injection
//    @Autowired
//    public ProductController(ProductService productService){
//        this.productService = productService;
//    }

    // Setter Injection
//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    @Autowired
    public ProductController(@Qualifier("FakeProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        //return "Fetch using getProductById for id # " + id;
        System.out.println("Inside Prod Controller : getProductById");
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<String> getAllProducts(){
        return Collections.emptyList();
    }
}
