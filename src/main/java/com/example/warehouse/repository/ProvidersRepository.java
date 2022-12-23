package com.example.warehouse.repository;

import com.example.warehouse.entity.Providers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvidersRepository extends JpaRepository<Providers, Long> {

    boolean existsByNameEqualsIgnoreCase(String name);
}
