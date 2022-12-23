package com.example.warehouse.controller;

import com.example.warehouse.entity.Orders;
import com.example.warehouse.entity.Stocks;
import com.example.warehouse.repository.OrdersRepository;
import com.example.warehouse.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class StockController {

    @Autowired
    private StocksRepository stocksRepository;
    @Autowired
    private OrdersRepository ordersRepository;


    @GetMapping("/stocks")
    public String getStocks(Model model){
        model.addAttribute("stocks", stocksRepository.findAll());
        model.addAttribute("nowDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return "stocks";
    }

    @PostMapping("/stocks" )
    public String authenticateUser(@RequestParam("start") String date, Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(date, formatter);
        List<Orders> list = ordersRepository.findAllByDate(Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        List<Stocks> stocks = stocksRepository.findAll();
        int count = stocks.size();
        if(!list.isEmpty()) {
            for (Orders orders : list){
                Stocks stocks1 = new Stocks();
                stocks1.setName(orders.getProductName());
                stocks1.setQuantity(Integer.parseInt(orders.getQuantity()));
                stocksRepository.save(stocks1);
                stocks.add(stocks1);

            }

        }
        model.addAttribute("stocks", stocks);
        Thread t = new Thread(){
            public void run(){
                for(int i = count; i < stocks.size(); i++) stocksRepository.delete(stocks.get(i));
            }
        };
        t.start();
        return "redirect:/stocks";
    }
}
