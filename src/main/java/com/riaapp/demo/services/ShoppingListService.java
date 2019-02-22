package com.riaapp.demo.services;

import com.riaapp.demo.api.v1.model.ShoppingListDTO;

import java.util.List;

public interface ShoppingListService {
    
    List<ShoppingListDTO> getAllShoppingLists();
    
    ShoppingListDTO getShoppingListById(Long id);
    
    ShoppingListDTO addNewShoppingList(ShoppingListDTO shoppingListDTO);
    
    ShoppingListDTO saveShoppingList(Long id, ShoppingListDTO shoppingListDTO);
    
    void deleteShoppingList(Long id);
    
    
    
}
