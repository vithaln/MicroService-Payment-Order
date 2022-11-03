package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.DAO.OrderRepository;
import com.micro.DTO.Payment;
import com.micro.DTO.TranscationRequest;
import com.micro.DTO.TranscationResponse;
import com.micro.entity.Order;

@Service
@RefreshScope
public class OdersService {
	
	@Autowired
	@Lazy
	private RestTemplate resttemplate;
	@Autowired
	private OrderRepository orderrepo;
	
	//@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	 //@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	//private String PAYMENT_ENDPOINT_URL;
	
	public TranscationResponse saveOrder(TranscationRequest request) {
		
		String response="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getOrderId());
		payment.setAmount(order.getPrice());
		
		//rest call
	//Payment paymentResponse = resttemplate.postForObject("http://PAYMENT-SERVICE/payment/dopayment", payment, Payment.class);
		Payment paymentResponse = resttemplate.postForObject("http://PAYMENT-SERVICE/payment/dopayment", payment, Payment.class);

	response=paymentResponse.getPaymentStatus().equals("Success")?"payment processing succesful and order placed":"there is a failure in payment API,order added to cart";
		orderrepo.save(order);
		
		return new TranscationResponse(order,paymentResponse.getAmount(),paymentResponse.getTranscationId(),response);
	}

}
