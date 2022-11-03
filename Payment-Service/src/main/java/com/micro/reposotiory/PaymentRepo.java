package com.micro.reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

	Payment findByorderId(int orderId);

}
