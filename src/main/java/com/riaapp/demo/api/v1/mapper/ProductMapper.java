package com.riaapp.demo.api.v1.mapper;

import com.riaapp.demo.api.v1.model.ProductDTO;
import com.riaapp.demo.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper{
    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    
    ProductDTO productToProductDTO(Product product);
    
    Product productDtoToProduct(ProductDTO productDTO);
}
