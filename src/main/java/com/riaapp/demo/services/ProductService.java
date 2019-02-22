package com.riaapp.demo.services;

import com.riaapp.demo.api.v1.model.ProductDTO;

import java.util.List;

public interface ProductService {
    
    List<ProductDTO> getAllProduct();
    
    ProductDTO addNewProduct(ProductDTO productDTO);
    
    ProductDTO saveProduct(Long id, ProductDTO productDTO);
    
    void deleteProduct(Long id);
}
