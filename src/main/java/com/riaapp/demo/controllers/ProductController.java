package com.riaapp.demo.controllers;

import com.riaapp.demo.api.v1.model.ProductListDTO;
import com.riaapp.demo.api.v1.model.ProductDTO;
import com.riaapp.demo.repositories.ProductRepository;
import com.riaapp.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController
{
    
    public static final String BASE_URL = "/api";
    
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
    
    @GetMapping({"/search"})
    @ResponseStatus(HttpStatus.OK)
    public ProductListDTO getSearchProduct (@RequestParam ("name") String search){ return new ProductListDTO(productService.getProductByName(search)); }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById (@PathVariable Long id){
        return productService.getProductById(id);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        
        return productService.saveProduct(id, productDTO);
    }
    
    @DeleteMapping({"/{id}"})
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
