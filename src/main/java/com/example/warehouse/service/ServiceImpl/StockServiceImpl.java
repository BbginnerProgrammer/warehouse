package com.example.warehouse.service.ServiceImpl;

import com.example.warehouse.entity.Stocks;
import com.example.warehouse.repository.StocksRepository;
import com.example.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {


    @Autowired
    private StocksRepository stocksRepository;

    @Override
    public void addStock(Stocks stocks) {
        stocksRepository.save(stocks);
    }
}
