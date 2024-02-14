package com.example.demo.controller;

import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    
    
    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }
    
    @GetMapping("/{id}")
    public Product find(@PathVariable Long id){
        return productService.find(id);
    }
    
    @GetMapping
    public Collection<Product> find(){
        return productService.find();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
    
}
