package com.riaapp.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="shoppinglists")
public class ShoppingList
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private Integer status;
    
    public ShoppingList() {
        super();
    }
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
               cascade = {
                        CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH,
               })
    private Set<Product> products = new HashSet<>();
    
    public ShoppingList(Long id, String name, Integer status){
        this.id = id;
        this.name = name;
        this.status = status;
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
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    public Set<Product> getProducts()
    {
        return products;
    }
    
    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }
}
