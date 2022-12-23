package com.example.warehouse.controller;

import com.example.warehouse.entity.Orders;
import com.example.warehouse.entity.Stocks;
import com.example.warehouse.repository.OrdersRepository;
import com.example.warehouse.repository.ProductsRepository;
import com.example.warehouse.repository.ProvidersRepository;
import com.example.warehouse.repository.StocksRepository;
import com.example.warehouse.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private StocksRepository stocksRepository;

    @GetMapping("/orders")
    public String orders(Model model){
        List<Orders> orders = ordersRepository.findAll();
        LocalDate today = LocalDate.now();

        for(Orders order : orders){
            if(today.isEqual(order.getDate().toLocalDate()) || today.isAfter(order.getDate().toLocalDate())){
                Orders or = ordersRepository.getReferenceById(order.getId());
                Stocks stock = new Stocks(or.getProductName(), Integer.parseInt(or.getQuantity()));
                stocksRepository.save(stock);
                ordersRepository.delete(or);
            }
        }
        model.addAttribute("orders", ordersRepository.findAll());
        return "orders";
    }

    @PostConstruct
    private void checkTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date1 = LocalDate.now();
        Date date = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Orders> list = ordersRepository.findAllByDate(date);
        if(!list.isEmpty()) {
            for (Orders orders : list){
                Stocks stocks = new Stocks();
                stocks.setName(orders.getProductName());
                stocks.setQuantity(Integer.parseInt(orders.getQuantity()));
                stocksRepository.save(stocks);
                ordersRepository.delete(orders);
            }

        }


    }

    @GetMapping("/orders/add")
    public String addOrders(Model model){
        Orders order = new Orders();
        model.addAttribute("order", order);
        model.addAttribute("productsName", productsRepository.findAll());
        model.addAttribute("providers", providersRepository.findAll());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        model.addAttribute("nowDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return "addOrder";
    }

    @PostMapping("/orders/add")
    public String addOrders(@Valid Orders orders,
                            BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){
            Map<String, String> errMap = ControllerUtils.getErrors(bindingResult);
            model.addAttribute(errMap);
            model.addAttribute("message", orders);
        }else{
            model.addAttribute("message", null);

            ordersService.addOrder(orders);
            ordersRepository.save(orders);
        }

        return "redirect:/orders";
    }

    @GetMapping("/orders/cancel")
    public String ordersCaancel(){
        return "redirect:/orders";
    }



}
