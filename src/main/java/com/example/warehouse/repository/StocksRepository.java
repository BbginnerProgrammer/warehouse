package com.example.warehouse.repository;

import com.example.warehouse.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepository extends JpaRepository<Stocks, Long> {


}
