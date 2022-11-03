package com.micro.DTO;

import com.micro.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscationResponse {

	private Order order;
	private Double amount;
	private String transcationId;
	private String message;
}
