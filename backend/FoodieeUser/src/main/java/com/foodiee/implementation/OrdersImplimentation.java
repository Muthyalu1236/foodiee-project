package com.foodiee.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodiee.dao.Orders;
import com.foodiee.dto.OrdersDto;
import com.foodiee.mapper.OrderMapper;
import com.foodiee.repository.OrdersRepository;
import com.foodiee.service.OrdersService;

@Service
public class OrdersImplimentation implements OrdersService{
	
	@Autowired
	OrdersRepository ordersRepo;

	@Override
	public String createOrder(OrdersDto ordersDto) {
		
		Orders orders = OrderMapper.mapToOrder(ordersDto);
		
		ordersRepo.save(orders);
		
		return "Orders inserted.";
		
	}

	@Override
	public List<Orders> getOrders() {
		
		List<Orders> orders = ordersRepo.findAll();
		
		return orders;
		
	}

	@Override
	public String createOrders(List<OrdersDto> ordersDto) {
		List<Orders> orders = ordersDto.stream().map((orderDto)->OrderMapper.mapToOrder(orderDto)).toList();
		
		orders.stream().map((order)->ordersRepo.save(order)).toList();
		
		return "Orders inserted.";
	}

	@Override
	public List<Orders> getOrdersByUsername(String username) {
		
		List<Orders> orders = ordersRepo.findByUsername(username);
		
		
		return orders;
	}

}
