package com.micro.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entity.Payment;
import com.micro.reposotiory.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	
	public Payment doPayment(Payment payment) {
		
		payment.setPaymentStatus(paymentProcessing());
		payment.setTranscationId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	
	public String paymentProcessing() {
		
		//api should be 3rd party payment gateway like paypal,paytem etc....
		
		return new Random().nextBoolean()?"Success":"false";
	}

	public Payment findPaymenthistoryByOrderId(int orderId) {
		
		return paymentRepo.findByorderId(orderId);
	}

}
