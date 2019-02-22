package com.riaapp.demo.domain;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private Integer amount;
    private String unit;
    
    public Product() {
        super();
    }
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "SHOPPINGLISTS_ID")
    private ShoppingList shoppingList;
    
    private Product(String name, Integer amount, String unit, ShoppingList shoppingList)
    {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.shoppingList = shoppingList;
    }
    
    public Long getId() { return id; }
    
    public void setId(Long id) { this.id = id; }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getAmount()
    {
        return amount;
    }
    
    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
    
    public String getUnit()
    {
        return unit;
    }
    
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
    public ShoppingList getShoppingList()
    {
        return shoppingList;
    }
    
    public void setShoppingList(ShoppingList shoppingList)
    {
        this.shoppingList = shoppingList;
    }
}
