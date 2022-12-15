package com.example.lazy.repository;

import com.example.lazy.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Optional<Source> findByArt(String art);
    Source getById(Long id);

}
