package com.riaapp.demo.services;

import com.riaapp.demo.api.v1.mapper.ShoppingListMapper;
import com.riaapp.demo.api.v1.model.ShoppingListDTO;
import com.riaapp.demo.controllers.ShoppingListController;
import com.riaapp.demo.domain.ShoppingList;
import com.riaapp.demo.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListServiceImpl implements ShoppingListService
{
    
    private final ShoppingListMapper shoppingListMapper;
    private final ShoppingListRepository shoppingListRepository;
    
    public ShoppingListServiceImpl(ShoppingListMapper shoppingListMapper, ShoppingListRepository shoppingListRepository){
        this.shoppingListMapper = shoppingListMapper;
        this.shoppingListRepository = shoppingListRepository;
    }
    
    @Override
    public List<ShoppingListDTO> getAllShoppingLists(){
        
        return shoppingListRepository.findAll()
            .stream()
            .map(shoppingListMapper::shoppingListToShoppingListDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    public ShoppingListDTO getShoppingListById(Long id){
        
        return shoppingListRepository.findById(id)
            .map(shoppingListMapper::shoppingListToShoppingListDTO)
        .orElseThrow(ResourceNotFoundException::new);
    }
    
    @Override
    public ShoppingListDTO addNewShoppingList(ShoppingListDTO shoppingListDTO){
        return saveAndReturnDTO(shoppingListMapper.shoppingListDtoToShoppingList(shoppingListDTO));
    }
    
    private ShoppingListDTO saveAndReturnDTO(ShoppingList shoppingList){
        ShoppingList savedShoppingList = shoppingListRepository.save(shoppingList);
        
        ShoppingListDTO returnDto = shoppingListMapper.shoppingListToShoppingListDTO(savedShoppingList);
        
        return returnDto;
    }
    
    @Override
    public ShoppingListDTO saveShoppingList(Long id, ShoppingListDTO shoppingListDTO){
        ShoppingList shoppingList = shoppingListMapper.shoppingListDtoToShoppingList(shoppingListDTO);
        
        shoppingList.setId(id);
        
        return saveAndReturnDTO(shoppingList);
    }
    
    @Override
    public void deleteShoppingList(Long id){
        shoppingListRepository.deleteById(id);
    }
}
