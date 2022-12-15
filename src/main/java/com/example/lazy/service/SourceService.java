package com.example.lazy.service;


import com.example.lazy.models.Source;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SourceService {

    List<Source> getAllProducts();

    Source saveProduct(Source source);
    Source getById(Long id);

    Optional<Source> getProductById(Long id);

    void deleteProductById(Long id);

    Optional<Source> findByArt(String art);
}
