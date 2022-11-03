package com.micro.DTO;

import com.micro.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranscationRequest {

	
	private Payment payment;
	private Order order;
}
