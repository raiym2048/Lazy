package com.example.lazy.service;


import com.example.lazy.models.Source;
import com.example.lazy.repository.SourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SourceServicelmpl implements  SourceService{

    private SourceRepository repository;

    @Override
    public List<Source> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Source saveProduct(Source source) {
        return repository.save(source);
    }

    @Override
    public Optional<Source> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Source getById(Long id){
        return repository.getById(id);
    }

    @Override
    public Optional<Source> findByArt(String art) {
        return repository.findByArt(art);
    }

}
