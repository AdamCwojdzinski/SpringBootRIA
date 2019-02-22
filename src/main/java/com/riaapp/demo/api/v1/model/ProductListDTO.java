package com.riaapp.demo.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductListDTO {
    
    List<ProductDTO> products;
    
}
