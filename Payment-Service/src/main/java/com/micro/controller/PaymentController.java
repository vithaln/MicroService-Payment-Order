package com.micro.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entity.Payment;
import com.micro.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/dopayment")
	public Payment doPayment(@RequestBody Payment payment) {
		
		return paymentService.doPayment(payment);
	}
	
	@GetMapping("/{orderId}")
	public Payment findPaymenthistoryByOrderId(@PathVariable int orderId) {
		
		return paymentService.findPaymenthistoryByOrderId(orderId);
		
	}

	
}
