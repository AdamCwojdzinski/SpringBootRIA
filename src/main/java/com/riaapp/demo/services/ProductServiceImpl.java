package com.riaapp.demo.services;

import com.riaapp.demo.api.v1.mapper.ProductMapper;
import com.riaapp.demo.api.v1.model.ProductDTO;
import com.riaapp.demo.domain.Product;
import com.riaapp.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    
    private ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository)
    {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }
    
    @Override
    public List<ProductDTO> getAllProduct()
    {
        return productRepository.findAll()
                                .stream()
                                .map(productMapper::productToProductDTO)
                                .collect(Collectors.toList());
    }
    
    private ProductDTO saveAndReturnDTO(Product product){
        Product savedProduct = productRepository.save(product);
        
        ProductDTO returnDto = productMapper.productToProductDTO(savedProduct);
        
        return returnDto;
    }
    
    @Override
    public ProductDTO addNewProduct(ProductDTO productDTO) { return saveAndReturnDTO(productMapper.productDtoToProduct(productDTO)); }
    
    @Override
    public ProductDTO saveProduct(Long id, ProductDTO productDTO){
        Product product = productMapper.productDtoToProduct(productDTO);
        product.setId(id);
        return saveAndReturnDTO(product);
    }
    
    @Override
    public void deleteProduct(Long id){ productRepository.deleteById(id); }
}
