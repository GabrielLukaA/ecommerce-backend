package com.example.demo.controller;

import com.example.demo.model.entity.Store;
import com.example.demo.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {
    private final StoreService storeService;


    @PostMapping
    public Store create(@RequestBody Store store){
        return storeService.create(store);
    }

    @PutMapping
    public Store update(@RequestBody Store store){
        return storeService.update(store);
    }

    @GetMapping("/{id}")
    public Store find(@PathVariable Long id){
        return storeService.find(id);
    }

    @GetMapping
    public Collection<Store> find(){
        return storeService.find();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        storeService.delete(id);
    }

}
