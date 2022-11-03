package com.micro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	
	@Id
	private int orderId;
	private String name;
	private int qty;
	private Double price;

}
