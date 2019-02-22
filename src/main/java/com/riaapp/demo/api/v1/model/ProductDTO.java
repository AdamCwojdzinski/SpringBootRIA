package com.riaapp.demo.api.v1.model;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer amount;
    private String unit;
}
