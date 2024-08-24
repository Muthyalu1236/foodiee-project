package com.foodiee.service;

import java.util.List;

import com.foodiee.dto.OrdersDto;

public interface OrdersService {
	
	String createOrder(OrdersDto ordersDto);
	
	String createOrders(List<OrdersDto> ordersDto);
	
	List<OrdersDto> getOrders();
	
	List<OrdersDto> getOrdersByUsername(String username);

}
