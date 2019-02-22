package com.riaapp.demo.repositories;

import com.riaapp.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product findByName(String name);
}
