package com.foodiee.service;

import java.util.List;

import com.foodiee.dao.Orders;
import com.foodiee.dto.OrdersDto;

public interface OrdersService {
	
	String createOrder(OrdersDto ordersDto);
	
	String createOrders(List<OrdersDto> ordersDto);
	
	List<Orders> getOrders();
	
	List<Orders> getOrdersByUsername(String username);

}
