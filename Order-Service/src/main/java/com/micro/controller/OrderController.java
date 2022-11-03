package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.DTO.Payment;
import com.micro.DTO.TranscationRequest;
import com.micro.DTO.TranscationResponse;
import com.micro.entity.Order;
import com.micro.service.OdersService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OdersService orderservice;
	
	@PostMapping("/bookorder")
	public TranscationResponse bookOrder(@RequestBody TranscationRequest request) {
		
		
		
		return orderservice.saveOrder(request);
		
		//do a rest call to payment and pass the orederId
	}

}
