package com.example.warehouse.repository;

import com.example.warehouse.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByDate(java.util.Date date);

    Orders findById(long id);

}
