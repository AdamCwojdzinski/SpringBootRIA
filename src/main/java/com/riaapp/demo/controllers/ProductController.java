package com.riaapp.demo.controllers;

import com.riaapp.demo.api.v1.model.ProductListDTO;
import com.riaapp.demo.api.v1.model.ProductDTO;
import com.riaapp.demo.repositories.ProductRepository;
import com.riaapp.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController
{
    
    public static final String BASE_URL = "/api/product";
    
    private final ProductService productService;
    private final ProductRepository productRepository;
    
    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListDTO getAllProduct(){
        return new ProductListDTO(productService.getAllProduct());
    }
    
    //get id
    
    @PutMapping(BASE_URL + "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.saveProduct(id, productDTO);
    }
    
    @DeleteMapping(BASE_URL + "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id){
       productService.deleteProduct(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addNewProduct(@RequestBody ProductDTO productDTO){
        return productService.addNewProduct(productDTO);
    }
}