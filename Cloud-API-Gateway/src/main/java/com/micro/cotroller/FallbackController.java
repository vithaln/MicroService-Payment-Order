package com.micro.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/fallBackOrder")
	public Mono<String> fallBackOrder(){
		
		return Mono.just("order service too long time give respond or else it's down now, please try later!");
	}

	@RequestMapping("/fallBackPayment")
	public Mono<String> fallBackPayment(){
		
		return Mono.just("Payment service too long time give respond or else it's down now, please try later!");
	}
}
