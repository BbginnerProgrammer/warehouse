package com.example.warehouse.service.ServiceImpl;

import com.example.warehouse.entity.Orders;
import com.example.warehouse.repository.OrdersRepository;
import com.example.warehouse.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void addOrder(Orders order) {
        ordersRepository.save(order);
    }
}
