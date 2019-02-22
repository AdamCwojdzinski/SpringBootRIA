package com.riaapp.demo.controllers;

import com.riaapp.demo.api.v1.model.ShoppingListDTO;
import com.riaapp.demo.api.v1.model.ShoppingListListDTO;
import com.riaapp.demo.services.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(ShoppingListController.BASE_URL)
public class ShoppingListController {
    
    public static final String BASE_URL = "/api";
    
    private final ShoppingListService shoppingListService;
    
    public ShoppingListController(ShoppingListService shoppingListService){this.shoppingListService = shoppingListService;}
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListListDTO showAllShoppingList(){
        return new ShoppingListListDTO(shoppingListService.getAllShoppingLists());
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListDTO getShoppingListById (@PathVariable Long id){
        return shoppingListService.getShoppingListById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO addNewShoppingList(@RequestBody ShoppingListDTO shoppingListDTO){
        return shoppingListService.addNewShoppingList(shoppingListDTO);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListDTO updateShoppingList(@PathVariable Long id, @RequestBody ShoppingListDTO shoppingListDTO){
        return shoppingListService.saveShoppingList(id, shoppingListDTO);
    }
    
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingList(@PathVariable Long id){
        shoppingListService.deleteShoppingList(id);
    }
}
