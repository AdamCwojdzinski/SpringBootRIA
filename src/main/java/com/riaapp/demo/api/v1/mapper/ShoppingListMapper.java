package com.riaapp.demo.api.v1.mapper;

import com.riaapp.demo.api.v1.model.ShoppingListDTO;
import com.riaapp.demo.domain.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingListMapper {
    
    ShoppingListMapper INSTANCE = Mappers.getMapper(ShoppingListMapper.class);
    
    ShoppingListDTO shoppingListToShoppingListDTO(ShoppingList shoppingList);
    
    ShoppingList shoppingListDtoToShoppingList(ShoppingListDTO shoppingListDTO);
    
}
