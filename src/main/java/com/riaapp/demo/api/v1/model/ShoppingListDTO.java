package com.riaapp.demo.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListDTO {
    private Long id;
    private String name;
    private Integer status;
    
    //@JsonProperty("shoppingList_url")
    //private String shoppingListUrl;
}
