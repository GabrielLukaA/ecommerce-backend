package com.example.demo.service;

import com.example.demo.model.entity.Store;
import com.example.demo.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class StoreService {

    private StoreRepository storeRepository;

    public Store create(Store store) {
        return storeRepository.save(store);
    }

    public Store update(Store store) {
        return storeRepository.save(store);
    }

    public Store find(Long id) {
        return storeRepository.findById(id).get();
    }

    public void delete(Long id) {
        storeRepository.deleteById(id);
    }

    public Collection<Store> find() {
        return storeRepository.findAll();
    }

}
