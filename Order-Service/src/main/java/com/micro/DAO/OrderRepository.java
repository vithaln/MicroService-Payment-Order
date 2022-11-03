package com.micro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
